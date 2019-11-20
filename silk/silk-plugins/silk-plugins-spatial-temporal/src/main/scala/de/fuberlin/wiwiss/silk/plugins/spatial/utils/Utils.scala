/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.silkframework.plugins.spatial.utils

import java.util.logging.{Level, Logger}

import com.vividsolutions.jts.geom.Geometry
import com.vividsolutions.jts.operation.distance.DistanceOp.nearestPoints
import com.vividsolutions.jts.simplify.{DouglasPeuckerSimplifier, TopologyPreservingSimplifier}
import org.geotools.geometry.jts.JTS.{orthodromicDistance, transform}
import org.geotools.referencing.CRS.{decode, findMathTransform}
import org.silkframework.entity.Index

/**
 * Useful utils for the spatial plugins of Silk.
 * @author Panayiotis Smeros <psmeros@di.uoa.gr> (National and Kapodistrian University of Athens)
 */

object Utils {

  private val logger = Logger.getLogger(this.getClass.getName)

  /**
   * This function transforms a geometry expressed in stSPARQL or GeoSPARQL from any serialization (WKT or GML) and any Coordinate Reference System (CRS) to WKT and WGS 84 (latitude-longitude).
   * In case that the literal is not a geometry, it is returned as it is.
   *
   * @param literal : String
   * @return WKTLiteral || literal : String
   */
  def stSPARQLGeoSPARQLTransformer(literal: String): String = {

    val logger = Logger.getLogger(this.getClass.getName)

    var geometry = null.asInstanceOf[Geometry]
    var (geometryString, srid) = Parser.separateGeometryFromSRID(literal)

    try {
      srid match {
        case Constants.DEFAULT_SRID =>
          //Default SRID => no need for transformation.
          return geometryString
        case -1 =>
          geometry = Parser.GMLReader(geometryString)
        case _ =>
          geometry = Parser.WKTReader(geometryString, srid)
      }
    } catch {
      case e: Exception =>
        logger.log(Level.ALL, "Parse Error. Returning literal as it is.")
        return literal
    }

    if (geometry == null) {
      logger.log(Level.ALL, "Null Geometry. Returning literal as it is.")
      return literal
    }

    //Convert geometry to default SRID.
    try {
      val sourceCRS = decode("EPSG:" + geometry.getSRID())
      val targetCRS = decode("EPSG:" + Constants.DEFAULT_SRID)
      val mathTransform = findMathTransform(sourceCRS, targetCRS, true)

      return transform(geometry, mathTransform).toText()
    } catch {
      case e: Exception =>
        logger.log(Level.ALL, "Tranformation Error. Returning literal as it is.")
        return literal
    }
  }

  /**
   * This function transforms a geometry expressed in the W3C Geo Vocabulary to WKT.
   * It concatenates appropriately the values "lat" and "long" to create a single Point.
   * This point is already in WGS 84 (latitude-longitude) CRS, so there is no need for transformation.
   *
   * @param lat  : Any
   * @param long : Any
   * @return POINT (lat, long) : String
   */
  def w3cGeoTransformer(lat: Any, long: Any): String = {

    Parser.latLongConcat(lat, long)
  }

  /**
   * This function transforms a cluster of points to their centroid.
   *
   * @param points: Seq[Seq[String]]
   * @return Set[String]
   */
  def pointsToCentroidTransformer(points: Seq[Seq[String]]): Seq[String] = {

    val Seq(set1, set2) = points
    val iterator1 = set1.iterator
    val iterator2 = set2.iterator
    var lat = 0.0
    var long = 0.0

    //Computes the centroid.
    try {
      while (iterator1.hasNext)
        lat += iterator1.next.toFloat
      while (iterator2.hasNext)
        long += iterator2.next.toFloat

      lat /= set1.iterator.size
      long /= set2.iterator.size

      Seq(Parser.latLongConcat(lat, long))
    } catch {
      case e: Exception =>
        logger.log(Level.ALL, "Cast Error. Returning literal as it is.")
        points.reduce(_ ++ _)
    }
  }

  /**
   * This function returns the Envelope of a Geometry.
   *
   * @param geometryString : String
   * @return String
   */
  def getEnvelopeFromGeometry(geometryString: String): String = {
    try {
      Parser.WKTReader(geometryString, Constants.DEFAULT_SRID).getEnvelope().toText()
    } catch {
      case e: Exception =>
        geometryString
    }
  }

  /**
   * This function returns a Geometry with a computed buffer area.
   *
   * @param geometryString : String
   * @param distance : Double
   * @return String
   */
  def getBufferedGeometry(geometryString: String, distance : Double): String = {
    try {
      Parser.WKTReader(geometryString, Constants.DEFAULT_SRID).buffer(distance).toText()
    } catch {
      case e: Exception =>
        geometryString
    }
  }  
  
  /**
   * This function returns the Area of a Geometry.
   *
   * @param geometryString : String
   * @return String
   */
  def getAreaFromGeometry(geometryString: String): String = {
    try {
      Parser.WKTReader(geometryString, Constants.DEFAULT_SRID).getArea().toString
    } catch {
      case e: Exception =>
        geometryString
    }
  }

  /**
   * This function simplifies a Geometry.
   *
   * @param geometryString : String
   * @param distanceTolerance: Double
   * @return String
   */
  def simplifyGeometry(geometryString: String, distanceTolerance: Double, preserveTopology: Boolean): String = {
    try {
      val geometry = Parser.WKTReader(geometryString, Constants.DEFAULT_SRID)
      if (preserveTopology)
        TopologyPreservingSimplifier.simplify(geometry, distanceTolerance).toText()
      else
        DouglasPeuckerSimplifier.simplify(geometry, distanceTolerance).toText()
    } catch {
      case e: Exception =>
        geometryString
    }
  }

  /**
   * This function indexes Geometries by their Envelope.
   *
   * @param geometryString : String
   * @param blockingParameter: Double
   * @param distance: Double (optional; for distance measures)
   * @return Index
   */
  def indexGeometriesByEnvelope(geometryString: String, blockingParameter: Double, distance: Double = 0.0): Index = {
    try {
      val geometry = Parser.WKTReader(geometryString, Constants.DEFAULT_SRID)
      val envelope = geometry.getEnvelopeInternal()
      
      if (distance != 0.0)
        envelope.expandBy((distance / Constants.EARTH_CIRCUMFERENCE_EQUATORIAL) * Constants.LONG_RANGE, (distance / Constants.EARTH_CIRCUMFERENCE_MERIDIONAL) * Constants.LAT_RANGE)

      val blockCountLat = (Constants.LAT_RANGE*blockingParameter).toInt
      val blockCountLong = (Constants.LONG_RANGE*blockingParameter).toInt

      val minLatBlock = (envelope.getMinY()*blockingParameter).toInt
      val maxLatBlock = (envelope.getMaxY()*blockingParameter).toInt
      val minLongBlock = (envelope.getMinX()*blockingParameter).toInt
      val maxLongBlock = (envelope.getMaxX()*blockingParameter).toInt

      val latBlocks = (for (i <- minLatBlock to maxLatBlock) yield i).toSet
      val longBlocks = (for(i <- minLongBlock to maxLongBlock) yield i).toSet

      Index.oneDim(latBlocks, blockCountLat) conjunction Index.oneDim(longBlocks, blockCountLong)

    } catch {
      case e: Exception =>
        Index.empty
    }
  }

  /**
   * This function evaluates a distance between two Geometries.
   *
   * @param geometryString1 : String
   * @param geometryString2 : String
   * @param limit: Double
   * @param distanceType: String
   * @return Double
   */
  def evaluateDistance(geometryString1: String, geometryString2: String, limit: Double, distanceType: String): Double = {
    try {
      //Get the geometries.
      val geometry1 = Parser.WKTReader(geometryString1, Constants.DEFAULT_SRID)
      val geometry2 = Parser.WKTReader(geometryString2, Constants.DEFAULT_SRID)

      distanceType match {
        case Constants.CENTROID_DISTANCE =>
          val normalizedDistance = orthodromicDistance(geometry1.getCentroid().getCoordinate(), geometry2.getCentroid().getCoordinate(), decode("EPSG:" + Constants.DEFAULT_SRID)) / limit
          if (normalizedDistance <= 1.0)
            return normalizedDistance
          else
            return Double.PositiveInfinity
        case Constants.MIN_DISTANCE =>
          val points = nearestPoints(geometry1, geometry2)
          val normalizedDistance = orthodromicDistance(points(0), points(1), decode("EPSG:" + Constants.DEFAULT_SRID)) / limit
          if (normalizedDistance <= 1.0)
            return normalizedDistance
          else
            return Double.PositiveInfinity
        case _ => Double.PositiveInfinity
      }

    } catch {
      case e: Exception =>
        Double.PositiveInfinity
    }
  }

  /**
   * This function evaluates a relation between two Geometries.
   *
   * @param geometryString1 : String
   * @param geometryString2 : String
   * @param limit: Double
   * @param relation: String
   * @return Double
   */
  def evaluateRelation(geometryString1: String, geometryString2: String, limit: Double, relation: String): Double = {
    try {
      //Get the geometries.
      val geometry1 = Parser.WKTReader(geometryString1, Constants.DEFAULT_SRID)
      val geometry2 = Parser.WKTReader(geometryString2, Constants.DEFAULT_SRID)

      //Compute the spatial relation.
      if (relate(geometry1, geometry2, relation))
        limit
      else
        Double.PositiveInfinity

    } catch {
      case e: Exception =>
        Double.PositiveInfinity
    }
  }

  def negatsRelation(geometryString1: String, geometryString2: String, limit: Double, relation: String): Double = {
    try {
      //Get the geometries.
      val geometry1 = Parser.WKTReader(geometryString1, Constants.DEFAULT_SRID)
      val geometry2 = Parser.WKTReader(geometryString2, Constants.DEFAULT_SRID)

      //Compute the spatial relation and negate it.
      if (relate(geometry1, geometry2, relation))
        Double.PositiveInfinity
      else
        limit

    } catch {
      case e: Exception => limit
    }
  }

  /**
   * This function returns true if the given relation holds between two geometries.
   *
   * @param geometry1 : Geometry
   * @param geometry2 : Geometry
   * @param relation: String
   * @return Boolean
   */
  def relate(geometry1: Geometry, geometry2: Geometry, relation: String): Boolean = {
    relation match {
      case Constants.EQUALS => geometry1.equals(geometry2)
      case Constants.DISJOINT => geometry1.disjoint(geometry2)
      case Constants.INTERSECTS => geometry1.intersects(geometry2)
      case Constants.TOUCHES => geometry1.touches(geometry2)
      case Constants.CROSSES => geometry1.crosses(geometry2)
      case Constants.WITHIN => geometry1.within(geometry2)
      case Constants.CONTAINS => geometry1.contains(geometry2)
      case Constants.OVERLAPS => geometry1.overlaps(geometry2)
      case _ => geometry1.relate(geometry2, relation)
    }
  }
}
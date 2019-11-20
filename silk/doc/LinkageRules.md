# Linkage Rules

Linkage rules are represented as trees, which are built from four types of operators:

- **Path Operator:** Retrieves all values of a specific property path of each entity, such as its label property.
  The purpose of the property operator is to enable the access of values from the data set that are used as input for other operators.
- **Transformation Operator:** Transforms the values of a set of property or transformation operators according to a specific data transformation function.
  Examples of transformation functions include case normalization, tokenization, and concatenation of values from multiple operators.
  Multiple transformation operators can be nested in order to apply a chain of transformations.
- **Comparison Operator:** Evaluates the similarity between two entities based on the values that are returned by two property or transformation operators by applying a distance measureand a distance threshold. 
  Examples of distance measures include Levenshtein, Jaccard, or geographic distance. 
- **Aggregation Operator:** Due to the fact that, in most cases, the similarity of two entities cannot be determined by evaluating a single comparison, an aggregation operator combines the similarity scores from multiple comparison or aggregation operators into a single score according to a specific aggregation function.
  Examples of common aggregation functions include the weighted average or yielding the minimum score of all operators.

## Path Inputs

An path input retrieves all values which are connected to the entities by a specific path.
Every path statement begins with a variable (as defined in the datasets), which may be followed by a series of path elements. If a path cannot be resolved due to a missing property or a too restrictive filter, an empty result set is returned.

The following operators can be used to traverse the graph:

---------------------------------------------------------------------------------------------------------------------
Operator Name             Use                               Description
-------- ---------------- --------------------------------- ---------------------------------------------------------
/        forward          `<path_segment>/<property>`       Moves forward from a subject resource (set) through a
         operator                                           property to its object resource (set).

\\       reverse          `<path_segment>\<property>`       Moves backward from an object resource (set) through a
         operator                                           property to its subject resource (set).

[ ]      filter           `<path_segment>`                  Reduces the currently selected set of resources to the ones
         operator         `[<property> <comp_operator>`     matching the filter expression. comp\_operator may be one of
                          `<value>]`                        &gt;, <, >=, &lt;=, =, !=
                          `<path_segment>[@lang`
                          `<comp_operator> <value>]`

---------------------------------------------------------------------------------------------------------------------

### Examples

#### XML

**Select the English label of a movie**

    <Input path="?movie/rdfs:label[@lang = 'en']" />

**Select the label (set) of the director(s) of a movie**

    <Input path="?movie/dbpedia:director/rdfs:label" />

**Select the albums of a given artist (albums have an dbpedia:artist property)**

    <Input path="?artist\dbpedia:artist[rdf:type = dbpedia:Album]" />

#### Scala API

**Select the English label of a movie**

    Path.parse("?movie/rdfs:label[@lang = 'en']")

**Select the label (set) of the director(s) of a movie**

    Path.parse("?movie/dbpedia:director/rdfs:label")

**Select the albums of a given artist (albums have an dbpedia:artist property)**

    Path.parse("?artist\dbpedia:artist[rdf:type = dbpedia:Album]")
    
## Transformations
    
As different datasets usually use different data formats, a transformation can be used to normalize the values prior to comparison.
    
## Comparisons
   
A comparison operator evaluates two inputs and computes the *similarity* based on a user-defined *distance measure* and a user-defined *threshold*. 

The *distance measure* always outputs 0 for a perfect match, and a higher value for an imperfect match. Only distance values between 0 and _threshold_ will result in a positive similarity score. Therefore it is important to know how the distance measures work and what the range of their output values is in order to set a threshold value sensibly.

### Parameters

The following default parameters can be set for each comparison:

----------------------------------------------------------------------------------------------------------------------
Parameter            Description
-------------------- -------------------------------------------------------------------------------------------------
required (optional)  If required is true, the parent aggregation only yields a confidence value if the given inputs
                     have values for both instances.

weight (optional)    Weight of this comparison. The weight is used by some aggregations such as the weighted average
                     aggregation.

threshold            The maximum distance. For normalized distance measures, the threshold should be between 0.0 and 1.0.

distanceMeasure      The used distance measure. For a list of available distance measures see below.

Inputs               The 2 inputs for the comparison.

----------------------------------------------------------------------------------------------------------------------

The threshold is used to convert the computed distance to a confidence between -1.0 and 1.0. Links will be generated for confidences above 0 while higher confidence values imply a higher similarity between the compared entities.

![Threshold](img/linking_threshold.png)

If distance measures generate multiple distance scores the lowest is used to generate the confidence.

### Character-Based Distance Measures

Character-based distance measures compare strings on the character level. They are well suited for handling typographical errors.

----------------------------------------------------------------------------------------------------------------------
Measure                 Normalized    Description
----------------------- ------------- --------------------------------------------------------------------------------
levenshteinDistance     No            Levenshtein distance. The minimum number of edits needed to transform one string
                                      into the other, with the allowable edit operations being insertion, deletion, or
                                      substitution of a single character (Normalized: No)

levenshtein             Yes           The levensthein distance normalized to the interval \[0,1\] (Normalized: Yes)

jaro                    Yes           Jaro distance metric. Simple distance metric originally developed to compare person
                                      names

jaroWinkler             Yes           Jaro-Winkler distance measure. The Jaro–Winkler distance metric is designed and best
                                      suited for short strings such as person names

equality                Yes           0 if strings are equal, 1 otherwise

inequality              Yes           1 if strings are equal, 0 otherwise

----------------------------------------------------------------------------------------------------------------------

Example:

    <Compare metric="levenshteinDistance" threshold="2">
      <Input path="?a/rdfs:label" />
      <Input path="?b/gn:name" />
    </Compare>

### Token-Based Distance Measures

While character-based distance measures work well for typographical
errors, there are a number of tasks where token-base distance measures are better suited:

-   Strings where parts are reordered e.g. “John Doe” and “Doe, John”
-   Texts consisting of multiple words

----------------------------------------------------------------------------------------------------------------------
Measure                 Normalized    Description
----------------------- ------------- --------------------------------------------------------------------------------
jaccard                 Yes           Jaccard distance coefficient

dice                    Yes           Dice distance coefficient

softjaccard             Yes           Soft Jaccard similarity coefficient. Same as Jaccard distance but values within
                                      an levenhstein distance of `maxDistance` are considered equivalent

----------------------------------------------------------------------------------------------------------------------

Example:

    <Compare metric="jaccard" threshold="0.2">
      <TransformInput function="tokenize">
        <Input path="?a/rdfs:label" />
      </TransformInput>
      <TransformInput function="tokenize">
        <Input path="?b/gn:name" />
      </TransformInput>
    </Compare>      
      
### Special Purpose Distance Measures

A number of distance measures are available that are designed to compare specific types of data, e.g., numeric values.

----------------------------------------------------------------------------------------------------------------------
Measure                 Normalized    Description
----------------------- ------------- --------------------------------------------------------------------------------
num(float minValue,     No            Computes the numeric difference between two numbers. Parameters:
float maxValue)                       `minValue` and `maxValue` The minimum and maximum values which occur in the datasource
                                         
date                    No            Computes the distance between two dates (`YYYY-MM-DD` format).
                                      Returns the difference in days

dateTime                No            Computes the distance between two date time values (`xsd:dateTime` format).
                                      Returns the difference in seconds

wgs84(string unit,
string curveStyle)      No            Computes the geographical distance between two points. Parameters: `unit` The unit
                                      in which the distance is measured. Allowed values: `meter` or `m` (default), 
                                      `kilometer` or `km`. Author: Konrad Höffner (MOLE subgroup of Research Group AKSW,
                                      University of Leipzig)

----------------------------------------------------------------------------------------------------------------------

**Example:**

    <Compare metric="wgs84" threshold="50">
      <Input path="?a/wgs84:geometry" />
      <Input path="?b/wgs84:geometry" />
      <Param name="unit" value="km"/>
    </Compare>
    
## Aggregations

An aggregation combines multiple confidence values into a single value. In order to determine if two entities are duplicates it is usually not sufficient to compare a single property. For instance, when comparing geographic entities, an aggregation may aggregate the similarities between the names of the entities and the similarities based on the distance between the entities.

### Parameters

**Required (Optional)**

The required attribute can be set if the aggregation only should generate a result if a specific suboperator returns a value

**Weights (Optional)**
Some comparison operators might be more relevant for the correct establishment of a link between two resources than others. For example, depending on data formats/quality, matching labels might be considered less important than matching geocoordinates when linking cities. If this modifier is not supplied, a default weight of 1 will be assumed. The weight is only considered in the aggregation types average, quadraticMean and geometricMean.

**Type**
The function according to the similarity values are aggregated. The following functions are included:

----------------------------------------------------------------------------------------------------------------------
Name (Id)                                  Description
------------------------------------------ ---------------------------------------------------------------------------
AverageAggregator (`average`)              Evaluate to the (weighted) average of confidence values
                        
MaximumAggregator (`max`)                  Evaluate to the highest confidence in the group
                        
MinimumAggregator (`min`)                  Evaluate to the lowest confidence in the group
                        
QuadraticMeanAggregator (`quadraticMean`)  Apply Euclidian distance aggregation
                        
GeometricMeanAggregator (`geometricMean`)  Compute the (weighted) geometric mean of a group of confidence values

----------------------------------------------------------------------------------------------------------------------

### Examples

**XML**

    <Aggregate type="average">
        <Compare metric="jaro" required="true">
          <Input path="?a/rdfs:label" />
          <Input path="?b/gn:name" />
        </Compare>
        <Compare metric="num">
          <Input path="?a/dbpedia:populationTotal" />
          <Input path="?b/gn:population" />
        </Compare>
      </Aggregate>

**Scala API**

    Aggregation(
      id = "id1",
      required = false,
      weight = 1,
      operators = operators,
      aggregator = MaximumAggregator()
    )
    

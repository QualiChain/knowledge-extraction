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

package org.silkframework.entity.paths

import org.silkframework.config.Prefixes
import org.silkframework.runtime.validation.ValidationException
import org.silkframework.util.Uri

import scala.util.parsing.combinator.RegexParsers
import scala.util.parsing.input.CharSequenceReader

/**
 * Parser for the Silk RDF path language.
 */
private[entity] class PathParser(prefixes: Prefixes) extends RegexParsers {

  def parse(pathStr: String): UntypedPath = {
    if(pathStr.isEmpty) {
      UntypedPath(Nil)
    } else {
      // Complete path if a simplified syntax is used
      val completePath = pathStr.head match {
        case '?' => pathStr // Path includes a variable
        case '/' | '\\' => "?a" + pathStr // Variable has been left out
        case _ => "?a/" + pathStr // Variable and leading '/' have been left out
      }
      // Parse path
      parseAll(path, new CharSequenceReader(completePath)) match {
        case Success(parsedPath, _) => parsedPath
        case error: NoSuccess => throw new ValidationException(error.toString)
      }
    }
  }

  private def path = variable ~ rep(forwardOperator | backwardOperator | filterOperator) ^^ {
    case variable ~ operators => UntypedPath(operators)
  }

  private def variable = "?" ~> identifier

  private def forwardOperator = "/" ~> identifier ^^ {
    s => ForwardOperator(Uri.parse(s, prefixes).uri)
  }

  private def backwardOperator = "\\" ~> identifier ^^ {
    s => BackwardOperator(Uri.parse(s, prefixes).uri)
  }

  private def filterOperator = "[" ~> (langFilter | propFilter) <~ "]"

  private def langFilter = "@lang" ~> compOperator ~ "'" ~ languageTag ~ "'" ^^ {
    case op ~ _ ~ lang ~ _ => LanguageFilter(op, lang)
  }

  private def propFilter = identifier ~ compOperator ~ value ^^ {
    case prop ~ op ~ value =>
      PropertyFilter(
        property = Uri.parse(prop, prefixes),
        operator = op,
        value = if(value.startsWith("\"")) value else "<" + Uri.parse(value, prefixes).uri + ">")
  }

  // An identifier that is either a URI enclosed in angle brackets (e.g., <URI>) or a plain identifier (e.g., name or prefix:name)
  private def identifier = """<[^>]+>|[^\\/\[\]<>=!" ]+""".r

  // A language tag according to the Sparql spec
  private def languageTag = """[a-zA-Z]+('-'[a-zA-Z0-9]+)*""".r

  // A value that is either an identifier or a literal value enclosed in quotes (e.g., "literal").
  private def value = identifier | "\"[^\"]+\"".r

  // A comparison operator
  private def compOperator = ">" | "<" | ">=" | "<=" | "=" | "!="
}

package uk.gov.dvla.messages

import scala.xml.{Null, Text, Attribute, NodeSeq}

/**
 * Simple trait for XML serialization.
 *
 * Probably not needed in the final solution. It's used here because we're currently
 * dropping the enriched messages to disk and they need to be in a human-readable format.
 */
trait XmlMessageSerialization {
  /**
   * Serializes this object to an XML representation.
   *
   * @return XML nodes representing this class.
   */
  def toXml: NodeSeq = {
    val fields = getClass.getDeclaredFields
    fields foreach {
      _.setAccessible(true)
    }
    val data = fields map {
      f => f.getName -> f.get(this).toString
    } filter (_._1 != "key")
    val xmlTag = <a/>.copy(label = getClass.getSimpleName)

    (xmlTag /: data) {
      case (rec, (name, value)) =>
        rec % Attribute(None, name, Text(value), Null)
    }
  }
}
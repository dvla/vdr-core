package uk.gov.dvla.messages

import scala.xml._

/**
 * Simple trait for XML serialization.
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
    }

    xmlFromMap(data.toMap)
  }

  def xmlFromMap(data: Map[String, String]): NodeSeq = {
    val xmlTag = <a/>.copy(label = getClass.getSimpleName)

    (xmlTag /: data) {
      case (rec, (name, value)) =>
        rec % Attribute(None, name, Text(value), Null)
    }
  }
}

trait XmlMapBasedSerialization extends XmlMessageSerialization {
  val data: Map[String, String]

  /**
   * @return XML node named like the class with attributes set from 'data' map.
   */
  override def toXml: NodeSeq = xmlFromMap(data)
}
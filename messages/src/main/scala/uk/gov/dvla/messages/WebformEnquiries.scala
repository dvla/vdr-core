package uk.gov.dvla

import uk.gov.dvla.servicebus.core.Message
import org.joda.time.DateTime
import scala.collection.immutable.Map
import scala.xml.{Null, Text, Attribute, NodeSeq}

class RecordSuppressionEnrichedMessage(val suppressionReasonParam: String,
                                       val enrichedData: Map[String, String],
                                       baseMessage: RecordSuppressionEnquiryMessage)
  extends Message with Serializable {

  val timestamp = baseMessage.timestamp
  val formData = baseMessage.formData

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
    val xmlTag = <a/>.copy(label = getClass.getSimpleName)

    (xmlTag /: data) {
      case (rec, (name, value)) =>
        rec % Attribute(None, name, Text(value), Null)
    }
  }
}

/**
 * A record suppression enquiry DTO.
 *
 * This is simply the data from the webform prior to enrichment.
 *
 * @param formDataParam The form fields in a key-value map.
 */
class RecordSuppressionEnquiryMessage(formDataParam: Map[String, String])
  extends Message with Serializable {

  /**
   * Keep track of form submission times, and allows us to identify performance issues and
   * end to end response times.
   */
  val timestamp = DateTime.now

  /**
   * The contents of our form data, in a map of [fieldName: String, data: String].
   */
  val formData = formDataParam

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
    val xmlTag = <a/>.copy(label = getClass.getSimpleName)

    (xmlTag /: data) {
      case (rec, (name, value)) =>
        rec % Attribute(None, name, Text(value), Null)
    }
  }
}


package uk.gov.dvla

import uk.gov.dvla.servicebus.core.Message
import org.joda.time.DateTime
import scala.collection.immutable.Map
import scala.xml.{Null, Text, Attribute, NodeSeq}

/**
 * Simple trait for XML serialization.
 *
 * Probably not needed in the final solution. It's used here because we're currently
 * dropping the enriched messages to disk and they need to be in a human-readable format.
 */
trait WithXmlSerialization {
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
 * An Enriched Record Suppression message.
 *
 * Created by the enrichment service after it has looked up additional data (eg the address and
 * suppression reason) from the enrichment filter endpoint.
 *
 * @param suppressionReason The reason for the suppresion.
 * @param enrichedData Key-value pairing of enriched data fields.
 * @param baseMessage The RecordSuppressionEnquiry message to copy form data from.
 */
class RecordSuppressionEnrichedMessage(val suppressionReason: String,
                                       val enrichedData: Map[String, String],
                                       baseMessage: RecordSuppressionEnquiryMessage)
  extends Message with WithXmlSerialization with Serializable {

  val timestamp = baseMessage.timestamp
  val formData = baseMessage.formData
}

/**
 * A record suppression enquiry DTO.
 *
 * This is simply the data from the webform prior to enrichment.
 *
 * @param formDataParam The form fields in a key-value map.
 */
class RecordSuppressionEnquiryMessage(formDataParam: Map[String, String])
  extends Message with WithXmlSerialization with Serializable {

  /**
   * Keep track of form submission times, and allows us to identify performance issues and
   * end to end response times.
   */
  val timestamp = DateTime.now

  /**
   * The contents of our form data, in a map of [fieldName: String, data: String].
   */
  val formData = formDataParam
}


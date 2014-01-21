package uk.gov.dvla

import uk.gov.dvla.servicebus.core.Message
import org.joda.time.DateTime
import scala.collection.immutable.Map
import uk.gov.dvla.messages.XmlMessageSerialization


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
  extends Message with XmlMessageSerialization with Serializable {

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
  extends Message with XmlMessageSerialization with Serializable {

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


package uk.gov.dvla

import uk.gov.dvla.servicebus.core.{MessageRoutingKey, Message}
import org.joda.time.DateTime
import scala.collection.immutable.Map
import uk.gov.dvla.messages.{XmlMessageSerialization}


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
case class RecordSuppressionEnrichedMessage(suppressionReason: String,
                                            enrichedData: Map[String, String],
                                            baseMessage: RecordSuppressionEnquiryMessage)
  extends Message with XmlMessageSerialization with Serializable with MessageRoutingKey {

  val timestamp = baseMessage.timestamp

  def formData = baseMessage.formData

  val key: String = "kana_webform"
}

/**
 * A record suppression enquiry DTO.
 *
 * This is simply the data from the webform prior to enrichment.
 * @param formData The form fields in a key-value map.
 */
case class RecordSuppressionEnquiryMessage(formData: Map[String, String])
  extends Message with XmlMessageSerialization with Serializable with MessageRoutingKey {
  val timestamp = DateTime.now

  val key: String = "kana_webform"
}


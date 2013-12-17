package uk.gov.dvla

import uk.gov.dvla.servicebus.core.Message
import org.joda.time.DateTime
import scala.collection.immutable.Map

/**
 * A record suppression enquiry message.
 *
 * This is simply the data from the webform prior to enrichment.
 *
 * @param formData The form fields in a key-value map.
 */
class RecordSuppressionEnquiryMessage(formDataParam: Map[String, String])
  extends Message with Serializable {

  /**
   * Keep track of form submission times, and allows us to identify performance issues and
   * end to end response times.
   */
  val timestamp = DateTime.now

  val formData = formDataParam
}


package uk.gov.dvla.messages

import uk.gov.dvla.servicebus.core.Message
import org.joda.time.DateTime

case class PositiveFeedback(
                        contactChannel: String,
                        requestSent: DateTime,
                        responseSent: DateTime,
                        userId: String,
                        ipAddress: String
                        ) extends Message with XmlMessageSerialization

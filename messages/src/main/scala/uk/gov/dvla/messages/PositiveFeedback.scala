package uk.gov.dvla.messages

import org.joda.time.DateTime

case class PositiveFeedback(
                             contactChannel: String,
                             requestSent: DateTime,
                             responseSent: DateTime,
                             userId: String,
                             ipAddress: String
                             ) extends AuditMessage {
  val result = Result.Success
  val serviceType = ServiceType.DvlaPortal
}

package uk.gov.dvla.messages

import java.util.UUID

trait Message {
  val messageId: UUID = java.util.UUID.randomUUID
}

case class UserSuccessful(dln : String, result : String) extends Message
case class UserUnsuccessful(dln : String, result : String) extends Message
case class DvlaUserUnsuccessful(dln : String, result : String) extends Message

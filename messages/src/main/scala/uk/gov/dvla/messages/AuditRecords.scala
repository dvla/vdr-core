package uk.gov.dvla.messages

import uk.gov.dvla.servicebus.core.Message

case class UserSuccessful(dln : String, result : String) extends Message
case class UserUnsuccessful(dln : String, result : String) extends Message
case class DvlaUserUnsuccessful(dln : String, result : String) extends Message

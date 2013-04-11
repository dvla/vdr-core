package uk.gov.dvla.messages

case class UserSuccessful(dln : String, result : String)
case class UserUnsuccessful(dln : String, result : String)
case class DvlaUserUnsuccessful(dln : String, result : String)

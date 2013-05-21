package uk.gov.dvla.messages

import uk.gov.dvla.servicebus.core.Message
import org.joda.time.DateTime

object Status extends Enumeration {
  val RecordFound, NotFound, NotValid, Suppressed, ServerError, MultipleRecordsFound  = Value
}

object Result extends Enumeration {
  val Success, Failure = Value
}

object ServiceType extends Enumeration {
  val CustomerPortal, DvlaPortal, ExternalInterface = Value
}

object AttributeType extends Enumeration {
    val RecordType, StatusCode, RestrictionKey, StopMarker = Value
}

case class CustomerDlnSuccessful(dln : String, postcode : String, requestSent : DateTime, responseSent : DateTime, ipAddress : String) extends Message {
  val result = Result.Success
  val status = Status.RecordFound
  val serviceType = ServiceType.CustomerPortal
}

case class CustomerPersonalDetailsSuccessful(dln : String, forename : String, surname : String, dob : DateTime, gender : Int, postcode : String,
                              requestSent : DateTime, responseSent : DateTime, ipAddress : String) extends Message {
  val result = Result.Success
  val status = Status.RecordFound
  val serviceType = ServiceType.CustomerPortal
}

case class CustomerDlnNotValid(dln : String, requestSent : DateTime, responseSent : DateTime, ipAddress : String) extends Message {
  val result = Result.Failure
  val status = Status.NotValid
  val serviceType = ServiceType.CustomerPortal
}

case class CustomerPostcodeNotMatched(dln : String, postcode : String, requestSent : DateTime, responseSent : DateTime, ipAddress : String) extends Message {
  val result = Result.Failure
  val status = Status.NotValid
  val serviceType = ServiceType.CustomerPortal
}

case class CustomerPersonalDetailsNotValid(forename : String, surname : String, dob : DateTime, gender : Int, postcode : String,
                                 requestSent : DateTime, responseSent : DateTime, ipAddress : String) extends Message {
  val result = Result.Failure
  val status = Status.NotValid
  val serviceType = ServiceType.CustomerPortal
}

case class CustomerDlnNotFound(dln : String, postcode: String, requestSent : DateTime, responseSent : DateTime, ipAddress : String) extends Message {
  val result = Result.Failure
  val status = Status.NotFound
  val serviceType = ServiceType.CustomerPortal
}

case class CustomerPersonalDetailsNotFound(forename : String, surname : String, dob : DateTime, gender : Int, postcode : String,
                              requestSent : DateTime, responseSent : DateTime, ipAddress : String) extends Message {
  val result = Result.Failure
  val status = Status.NotFound
  val serviceType = ServiceType.CustomerPortal
}

case class CustomerDlnServerError(dln : String, requestSent : DateTime, responseSent : DateTime, ipAddress : String) extends Message {
  val result = Result.Failure
  val status = Status.ServerError
  val serviceType = ServiceType.CustomerPortal
}

case class CustomerPersonalDetailsServerError(forename : String, surname : String, dob : DateTime, gender : Int, postcode : String,
                              requestSent : DateTime, responseSent : DateTime, ipAddress : String) extends Message {
  val result = Result.Failure
  val status = Status.ServerError
  val serviceType = ServiceType.CustomerPortal
}

case class CustomerDlnSuppressed(dln : String, requestSent : DateTime, responseSent : DateTime, ipAddress : String, suppressionReason : String) extends Message {
  val result = Result.Failure
  val status = Status.Suppressed
  val serviceType = ServiceType.CustomerPortal
}

case class CustomerPersonalDetailsSuppressed(forename : String, surname : String, dob : DateTime, gender : Int, postcode : String,
                              requestSent : DateTime, responseSent : DateTime, ipAddress : String, suppressionReason : String) extends Message {
  val result = Result.Failure
  val status = Status.Suppressed
  val serviceType = ServiceType.CustomerPortal
}

case class CustomerMultipleFound(forename : String, surname : String, dob : DateTime, gender : Int, postcode : String,
                              requestSent : DateTime, responseSent : DateTime, ipAddress : String) extends Message {
  val result = Result.Failure
  val status = Status.MultipleRecordsFound
  val serviceType = ServiceType.CustomerPortal
}

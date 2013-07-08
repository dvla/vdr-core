package uk.gov.dvla.messages

import uk.gov.dvla.servicebus.core.Message
import org.joda.time.DateTime
import java.util.UUID

object Status extends Enumeration {
  val RecordFound,
  NotFound,
  NotValid,
  NotAvailable,
  Suppressed,
  ServerError,
  MultipleRecordsFound,
  PostcodeContainsSpecialCharacter,
  UnauthorisedAccess,
  MessageReturned = Value
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

case class CustomerDlnSuccessful(dln : String, postcode: String, requestSent : DateTime, responseSent : DateTime,
                                 ipAddress : String) extends Message {
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

case class CustomerPostcodeNotMatched(dln : String, postcode : String, requestSent : DateTime, responseSent : DateTime, ipAddress : String) extends Message {
  val result = Result.Failure
  val status = Status.NotValid
  val serviceType = ServiceType.CustomerPortal
}

case class CustomerPostcodeContainsSpecialCharacter(dln : String, postcode : String, requestSent : DateTime,
                                                    responseSent : DateTime, ipAddress : String) extends Message {
  val result = Result.Success
  val status = Status.PostcodeContainsSpecialCharacter
  val serviceType = ServiceType.CustomerPortal
}

case class DvlaDlnSuccessful(dln : String, requestSent : DateTime, responseSent : DateTime,
                             contactChannel : String, enquiryReason : String, userId: String,
                              ipAddress: String) extends Message {
  val result = Result.Success
  val status = Status.RecordFound
  val serviceType = ServiceType.DvlaPortal
}

case class DvlaDlnNotFound(dln: String, requestSent: DateTime, responseSent: DateTime,
                            contactChannel: String, enquiryReason: String, userId: String,
                            ipAddress: String) extends Message {
  val result = Result.Failure
  val status = Status.NotFound
  val serviceType = ServiceType.DvlaPortal
}

case class DvlaDlnServerError(dln: String, requestSent: DateTime, responseSent: DateTime,
                               contactChannel: String, enquiryReason: String, userId: String,
                               ipAddress: String) extends Message {
  val result = Result.Failure
  val status = Status.ServerError
  val serviceType = ServiceType.DvlaPortal
}

case class DvlaDlnNotValid(dln: String, requestSent: DateTime, responseSent: DateTime,
                            contactChannel: String, enquiryReason: String, userId: String,
                            ipAddress: String) extends Message {
  val result = Result.Failure
  val status = Status.NotValid
  val serviceType = ServiceType.DvlaPortal
}

case class DvlaDlnSuppressed(dln: String, requestSent: DateTime, responseSent: DateTime,
                             suppressionReason: String, contactChannel: String, enquiryReason: String,
                             ipAddress: String) extends Message {
  val result = Result.Failure
  val status = Status.Suppressed
  val serviceType = ServiceType.DvlaPortal
}

case class DvlaPersonalDetailsSuccessful(dln: String, forename: String, surname: String, dob: DateTime, gender: Int,
                                          postCode: String, requestSent: DateTime, responseSent: DateTime,
                                          contactChannel: String, enquiryReason: String, userId: String,
                                          ipAddress: String) extends Message {
  val result = Result.Success
  val status = Status.RecordFound
  val serviceType = ServiceType.DvlaPortal
}

case class DvlaPersonalDetailsNotFound(forename: String, surname: String, dob: DateTime, gender: Int, postCode: String,
                                        requestSent: DateTime, responseSent: DateTime, contactChannel: String,
                                        enquiryReason:String, userId: String, ipAddress: String) extends Message {
  val result = Result.Failure
  val status = Status.NotFound
  val serviceType = ServiceType.DvlaPortal
}

case class DvlaPersonalDetailsNotValid(forename: String, surname: String, dob: DateTime, gender: Int, postCode: String,
                                        requestSent: DateTime, responseSent: DateTime, contactChannel: String,
                                        enquiryReason: String, userId: String, ipAddress: String) extends Message {
  val result = Result.Failure
  val status = Status.NotFound
  val serviceType = ServiceType.DvlaPortal
}

case class DvlaPersonalDetailsServerError(forename: String, surname: String, dob: DateTime, gender: Int,
                                           postCode: String, requestSent: DateTime, responseSent: DateTime,
                                           contactChannel: String, enquiryReason: String,
                                           userId: String, ipAddress: String) extends Message {
  val result = Result.Failure
  val status = Status.ServerError
  val serviceType = ServiceType.DvlaPortal
}

case class DvlaPersonalDetailsSuppressed(dln: String, forename: String, surname: String, dob: DateTime, gender: Int,
                                          postCode: String, requestSent: DateTime, responseSent: DateTime,
                                          suppressionReason: String, contactChannel: String, enquiryReason: String,
                                          ipAddress: String) extends Message {
  val result = Result.Failure
  val status = Status.Suppressed
  val serviceType = ServiceType.DvlaPortal
}

case class DvlaMultipleFound(forename : String, surname : String, dob : DateTime, gender : Int, postcode : String,
                                 requestSent : DateTime, responseSent : DateTime, contactChannel: String,
                                 enquiryReason: String, userId : String, ipAddress: String) extends Message {
  val result = Result.Failure
  val status = Status.MultipleRecordsFound
  val serviceType = ServiceType.DvlaPortal
}

case class DvlaUnauthorisedAccess(userId: String, requestSent: DateTime, responseSent: DateTime,
                                  ipAddress: String) extends Message {
  val result = Result.Failure
  val status = Status.UnauthorisedAccess
  val serviceType = ServiceType.DvlaPortal
}

case class MibMissingMandatoryFields(enquiryId: UUID, dln: String, postcode: String, requestSent: DateTime,
                                     responseSent: DateTime, ipAddress: String) extends Message {
  val result = Result.Failure
  val status = Status.NotValid
  val serviceType = ServiceType.ExternalInterface
}

case class MibDlnNotFound(enquiryId: UUID, dln: String, postcode: String, requestSent: DateTime,
                           responseSent: DateTime, ipAddress: String) extends Message {
  val result = Result.Failure
  val status = Status.NotFound
  val serviceType = ServiceType.ExternalInterface
}

case class MibDlnNotValid(enquiryId: UUID, dln: String, postcode: String, requestSent: DateTime,
                           responseSent: DateTime, ipAddress: String) extends Message {
  val result = Result.Failure
  val status = Status.NotValid
  val serviceType = ServiceType.ExternalInterface
}

case class MibServerError(enquiryId: UUID, dln: String, postcode: String, requestSent: DateTime,
                           responseSent: DateTime, ipAddress: String) extends Message {
  val result = Result.Failure
  val status = Status.ServerError
  val serviceType = ServiceType.ExternalInterface
}

case class MibRecordSuppression(enquiryId: UUID, dln: String, postcode: String, requestSent: DateTime,
                                 responseSent: DateTime, ipAddress: String) extends Message {
  val result = Result.Failure
  val status = Status.Suppressed
  val serviceType = ServiceType.ExternalInterface
}

case class MibEnquirySuccessful(enquiryId: UUID, dln: String, postcode: String, requestSent: DateTime,
                          responseSent: DateTime, ipAddress: String) extends Message {
  val result = Result.Success
  val status = Status.RecordFound
  val serviceType = ServiceType.ExternalInterface
}

case class MibNoEntitlements(enquiryId: UUID, dln: String, postcode: String, requestSent: DateTime,
                              responseSent: DateTime, ipAddress: String) extends Message {
  val result = Result.Failure
  val status = Status.NotAvailable
  val serviceType = ServiceType.ExternalInterface
}

case class MibEnquiryMessageReturned(enquiryId: UUID, dln: String, postcode: String, requestSent: DateTime,
                                      responseSent: DateTime, ipAddress: String, message: String) extends Message {
  val result = Result.Success
  val status = Status.MessageReturned
  val serviceType = ServiceType.ExternalInterface
}
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
  PostcodeIsBlank,
  UnauthorisedAccess,
  MessageReturned,
  CoreMatch,
  Maintenance,
  NegativeCoreMatch,
  IDASamlRequestSent,
  IDASamlResponseReceived,
  IDAMatchRequestReceived,
  BatchReceived,
  BatchRespondedTo,
  Deceased = Value
}

object Result extends Enumeration {
  val Success, Failure, Cancellation, NA = Value
}

object ServiceType extends Enumeration {
  val CustomerPortal, DvlaPortal, MibRealTime, MibBatch, IDAMatcherService, WebFormEnrichmentService, DocumentCheckingService = Value
}

object AttributeType extends Enumeration {
  val RecordType, StatusCode, RestrictionKey, StopMarker = Value
}

trait AuditMessage extends Message with XmlMessageSerialization {
  val result: Result.Value
  val serviceType: ServiceType.Value
}

case class CustomerDlnSuccessful(dln: String, postCode: String, requestSent: DateTime, responseSent: DateTime,
                                 ipAddress: String) extends AuditMessage {
  val result = Result.Success
  val status = Status.RecordFound
  val serviceType = ServiceType.CustomerPortal
}

case class CustomerPersonalDetailsSuccessful(dln: String, forename: String, surname: String, dob: DateTime, gender: Int, postCode: String,
                                             requestSent: DateTime, responseSent: DateTime, ipAddress: String) extends AuditMessage {
  val result = Result.Success
  val status = Status.RecordFound
  val serviceType = ServiceType.CustomerPortal
}

case class CustomerDlnNotValid(dln: String, requestSent: DateTime, responseSent: DateTime, ipAddress: String) extends AuditMessage {
  val result = Result.Failure
  val status = Status.NotValid
  val serviceType = ServiceType.CustomerPortal
}

case class CustomerPersonalDetailsNotValid(forename: String, surname: String, dob: DateTime, gender: Int, postCode: String,
                                           requestSent: DateTime, responseSent: DateTime, ipAddress: String) extends AuditMessage {
  val result = Result.Failure
  val status = Status.NotValid
  val serviceType = ServiceType.CustomerPortal
}

case class CustomerDlnNotFound(dln: String, postCode: String, requestSent: DateTime, responseSent: DateTime, ipAddress: String) extends AuditMessage {
  val result = Result.Failure
  val status = Status.NotFound
  val serviceType = ServiceType.CustomerPortal
}

case class CustomerPersonalDetailsNotFound(forename: String, surname: String, dob: DateTime, gender: Int, postCode: String,
                                           requestSent: DateTime, responseSent: DateTime, ipAddress: String) extends AuditMessage {
  val result = Result.Failure
  val status = Status.NotFound
  val serviceType = ServiceType.CustomerPortal
}

case class CustomerDlnServerError(dln: String, requestSent: DateTime, responseSent: DateTime, ipAddress: String) extends AuditMessage {
  val result = Result.Failure
  val status = Status.ServerError
  val serviceType = ServiceType.CustomerPortal
}

case class CustomerPersonalDetailsServerError(forename: String, surname: String, dob: DateTime, gender: Int, postCode: String,
                                              requestSent: DateTime, responseSent: DateTime, ipAddress: String) extends AuditMessage {
  val result = Result.Failure
  val status = Status.ServerError
  val serviceType = ServiceType.CustomerPortal
}

case class CustomerDlnSuppressed(dln: String, requestSent: DateTime, responseSent: DateTime, ipAddress: String, suppressionReason: String) extends AuditMessage {
  val result = Result.Failure
  val status = Status.Suppressed
  val serviceType = ServiceType.CustomerPortal
}

case class CustomerPersonalDetailsSuppressed(forename: String, surname: String, dob: DateTime, gender: Int, postCode: String,
                                             requestSent: DateTime, responseSent: DateTime, ipAddress: String, suppressionReason: String) extends AuditMessage {
  val result = Result.Failure
  val status = Status.Suppressed
  val serviceType = ServiceType.CustomerPortal
}

case class CustomerDlnPartiallySuppressed(dln: String, suppressionReason: String, postCode: String, requestSent: DateTime, responseSent: DateTime,
                                          ipAddress: String) extends AuditMessage {
  val result = Result.Success
  val status = Status.RecordFound
  val serviceType = ServiceType.CustomerPortal
}

case class CustomerPersonalDetailsPartiallySuppressed(dln: String, suppressionReason: String, forename: String, surname: String, dob: DateTime, gender: Int, postCode: String,
                                                      requestSent: DateTime, responseSent: DateTime, ipAddress: String) extends AuditMessage {
  val result = Result.Success
  val status = Status.RecordFound
  val serviceType = ServiceType.CustomerPortal
}

case class CustomerMultipleFound(forename: String, surname: String, dob: DateTime, gender: Int, postCode: String,
                                 requestSent: DateTime, responseSent: DateTime, ipAddress: String) extends AuditMessage {
  val result = Result.Failure
  val status = Status.MultipleRecordsFound
  val serviceType = ServiceType.CustomerPortal
}

case class CustomerPostcodeNotMatched(dln: String, postCode: String, requestSent: DateTime, responseSent: DateTime, ipAddress: String) extends AuditMessage {
  val result = Result.Failure
  val status = Status.NotValid
  val serviceType = ServiceType.CustomerPortal
}

case class CustomerPostcodeContainsSpecialCharacter(dln: String, postCode: String, requestSent: DateTime,
                                                    responseSent: DateTime, ipAddress: String) extends AuditMessage {
  val result = Result.Success
  val status = Status.PostcodeContainsSpecialCharacter
  val serviceType = ServiceType.CustomerPortal
}

case class CustomerPostcodeIsBlank(dln: String, postCode: String, requestSent: DateTime,
                                   responseSent: DateTime, ipAddress: String) extends AuditMessage {
  val result = Result.Success
  val status = Status.PostcodeIsBlank
  val serviceType = ServiceType.CustomerPortal
}

case class DvlaDlnSuccessful(dln: String, requestSent: DateTime, responseSent: DateTime,
                             contactChannel: String, enquiryReasons: List[String], userId: String,
                             ipAddress: String) extends AuditMessage {
  val result = Result.Success
  val status = Status.RecordFound
  val serviceType = ServiceType.DvlaPortal
}

case class DvlaDlnNotFound(dln: String, requestSent: DateTime, responseSent: DateTime,
                           contactChannel: String, enquiryReasons: List[String], userId: String,
                           ipAddress: String) extends AuditMessage {
  val result = Result.Failure
  val status = Status.NotFound
  val serviceType = ServiceType.DvlaPortal
}

case class DvlaDlnServerError(dln: String, requestSent: DateTime, responseSent: DateTime,
                              contactChannel: String, enquiryReasons: List[String], userId: String,
                              ipAddress: String) extends AuditMessage {
  val result = Result.Failure
  val status = Status.ServerError
  val serviceType = ServiceType.DvlaPortal
}

case class DvlaDlnNotValid(dln: String, requestSent: DateTime, responseSent: DateTime,
                           contactChannel: String, enquiryReasons: List[String], userId: String,
                           ipAddress: String) extends AuditMessage {
  val result = Result.Failure
  val status = Status.NotValid
  val serviceType = ServiceType.DvlaPortal
}

case class DvlaDlnSuppressed(dln: String, requestSent: DateTime, responseSent: DateTime,
                             suppressionReason: String, contactChannel: String, enquiryReasons: List[String],
                             ipAddress: String) extends AuditMessage {
  val result = Result.Failure
  val status = Status.Suppressed
  val serviceType = ServiceType.DvlaPortal
}

case class DvlaDlnPartiallySuppressed(dln: String, suppressionReason: String, requestSent: DateTime, responseSent: DateTime,
                                      contactChannel: String, enquiryReasons: List[String], userId: String,
                                      ipAddress: String) extends AuditMessage {
  val result = Result.Success
  val status = Status.RecordFound
  val serviceType = ServiceType.DvlaPortal
}

case class DvlaPersonalDetailsSuccessful(dln: String, forename: String, surname: String, dob: DateTime, gender: Int,
                                         postCode: String, requestSent: DateTime, responseSent: DateTime,
                                         contactChannel: String, enquiryReasons: List[String], userId: String,
                                         ipAddress: String) extends AuditMessage {
  val result = Result.Success
  val status = Status.RecordFound
  val serviceType = ServiceType.DvlaPortal
}


case class DvlaPersonalDetailsNotFound(forename: String, surname: String, dob: DateTime, gender: Int, postCode: String,
                                       requestSent: DateTime, responseSent: DateTime, contactChannel: String,
                                       enquiryReasons: List[String], userId: String, ipAddress: String) extends AuditMessage {
  val result = Result.Failure
  val status = Status.NotFound
  val serviceType = ServiceType.DvlaPortal
}

case class DvlaPersonalDetailsNotValid(forename: String, surname: String, dob: DateTime, gender: Int, postCode: String,
                                       requestSent: DateTime, responseSent: DateTime, contactChannel: String,
                                       enquiryReasons: List[String], userId: String, ipAddress: String) extends AuditMessage {
  val result = Result.Failure
  val status = Status.NotFound
  val serviceType = ServiceType.DvlaPortal
}

case class DvlaPersonalDetailsServerError(forename: String, surname: String, dob: DateTime, gender: Int,
                                          postCode: String, requestSent: DateTime, responseSent: DateTime,
                                          contactChannel: String, enquiryReasons: List[String],
                                          userId: String, ipAddress: String) extends AuditMessage {
  val result = Result.Failure
  val status = Status.ServerError
  val serviceType = ServiceType.DvlaPortal
}

case class DvlaPersonalDetailsSuppressed(dln: String, forename: String, surname: String, dob: DateTime, gender: Int,
                                         postCode: String, requestSent: DateTime, responseSent: DateTime,
                                         suppressionReason: String, contactChannel: String,
                                         enquiryReasons: List[String],
                                         ipAddress: String) extends AuditMessage {
  val result = Result.Failure
  val status = Status.Suppressed
  val serviceType = ServiceType.DvlaPortal
}

case class DvlaPersonalDetailsPartiallySuppressed(dln: String, suppressionReason: String, forename: String, surname: String, dob: DateTime, gender: Int,
                                                  postCode: String, requestSent: DateTime, responseSent: DateTime,
                                                  contactChannel: String, enquiryReasons: List[String], userId: String,
                                                  ipAddress: String) extends AuditMessage {
  val result = Result.Success
  val status = Status.RecordFound
  val serviceType = ServiceType.DvlaPortal
}

case class DvlaMultipleFound(forename: String, surname: String, dob: DateTime, gender: Int, postCode: String,
                             requestSent: DateTime, responseSent: DateTime, contactChannel: String,
                             enquiryReasons: List[String], userId: String, ipAddress: String) extends AuditMessage {
  val result = Result.Failure
  val status = Status.MultipleRecordsFound
  val serviceType = ServiceType.DvlaPortal
}

case class DvlaUnauthorisedAccess(userId: String, requestSent: DateTime, responseSent: DateTime,
                                  ipAddress: String) extends AuditMessage {
  val result = Result.Failure
  val status = Status.UnauthorisedAccess
  val serviceType = ServiceType.DvlaPortal
}

case class MibBatchReceived(batchId: String, received: DateTime = DateTime.now,
                            noRequests: Int = -1, errorCodes: List[String] = Nil)
  extends AuditMessage {
  val result = if (errorCodes.isEmpty) Result.Success else Result.Failure
  val status = Status.BatchReceived
  val serviceType = ServiceType.MibBatch
}

case class MibBatchResponseCreated(batchId: String, result: Result.Value = Result.Success,
                                   created: DateTime = DateTime.now)
  extends AuditMessage {
  val status = Status.BatchRespondedTo
  val serviceType = ServiceType.MibBatch
}

case class MibRealTimeMissingMandatoryFields(enquiryId: UUID, dln: String, postCode: String, requestSent: DateTime,
                                             responseSent: DateTime, ipAddress: String, batchId: String,
                                             vrmProvided: Boolean) extends AuditMessage {
  val result = Result.Failure
  val status = Status.NotValid
  val serviceType = ServiceType.MibRealTime
}

case class MibRealTimeDlnNotFound(enquiryId: UUID, dln: String, postCode: String, requestSent: DateTime,
                                  responseSent: DateTime, ipAddress: String, batchId: String,
                                  vrmProvided: Boolean) extends AuditMessage {
  val result = Result.Failure
  val status = Status.NotFound
  val serviceType = ServiceType.MibRealTime
}

case class MibRealTimeDlnNotValid(enquiryId: UUID, dln: String, postCode: String, requestSent: DateTime,
                                  responseSent: DateTime, ipAddress: String, batchId: String,
                                  vrmProvided: Boolean) extends AuditMessage {
  val result = Result.Failure
  val status = Status.NotValid
  val serviceType = ServiceType.MibRealTime
}

case class MibRealTimeServerError(enquiryId: UUID, dln: String, postCode: String, requestSent: DateTime,
                                  responseSent: DateTime, ipAddress: String, batchId: String,
                                  vrmProvided: Boolean) extends AuditMessage {
  val result = Result.Failure
  val status = Status.ServerError
  val serviceType = ServiceType.MibRealTime
}

case class MibRealTimeRecordSuppression(enquiryId: UUID, dln: String, postCode: String, requestSent: DateTime,
                                        responseSent: DateTime, ruleApplied: String, ipAddress: String, batchId: String,
                                        vrmProvided: Boolean) extends AuditMessage {
  val result = Result.Failure
  val status = Status.Suppressed
  val serviceType = ServiceType.MibRealTime
}

case class MibRealTimeRecordPartialSuppression(enquiryId: UUID, dln: String, postCode: String, requestSent: DateTime,
                                               responseSent: DateTime, ruleApplied: String, ipAddress: String, batchId: String,
                                               vrmProvided: Boolean) extends AuditMessage {
  val result = Result.Success
  val status = Status.Suppressed
  val serviceType = ServiceType.MibRealTime
}

case class MibRealTimeEnquirySuccessful(enquiryId: UUID, dln: String, postCode: String, requestSent: DateTime,
                                        responseSent: DateTime, ipAddress: String, batchId: String,
                                        vrmProvided: Boolean) extends AuditMessage {
  val result = Result.Success
  val status = Status.RecordFound
  val serviceType = ServiceType.MibRealTime
}

case class MibRealTimeNoEntitlements(enquiryId: UUID, dln: String, postCode: String, requestSent: DateTime,
                                     responseSent: DateTime, ipAddress: String, batchId: String,
                                     vrmProvided: Boolean) extends AuditMessage {
  val result = Result.Failure
  val status = Status.NotAvailable
  val serviceType = ServiceType.MibRealTime
}

case class MibRealTimeEnquiryMessageReturned(enquiryId: UUID, dln: String, postCode: String, requestSent: DateTime,
                                             responseSent: DateTime, message: String, ipAddress: String, batchId: String,
                                             vrmProvided: Boolean) extends AuditMessage {
  val result = Result.Success
  val status = Status.MessageReturned
  val serviceType = ServiceType.MibRealTime
}

case class NINOAuthenticateSuccess(dln: String,
                                   coreMatch: String,
                                   coreAndAddressMatch: String,
                                   deceased: String,
                                   requestSent: DateTime,
                                   responseSent: DateTime,
                                   ipAddress: String
                                    ) extends AuditMessage {
  val authenticationType = "DWP"
  val result = Result.Success
  val status = Status.CoreMatch
  val serviceType = ServiceType.CustomerPortal
}

case class NINOAuthenticateFailure(dln: String,
                                   coreMatch: String,
                                   coreAndAddressMatch: String,
                                   deceased: String,
                                   requestSent: DateTime,
                                   responseSent: DateTime,
                                   ipAddress: String
                                    ) extends AuditMessage {
  val authenticationType = "DWP"
  val result = Result.Failure
  val status = Status.NegativeCoreMatch
  val serviceType = ServiceType.CustomerPortal
}

case class NINOAuthenticateDeceased(dln: String,
                                    coreMatch: String,
                                    coreAndAddressMatch: String,
                                    deceased: String,
                                    requestSent: DateTime,
                                    responseSent: DateTime,
                                    ipAddress: String
                                     ) extends AuditMessage {
  val authenticationType = "DWP"
  val result = Result.Failure
  val status = Status.Deceased
  val serviceType = ServiceType.CustomerPortal
}

case class NINOAuthenticateServiceMaintenance(dln: String,
                                              requestSent: DateTime,
                                              responseSent: DateTime,
                                              ipAddress: String
                                               ) extends AuditMessage {
  val authenticationType = "DWP"
  val result = Result.Failure
  val status = Status.Maintenance
  val serviceType = ServiceType.CustomerPortal
}

case class NINOAuthenticateServiceError(dln: String,
                                        requestSent: DateTime,
                                        responseSent: DateTime,
                                        ipAddress: String
                                         ) extends AuditMessage {
  val authenticationType = "DWP"
  val result = Result.Failure
  val status = Status.ServerError
  val serviceType = ServiceType.CustomerPortal
}

case class IDASamlRequest(requestId: String, requestSent: DateTime) extends AuditMessage {
  val authenticationType = "IDA"
  val result = Result.Success
  val status = Status.IDASamlRequestSent
  val serviceType = ServiceType.CustomerPortal

}

case class IDASamlResponseSuccess(requestId: String, pid: String, requestSent: DateTime) extends AuditMessage {
  val authenticationType = "IDA"
  val result = Result.Success
  val status = Status.IDASamlResponseReceived
  val serviceType = ServiceType.CustomerPortal
}

case class IDASamlResponseFailure(requestId: String, pid: String, requestSent: DateTime) extends AuditMessage {
  val authenticationType = "IDA"
  val result = Result.Failure
  val status = Status.IDASamlResponseReceived
  val serviceType = ServiceType.CustomerPortal
}

case class IDASamlResponseCancellation(requestId: String, pid: String, requestSent: DateTime) extends AuditMessage {
  val authenticationType = "IDA"
  val result = Result.Cancellation
  val status = Status.IDASamlResponseReceived
  val serviceType = ServiceType.CustomerPortal
}

case class IDAMatchRequest(matchId: String, requestReceived: DateTime, matchingOutcome: String, matchingBasis: String, pid: String) extends AuditMessage {
  val authenticationType = "IDA"
  val result = Result.Success
  val status = Status.IDAMatchRequestReceived
  val serviceType = ServiceType.IDAMatcherService
}

case class WebFormSubmission(data: Map[String, String]) extends AuditMessage with XmlMapBasedSerialization {
  val result = Result.Success
  val serviceType = ServiceType.WebFormEnrichmentService
}

case class DCSValidationFailed(
                                address: Option[String],
                                dateOfBirth: Option[DateTime],
                                dln: String,
                                familyName: String,
                                givenNames: List[String],
                                issueNumber: String,
                                issuerID: String,
                                placeOfBirth: Option[String],
                                requestID: String,
                                validFrom: String,
                                validTo: String,
                                reasons: List[String]) extends AuditMessage {
  val authenticationType = "DCS"
  val result = Result.Failure
  val serviceType = ServiceType.DocumentCheckingService
}

case class DCSDlnNotFound(
                           dln: String,
                           requestID: String
                           ) extends AuditMessage {
  val authenticationType = "DCS"
  val result = Result.Failure
  val serviceType = ServiceType.DocumentCheckingService
}

case class DCSMatchingRulesFail(
                                 address: Option[String],
                                 dateOfBirth: Option[DateTime],
                                 dln: String,
                                 familyName: String,
                                 givenNames: List[String],
                                 issueNumber: String,
                                 issuerID: String,
                                 placeOfBirth: Option[String],
                                 requestID: String,
                                 validFrom: String,
                                 validTo: String,
                                 matchingFalures: List[String]
                                 ) extends AuditMessage {
  val authenticationType = "DCS"
  val result = Result.Failure
  val serviceType = ServiceType.DocumentCheckingService
}


case class DCSSuppressed(
                          address: Option[String],
                          dateOfBirth: Option[DateTime],
                          dln: String,
                          familyName: String,
                          givenNames: List[String],
                          issueNumber: String,
                          issuerID: String,
                          placeOfBirth: Option[String],
                          requestID: String,
                          validFrom: String,
                          validTo: String,
                          suppressions: List[String]
                          ) extends AuditMessage {
  val authenticationType = "DCS"
  val result = Result.Failure
  val serviceType = ServiceType.DocumentCheckingService
}


case class DCSMatchingSuccess(
                               dln: String,
                               requestID: String
                               ) extends AuditMessage {
  val authenticationType = "DCS"
  val result = Result.Success
  val serviceType = ServiceType.DocumentCheckingService
}

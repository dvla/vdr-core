package uk.gov.dvla.services.audit

import org.apache.commons.lang.StringUtils
import org.joda.time.DateTime
import uk.gov.dvla.domain._
import uk.gov.dvla.messages._
import uk.gov.dvla.servicebus.core.Bus
import uk.gov.dvla.services.common.HttpRequestHelper
import uk.gov.dvla.services.common.ServiceDateFormat
import uk.gov.dvla.services.utils.J2S
import javax.servlet.http.HttpServletRequest
import java.text.ParseException
import java.util.Date
import java.util.{List => JList}

/**
 * This service handles creating and sending message objects to the bus, with a provided route key.
 */
class AuditorService {

  private final var routingKey: String = null
  private final var serviceBus: Bus = null

  /**
   * Creates the service with just a service bus, the route key is defaulted to ''
   *
   * @param serviceBus AMPQ service bus
   */
  def this(serviceBus: Bus) {
    this()
    this.routingKey = ""
    this.serviceBus = serviceBus
  }

  /**
   * Creates the service with just a service bus and a route key
   *
   * @param serviceBus AMPQ service bus
   * @param routingKey Route key used to route different type of messages
   */
  def this(serviceBus: Bus, routingKey: String) {
    this()
    this.routingKey = routingKey
    this.serviceBus = serviceBus
  }

  def send(msg: AuditMessage) {
    serviceBus.send(msg, routingKey)
  }

  def auditPostcodeBlank(dln: String, searchedPostcode: String, request: HttpServletRequest, requestTime: DateTime) {
    send(new CustomerPostcodeIsBlank(dln, searchedPostcode, requestTime, new DateTime, HttpRequestHelper.getIpAddress(request)))
  }

  def auditPostcodeContainsSpecialCharacter(dln: String, searchedPostcode: String, request: HttpServletRequest, requestTime: DateTime) {
    send(new CustomerPostcodeContainsSpecialCharacter(dln, searchedPostcode, requestTime, new DateTime, HttpRequestHelper.getIpAddress(request)))
  }

  def auditPostcodeMismatch(dln: String, searchedPostcode: String, request: HttpServletRequest, requestTime: DateTime) {
    send(new CustomerPostcodeNotMatched(dln, searchedPostcode, requestTime, new DateTime, HttpRequestHelper.getIpAddress(request)))
  }

  def auditDlnSuppression(result: RulesDriver, dln: String, request: HttpServletRequest, requestSent: DateTime) {
    if (isDriverFullySuppressed(result)) {
      send(new CustomerDlnSuppressed(dln, requestSent, new DateTime, HttpRequestHelper.getIpAddress(request), result.getRuleApplied))
    }
  }

  def auditDetailsSuppression(result: RulesDriver, forenames: String, surname: String, dob: String, gender: Integer, postcode: String, request: HttpServletRequest, requestSent: DateTime) {
    if (isDriverFullySuppressed(result)) {
      val parsedDob: Date = ServiceDateFormat.DEFAULT.parse(dob)
      send(new CustomerPersonalDetailsSuppressed(forenames, surname, new DateTime(parsedDob), gender, postcode, requestSent, new DateTime, HttpRequestHelper.getIpAddress(request), result.getRuleApplied))
    }
  }

  def auditDVLADlnSuppression(result: RulesDriver, dln: String, requestSent: DateTime, contactChannel: String, enquiryReasons: JList[String], request: HttpServletRequest) {
    if (isDriverFullySuppressed(result)) {
      send(new DvlaDlnSuppressed(dln, requestSent, new DateTime, result.getRuleApplied, contactChannel, J2S.list(enquiryReasons), HttpRequestHelper.getIpAddress(request)))
    }
  }

  def auditDVLADetailsSuppression(result: RulesDriver, dln: String, forenames: String, surname: String, dob: String, gender: Integer, postcode: String, requestSent: DateTime, contactChannel: String, enquiryReasons: JList[String], request: HttpServletRequest) {
    if (isDriverFullySuppressed(result)) {
      val parsedDob: Date = ServiceDateFormat.DEFAULT.parse(dob)
      send(new DvlaPersonalDetailsSuppressed(dln, forenames, surname, new DateTime(parsedDob), gender, postcode, requestSent, new DateTime, result.getRuleApplied, contactChannel, J2S.list(enquiryReasons), HttpRequestHelper.getIpAddress(request)))
    }
  }

  def auditNINOAuthenticateSuccess(dln: String, coreMatch: String, coreAndAddressMatch: String, deceased: String, requestSent: DateTime, request: HttpServletRequest) {
    send(new NINOAuthenticateSuccess(dln, coreMatch, coreAndAddressMatch, deceased, requestSent, new DateTime, HttpRequestHelper.getIpAddress(request)))
  }

  def auditNINOAuthenticateFailure(dln: String, coreMatch: String, coreAndAddressMatch: String, deceased: String, requestSent: DateTime, request: HttpServletRequest) {
    send(new NINOAuthenticateFailure(dln, coreMatch, coreAndAddressMatch, deceased, requestSent, new DateTime, HttpRequestHelper.getIpAddress(request)))
  }

  def auditNINOAuthenticateDeceased(dln: String, coreMatch: String, coreAndAddressMatch: String, deceased: String, requestSent: DateTime, request: HttpServletRequest) {
    send(new NINOAuthenticateDeceased(dln, coreMatch, coreAndAddressMatch, deceased, requestSent, new DateTime, HttpRequestHelper.getIpAddress(request)))
  }

  def auditNINOAuthenticateServiceMaintenance(dln: String, requestSent: DateTime, request: HttpServletRequest) {
    send(new NINOAuthenticateServiceMaintenance(dln, requestSent, new DateTime, HttpRequestHelper.getIpAddress(request)))
  }

  def auditNINOAuthenticateServiceError(dln: String, requestSent: DateTime, request: HttpServletRequest) {
    send(new NINOAuthenticateServiceError(dln, requestSent, new DateTime, HttpRequestHelper.getIpAddress(request)))
  }

  def auditIDAMatch(matchId: String, requestReceived: DateTime, matchingOutcome: String, matchingBasis: String, pid: String) {
    send(new IDAMatchRequest(matchId, requestReceived, matchingOutcome, matchingBasis, pid))
  }

  def auditDCSValidationFailed(
                                address: String,
                                dateOfBirth: String,
                                dln: String,
                                familyName: String,
                                givenNames: JList[String],
                                issueNumber: String,
                                issuerID: String,
                                placeOfBirth: String,
                                requestId: String,
                                validFrom: String,
                                validTo: String,
                                reasons: JList[String]) {
    send(
      new DCSValidationFailed(
        Option(address),
        Option(dateOfBirth).map(DateTime.parse),
        dln,
        familyName,
        J2S.list(givenNames),
        issueNumber,
        issuerID,
        Option(placeOfBirth),
        requestId,
        validFrom,
        validTo,
        J2S.list(reasons)
      )
    )
  }

  def auditDCSMismatchWithDriverRecord(driverLicenceNumber: String, requestID: String) {
    send(new DCSDlnNotFound(driverLicenceNumber, requestID))
  }

  def auditDCSMatchingError(
                             address: String,
                             dateOfBirth: String,
                             dln: String,
                             familyName: String,
                             givenNames: JList[String],
                             issueNumber: String,
                             issuerID: String,
                             placeOfBirth: String,
                             requestId: String,
                             validFrom: String,
                             validTo: String,
                             matchingFailures: JList[String]) {
    send(
      new DCSMatchingRulesFail(
        Option(address),
        Option(dateOfBirth).map(DateTime.parse),
        dln,
        familyName,
        J2S.list(givenNames),
        issueNumber,
        issuerID,
        Option(placeOfBirth),
        requestId,
        validFrom,
        validTo,
        J2S.list(matchingFailures)
      )
    )
  }

  def auditDCSSuppression(
                           address: String,
                           dateOfBirth: String,
                           dln: String,
                           familyName: String,
                           givenNames: JList[String],
                           issueNumber: String,
                           issuerID: String,
                           placeOfBirth: String,
                           requestId: String,
                           validFrom: String,
                           validTo: String,
                           suppressionsRules: JList[String]) {
    send(
      new DCSSuppressed(
        Option(address),
        Option(dateOfBirth).map(DateTime.parse),
        dln,
        familyName,
        J2S.list(givenNames),
        issueNumber,
        issuerID,
        Option(placeOfBirth),
        requestId,
        validFrom,
        validTo,
        J2S.list(suppressionsRules)
      )
    )
  }

  def auditDCSDriverValidationSuccess(driverLicenceNumber: String, requestID: String) {
    send(new DCSMatchingSuccess(driverLicenceNumber, requestID))
  }

  private def isDriverFullySuppressed(driverResult: RulesDriver): Boolean = {
    var isFullySuppressed: Boolean = false
    if (driverResult != null && driverResult.getMessages != null) {
      import scala.collection.JavaConversions._
      for (message <- driverResult.getMessages) {
        if (message.getType == MessageType.SuppressFullRecord.getMessageType) {
          isFullySuppressed = true
        }
      }
    }
    return isFullySuppressed
  }
}
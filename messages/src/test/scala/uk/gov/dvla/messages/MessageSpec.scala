package uk.gov.dvla.messages

import org.scalatest._
import org.joda.time.DateTime

class MessageSpec extends FlatSpec with MustMatchers {

  val dln = "abc123"
  val requestSentDate = new DateTime()
  val responseSentDate = new DateTime().plusSeconds(2)
  val ipAddress = "127.0.0.1"
  val forename = "John"
  val surname = "Smith"
  val dob = new DateTime(1980, 12, 12, 1, 1)
  val gender = 0
  val postcode = "SA11EW"

  "When created, a CustomerDlnSuccessful audit message" should "have the correct result, status and service type" in {

    val customerDlnSuccessful = CustomerDlnSuccessful(dln, postcode, requestSentDate, responseSentDate, ipAddress)
    customerDlnSuccessful.status must be(Status.RecordFound)
    customerDlnSuccessful.result must be(Result.Success)
    customerDlnSuccessful.serviceType must be(ServiceType.CustomerPortal)
  }

  "When created, a CustomerPersonalDetailsSuccessful audit message" should "have the correct result, status and service type" in {

    val result = CustomerPersonalDetailsSuccessful(dln, forename, surname, dob, gender, postcode, requestSentDate, responseSentDate, ipAddress)
    result.status must be(Status.RecordFound)
    result.result must be(Result.Success)
    result.serviceType must be(ServiceType.CustomerPortal)
  }

  "When created, a CustomerDlnNotValid audit message" should "have the correct result, status and service type" in {

    val result = CustomerDlnNotValid(dln, requestSentDate, responseSentDate, ipAddress)
    result.status must be(Status.NotValid)
    result.result must be(Result.Failure)
    result.serviceType must be(ServiceType.CustomerPortal)
  }

  "When created, a CustomerPersonalDetailsNotValid audit message" should "have the correct result, status and service type" in {

    val result = CustomerDlnNotValid(dln, requestSentDate, responseSentDate, ipAddress)
    result.status must be(Status.NotValid)
    result.result must be(Result.Failure)
    result.serviceType must be(ServiceType.CustomerPortal)
  }

  "When created, a CustomerDlnNotFound audit message" should "have the correct result, status and service type" in {

    val result = CustomerDlnNotFound(dln, postcode, requestSentDate, responseSentDate, ipAddress)
    result.status must be(Status.NotFound)
    result.result must be(Result.Failure)
    result.serviceType must be(ServiceType.CustomerPortal)
  }

  "When created, a CustomerPersonalDetailsNotFound audit message" should "have the correct result, status and service type" in {

    val result = CustomerPersonalDetailsNotFound(forename, surname, dob, gender, postcode, requestSentDate, responseSentDate, ipAddress)
    result.status must be(Status.NotFound)
    result.result must be(Result.Failure)
    result.serviceType must be(ServiceType.CustomerPortal)
  }

  "When created, a CustomerDlnServerError audit message" should "have the correct result, status and service type" in {

    val result = CustomerDlnServerError(dln, requestSentDate, responseSentDate, ipAddress)
    result.status must be(Status.ServerError)
    result.result must be(Result.Failure)
    result.serviceType must be(ServiceType.CustomerPortal)
  }

  "When created, a CustomerPersonalDetailsServerError audit message" should "have the correct result, status and service type" in {

    val result = CustomerPersonalDetailsServerError(forename, surname, dob, gender, postcode, requestSentDate, responseSentDate, ipAddress)
    result.status must be(Status.ServerError)
    result.result must be(Result.Failure)
    result.serviceType must be(ServiceType.CustomerPortal)
  }

  "When created, a CustomerDlnSuppressed audit message" should "have the correct result, status and service type" in {

    val result = CustomerDlnSuppressed(dln, requestSentDate, responseSentDate, ipAddress, "RecordType N")
    result.status must be(Status.Suppressed)
    result.result must be(Result.Failure)
    result.serviceType must be(ServiceType.CustomerPortal)
  }

  "When created, a CustomerPersonalDetailsSuppressed audit message" should "have the correct result, status and service type" in {

    val result = CustomerPersonalDetailsSuppressed(forename, surname, dob, gender, postcode, requestSentDate, responseSentDate, ipAddress, "RecordType N")
    result.status must be(Status.Suppressed)
    result.result must be(Result.Failure)
    result.serviceType must be(ServiceType.CustomerPortal)
  }

  "When created, a CustomerMultipleFound audit message" should "have the correct result, status and service type" in {

    val result = CustomerMultipleFound(forename, surname, dob, gender, postcode, requestSentDate, responseSentDate, ipAddress)
    result.status must be(Status.MultipleRecordsFound)
    result.result must be(Result.Failure)
    result.serviceType must be(ServiceType.CustomerPortal)
  }
}

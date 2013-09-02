package uk.gov.dvla.messages

/* Code generated with XmlSerializationSpecGenerator.scala */

import org.specs2.mutable._
import scala.xml._
import java.util.UUID

class MesssageIdModifier(elem: Elem) {
  def withMessageId(uuid: UUID) = {
    val attrs = MetaData.concatenate(
      elem.attributes.remove("messageId"),
        <a messageId={uuid.toString}/>.attributes)
    elem.copy(attributes = attrs)
  }
}

object XmlSerializationSpec extends Specification {

  implicit def elem2MessageIdModifier(elem: Elem) = new MesssageIdModifier(elem)

  "XML serialization of an AuditMessage" should {

    "correctly reflect CustomerDlnNotFound instance" in {
      val message = CustomerDlnNotFound("LEESH702100C99DP", "SW11NA", org.joda.time.DateTime.parse("2013-07-13T12:13:14"), org.joda.time.DateTime.parse("2013-07-13T12:13:15"), "77.88.99.101")
      message.toXml mustEqual
          <CustomerDlnNotFound messageId="579836f4-6f4f-4bbc-a0fa-a9c22b3420b2" serviceType="CustomerPortal" status="NotFound" result="Failure" ipAddress="77.88.99.101" responseSent="2013-07-13T12:13:15.000+01:00" requestSent="2013-07-13T12:13:14.000+01:00" postCode="SW11NA" dln="LEESH702100C99DP"/>.withMessageId(message.messageId)
    }


    "correctly reflect DvlaDlnSuppressed instance" in {
      val message = DvlaDlnSuppressed("LEESH702100C99DP", org.joda.time.DateTime.parse("2013-07-13T12:13:14"), org.joda.time.DateTime.parse("2013-07-13T12:13:15"), "headache", "pigeon", "curiosity", "77.88.99.101")
      message.toXml mustEqual
          <DvlaDlnSuppressed messageId="947206cd-48ee-4e3f-87ca-0992df546de1" serviceType="DvlaPortal" status="Suppressed" result="Failure" ipAddress="77.88.99.101" enquiryReason="curiosity" contactChannel="pigeon" suppressionReason="headache" responseSent="2013-07-13T12:13:15.000+01:00" requestSent="2013-07-13T12:13:14.000+01:00" dln="LEESH702100C99DP"/>.withMessageId(message.messageId)
    }


    "correctly reflect MibRealTimeDlnNotValid instance" in {
      val message = MibRealTimeDlnNotValid(java.util.UUID.fromString("d4831d04-e691-4de0-9b8c-b8ac0309412c"), "LEESH702100C99DP", "SW11NA", org.joda.time.DateTime.parse("2013-07-13T12:13:14"), org.joda.time.DateTime.parse("2013-07-13T12:13:15"), "77.88.99.101")
      message.toXml mustEqual
          <MibRealTimeDlnNotValid messageId="26e9f875-5731-48cb-8c64-d553ea6ab51a" serviceType="MibRealTime" status="NotValid" result="Failure" ipAddress="77.88.99.101" responseSent="2013-07-13T12:13:15.000+01:00" requestSent="2013-07-13T12:13:14.000+01:00" postCode="SW11NA" dln="LEESH702100C99DP" enquiryId="d4831d04-e691-4de0-9b8c-b8ac0309412c"/>.withMessageId(message.messageId)
    }


    "correctly reflect MibRealTimeEnquiryMessageReturned instance" in {
      val message = MibRealTimeEnquiryMessageReturned(java.util.UUID.fromString("d4831d04-e691-4de0-9b8c-b8ac0309412c"), "LEESH702100C99DP", "SW11NA", org.joda.time.DateTime.parse("2013-07-13T12:13:14"), org.joda.time.DateTime.parse("2013-07-13T12:13:15"), "77.88.99.101", "Hello, World!")
      message.toXml mustEqual
          <MibRealTimeEnquiryMessageReturned messageId="2963305f-eaf2-4ae9-afb6-50aec5a1b27f" serviceType="MibRealTime" status="MessageReturned" result="Success" message="Hello, World!" ipAddress="77.88.99.101" responseSent="2013-07-13T12:13:15.000+01:00" requestSent="2013-07-13T12:13:14.000+01:00" postCode="SW11NA" dln="LEESH702100C99DP" enquiryId="d4831d04-e691-4de0-9b8c-b8ac0309412c"/>.withMessageId(message.messageId)
    }


    "correctly reflect MibRealTimeRecordSuppression instance" in {
      val message = MibRealTimeRecordSuppression(java.util.UUID.fromString("d4831d04-e691-4de0-9b8c-b8ac0309412c"), "LEESH702100C99DP", "SW11NA", org.joda.time.DateTime.parse("2013-07-13T12:13:14"), org.joda.time.DateTime.parse("2013-07-13T12:13:15"), "rule of thumb", "77.88.99.101")
      message.toXml mustEqual
          <MibRealTimeRecordSuppression messageId="7555306c-cb70-44e2-96f6-8e6c9813c0a8" serviceType="MibRealTime" status="Suppressed" result="Failure" ipAddress="77.88.99.101" ruleApplied="rule of thumb" responseSent="2013-07-13T12:13:15.000+01:00" requestSent="2013-07-13T12:13:14.000+01:00" postCode="SW11NA" dln="LEESH702100C99DP" enquiryId="d4831d04-e691-4de0-9b8c-b8ac0309412c"/>.withMessageId(message.messageId)
    }


    "correctly reflect CustomerPostcodeIsBlank instance" in {
      val message = CustomerPostcodeIsBlank("LEESH702100C99DP", "SW11NA", org.joda.time.DateTime.parse("2013-07-13T12:13:14"), org.joda.time.DateTime.parse("2013-07-13T12:13:15"), "77.88.99.101")
      message.toXml mustEqual
          <CustomerPostcodeIsBlank messageId="1412c647-0f65-4b4c-8da8-7bae5bac7037" serviceType="CustomerPortal" status="PostcodeIsBlank" result="Success" ipAddress="77.88.99.101" responseSent="2013-07-13T12:13:15.000+01:00" requestSent="2013-07-13T12:13:14.000+01:00" postCode="SW11NA" dln="LEESH702100C99DP"/>.withMessageId(message.messageId)
    }


    "correctly reflect CustomerPersonalDetailsSuppressed instance" in {
      val message = CustomerPersonalDetailsSuppressed("Alice", "Allison", org.joda.time.DateTime.parse("1984-04-13"), 1, "SW11NA", org.joda.time.DateTime.parse("2013-07-13T12:13:14"), org.joda.time.DateTime.parse("2013-07-13T12:13:15"), "77.88.99.101", "headache")
      message.toXml mustEqual
          <CustomerPersonalDetailsSuppressed messageId="9c8ca338-c241-4c23-809b-86c5e646dc16" serviceType="CustomerPortal" status="Suppressed" result="Failure" suppressionReason="headache" ipAddress="77.88.99.101" responseSent="2013-07-13T12:13:15.000+01:00" requestSent="2013-07-13T12:13:14.000+01:00" postCode="SW11NA" gender="1" dob="1984-04-13T00:00:00.000+01:00" surname="Allison" forename="Alice"/>.withMessageId(message.messageId)
    }


    "correctly reflect DvlaDlnNotFound instance" in {
      val message = DvlaDlnNotFound("LEESH702100C99DP", org.joda.time.DateTime.parse("2013-07-13T12:13:14"), org.joda.time.DateTime.parse("2013-07-13T12:13:15"), "pigeon", "curiosity", "123", "77.88.99.101")
      message.toXml mustEqual
          <DvlaDlnNotFound messageId="d843119d-6e1e-475e-b143-4b605a90b47f" serviceType="DvlaPortal" status="NotFound" result="Failure" ipAddress="77.88.99.101" userId="123" enquiryReason="curiosity" contactChannel="pigeon" responseSent="2013-07-13T12:13:15.000+01:00" requestSent="2013-07-13T12:13:14.000+01:00" dln="LEESH702100C99DP"/>.withMessageId(message.messageId)
    }


    "correctly reflect CustomerPersonalDetailsNotValid instance" in {
      val message = CustomerPersonalDetailsNotValid("Alice", "Allison", org.joda.time.DateTime.parse("1984-04-13"), 1, "SW11NA", org.joda.time.DateTime.parse("2013-07-13T12:13:14"), org.joda.time.DateTime.parse("2013-07-13T12:13:15"), "77.88.99.101")
      message.toXml mustEqual
          <CustomerPersonalDetailsNotValid messageId="291cbd38-061b-4e2d-aac2-c376c4ad1219" serviceType="CustomerPortal" status="NotValid" result="Failure" ipAddress="77.88.99.101" responseSent="2013-07-13T12:13:15.000+01:00" requestSent="2013-07-13T12:13:14.000+01:00" postCode="SW11NA" gender="1" dob="1984-04-13T00:00:00.000+01:00" surname="Allison" forename="Alice"/>.withMessageId(message.messageId)
    }


    "correctly reflect DvlaPersonalDetailsServerError instance" in {
      val message = DvlaPersonalDetailsServerError("Alice", "Allison", org.joda.time.DateTime.parse("1984-04-13"), 1, "SW11NA", org.joda.time.DateTime.parse("2013-07-13T12:13:14"), org.joda.time.DateTime.parse("2013-07-13T12:13:15"), "pigeon", "curiosity", "123", "77.88.99.101")
      message.toXml mustEqual
          <DvlaPersonalDetailsServerError messageId="f846189a-56c1-4645-a591-9e16bf950282" serviceType="DvlaPortal" status="ServerError" result="Failure" ipAddress="77.88.99.101" userId="123" enquiryReason="curiosity" contactChannel="pigeon" responseSent="2013-07-13T12:13:15.000+01:00" requestSent="2013-07-13T12:13:14.000+01:00" postCode="SW11NA" gender="1" dob="1984-04-13T00:00:00.000+01:00" surname="Allison" forename="Alice"/>.withMessageId(message.messageId)
    }


    "correctly reflect CustomerMultipleFound instance" in {
      val message = CustomerMultipleFound("Alice", "Allison", org.joda.time.DateTime.parse("1984-04-13"), 1, "SW11NA", org.joda.time.DateTime.parse("2013-07-13T12:13:14"), org.joda.time.DateTime.parse("2013-07-13T12:13:15"), "77.88.99.101")
      message.toXml mustEqual
          <CustomerMultipleFound messageId="0eb79403-d78a-4f5d-91cb-ad94e933f9a1" serviceType="CustomerPortal" status="MultipleRecordsFound" result="Failure" ipAddress="77.88.99.101" responseSent="2013-07-13T12:13:15.000+01:00" requestSent="2013-07-13T12:13:14.000+01:00" postCode="SW11NA" gender="1" dob="1984-04-13T00:00:00.000+01:00" surname="Allison" forename="Alice"/>.withMessageId(message.messageId)
    }


    "correctly reflect CustomerPostcodeContainsSpecialCharacter instance" in {
      val message = CustomerPostcodeContainsSpecialCharacter("LEESH702100C99DP", "SW11NA", org.joda.time.DateTime.parse("2013-07-13T12:13:14"), org.joda.time.DateTime.parse("2013-07-13T12:13:15"), "77.88.99.101")
      message.toXml mustEqual
          <CustomerPostcodeContainsSpecialCharacter messageId="fb1ff72e-639d-434d-a08e-85a08c236fd4" serviceType="CustomerPortal" status="PostcodeContainsSpecialCharacter" result="Success" ipAddress="77.88.99.101" responseSent="2013-07-13T12:13:15.000+01:00" requestSent="2013-07-13T12:13:14.000+01:00" postCode="SW11NA" dln="LEESH702100C99DP"/>.withMessageId(message.messageId)
    }


    "correctly reflect DvlaPersonalDetailsNotFound instance" in {
      val message = DvlaPersonalDetailsNotFound("Alice", "Allison", org.joda.time.DateTime.parse("1984-04-13"), 1, "SW11NA", org.joda.time.DateTime.parse("2013-07-13T12:13:14"), org.joda.time.DateTime.parse("2013-07-13T12:13:15"), "pigeon", "curiosity", "123", "77.88.99.101")
      message.toXml mustEqual
          <DvlaPersonalDetailsNotFound messageId="5df16b5e-55b7-42d3-971d-7045fdeb58bf" serviceType="DvlaPortal" status="NotFound" result="Failure" ipAddress="77.88.99.101" userId="123" enquiryReason="curiosity" contactChannel="pigeon" responseSent="2013-07-13T12:13:15.000+01:00" requestSent="2013-07-13T12:13:14.000+01:00" postCode="SW11NA" gender="1" dob="1984-04-13T00:00:00.000+01:00" surname="Allison" forename="Alice"/>.withMessageId(message.messageId)
    }


    "correctly reflect MibRealTimeNoEntitlements instance" in {
      val message = MibRealTimeNoEntitlements(java.util.UUID.fromString("d4831d04-e691-4de0-9b8c-b8ac0309412c"), "LEESH702100C99DP", "SW11NA", org.joda.time.DateTime.parse("2013-07-13T12:13:14"), org.joda.time.DateTime.parse("2013-07-13T12:13:15"), "77.88.99.101")
      message.toXml mustEqual
          <MibRealTimeNoEntitlements messageId="f944146c-866f-4d60-b34c-c6c93ec110f6" serviceType="MibRealTime" status="NotAvailable" result="Failure" ipAddress="77.88.99.101" responseSent="2013-07-13T12:13:15.000+01:00" requestSent="2013-07-13T12:13:14.000+01:00" postCode="SW11NA" dln="LEESH702100C99DP" enquiryId="d4831d04-e691-4de0-9b8c-b8ac0309412c"/>.withMessageId(message.messageId)
    }


    "correctly reflect MibRealTimeServerError instance" in {
      val message = MibRealTimeServerError(java.util.UUID.fromString("d4831d04-e691-4de0-9b8c-b8ac0309412c"), "LEESH702100C99DP", "SW11NA", org.joda.time.DateTime.parse("2013-07-13T12:13:14"), org.joda.time.DateTime.parse("2013-07-13T12:13:15"), "77.88.99.101")
      message.toXml mustEqual
          <MibRealTimeServerError messageId="185fdb9f-f69a-4c12-81c9-71d23093ce1e" serviceType="MibRealTime" status="ServerError" result="Failure" ipAddress="77.88.99.101" responseSent="2013-07-13T12:13:15.000+01:00" requestSent="2013-07-13T12:13:14.000+01:00" postCode="SW11NA" dln="LEESH702100C99DP" enquiryId="d4831d04-e691-4de0-9b8c-b8ac0309412c"/>.withMessageId(message.messageId)
    }


    "correctly reflect CustomerPostcodeNotMatched instance" in {
      val message = CustomerPostcodeNotMatched("LEESH702100C99DP", "SW11NA", org.joda.time.DateTime.parse("2013-07-13T12:13:14"), org.joda.time.DateTime.parse("2013-07-13T12:13:15"), "77.88.99.101")
      message.toXml mustEqual
          <CustomerPostcodeNotMatched messageId="e987fcd0-7ded-4c47-b744-1d4104094664" serviceType="CustomerPortal" status="NotValid" result="Failure" ipAddress="77.88.99.101" responseSent="2013-07-13T12:13:15.000+01:00" requestSent="2013-07-13T12:13:14.000+01:00" postCode="SW11NA" dln="LEESH702100C99DP"/>.withMessageId(message.messageId)
    }


    "correctly reflect DvlaDlnServerError instance" in {
      val message = DvlaDlnServerError("LEESH702100C99DP", org.joda.time.DateTime.parse("2013-07-13T12:13:14"), org.joda.time.DateTime.parse("2013-07-13T12:13:15"), "pigeon", "curiosity", "123", "77.88.99.101")
      message.toXml mustEqual
          <DvlaDlnServerError messageId="e7acfc38-043c-42b7-b378-fbaeef235e48" serviceType="DvlaPortal" status="ServerError" result="Failure" ipAddress="77.88.99.101" userId="123" enquiryReason="curiosity" contactChannel="pigeon" responseSent="2013-07-13T12:13:15.000+01:00" requestSent="2013-07-13T12:13:14.000+01:00" dln="LEESH702100C99DP"/>.withMessageId(message.messageId)
    }


    "correctly reflect CustomerDlnNotValid instance" in {
      val message = CustomerDlnNotValid("LEESH702100C99DP", org.joda.time.DateTime.parse("2013-07-13T12:13:14"), org.joda.time.DateTime.parse("2013-07-13T12:13:15"), "77.88.99.101")
      message.toXml mustEqual
          <CustomerDlnNotValid messageId="4e780f67-b6fb-4860-97e4-c7b398a4e0f1" serviceType="CustomerPortal" status="NotValid" result="Failure" ipAddress="77.88.99.101" responseSent="2013-07-13T12:13:15.000+01:00" requestSent="2013-07-13T12:13:14.000+01:00" dln="LEESH702100C99DP"/>.withMessageId(message.messageId)
    }


    "correctly reflect CustomerPersonalDetailsServerError instance" in {
      val message = CustomerPersonalDetailsServerError("Alice", "Allison", org.joda.time.DateTime.parse("1984-04-13"), 1, "SW11NA", org.joda.time.DateTime.parse("2013-07-13T12:13:14"), org.joda.time.DateTime.parse("2013-07-13T12:13:15"), "77.88.99.101")
      message.toXml mustEqual
          <CustomerPersonalDetailsServerError messageId="d9cb4496-cccd-474a-a975-bf67f90d729e" serviceType="CustomerPortal" status="ServerError" result="Failure" ipAddress="77.88.99.101" responseSent="2013-07-13T12:13:15.000+01:00" requestSent="2013-07-13T12:13:14.000+01:00" postCode="SW11NA" gender="1" dob="1984-04-13T00:00:00.000+01:00" surname="Allison" forename="Alice"/>.withMessageId(message.messageId)
    }


    "correctly reflect MibRealTimeDlnNotFound instance" in {
      val message = MibRealTimeDlnNotFound(java.util.UUID.fromString("d4831d04-e691-4de0-9b8c-b8ac0309412c"), "LEESH702100C99DP", "SW11NA", org.joda.time.DateTime.parse("2013-07-13T12:13:14"), org.joda.time.DateTime.parse("2013-07-13T12:13:15"), "77.88.99.101")
      message.toXml mustEqual
          <MibRealTimeDlnNotFound messageId="970ac8ca-71d4-41be-a410-47045c1ca35a" serviceType="MibRealTime" status="NotFound" result="Failure" ipAddress="77.88.99.101" responseSent="2013-07-13T12:13:15.000+01:00" requestSent="2013-07-13T12:13:14.000+01:00" postCode="SW11NA" dln="LEESH702100C99DP" enquiryId="d4831d04-e691-4de0-9b8c-b8ac0309412c"/>.withMessageId(message.messageId)
    }


    "correctly reflect MibRealTimeMissingMandatoryFields instance" in {
      val message = MibRealTimeMissingMandatoryFields(java.util.UUID.fromString("d4831d04-e691-4de0-9b8c-b8ac0309412c"), "LEESH702100C99DP", "SW11NA", org.joda.time.DateTime.parse("2013-07-13T12:13:14"), org.joda.time.DateTime.parse("2013-07-13T12:13:15"), "77.88.99.101")
      message.toXml mustEqual
          <MibRealTimeMissingMandatoryFields messageId="ad7066d0-1049-4fd9-9103-0643db9004e9" serviceType="MibRealTime" status="NotValid" result="Failure" ipAddress="77.88.99.101" responseSent="2013-07-13T12:13:15.000+01:00" requestSent="2013-07-13T12:13:14.000+01:00" postCode="SW11NA" dln="LEESH702100C99DP" enquiryId="d4831d04-e691-4de0-9b8c-b8ac0309412c"/>.withMessageId(message.messageId)
    }


    "correctly reflect DvlaDlnSuccessful instance" in {
      val message = DvlaDlnSuccessful("LEESH702100C99DP", org.joda.time.DateTime.parse("2013-07-13T12:13:14"), org.joda.time.DateTime.parse("2013-07-13T12:13:15"), "pigeon", "curiosity", "123", "77.88.99.101")
      message.toXml mustEqual
          <DvlaDlnSuccessful messageId="058ce147-fae8-4be3-926e-1cd8c63b8912" serviceType="DvlaPortal" status="RecordFound" result="Success" ipAddress="77.88.99.101" userId="123" enquiryReason="curiosity" contactChannel="pigeon" responseSent="2013-07-13T12:13:15.000+01:00" requestSent="2013-07-13T12:13:14.000+01:00" dln="LEESH702100C99DP"/>.withMessageId(message.messageId)
    }


    "correctly reflect DvlaUnauthorisedAccess instance" in {
      val message = DvlaUnauthorisedAccess("123", org.joda.time.DateTime.parse("2013-07-13T12:13:14"), org.joda.time.DateTime.parse("2013-07-13T12:13:15"), "77.88.99.101")
      message.toXml mustEqual
          <DvlaUnauthorisedAccess messageId="e80854ac-9861-4114-b6f9-31b222278ff5" serviceType="DvlaPortal" status="UnauthorisedAccess" result="Failure" ipAddress="77.88.99.101" responseSent="2013-07-13T12:13:15.000+01:00" requestSent="2013-07-13T12:13:14.000+01:00" userId="123"/>.withMessageId(message.messageId)
    }


    "correctly reflect DvlaDlnNotValid instance" in {
      val message = DvlaDlnNotValid("LEESH702100C99DP", org.joda.time.DateTime.parse("2013-07-13T12:13:14"), org.joda.time.DateTime.parse("2013-07-13T12:13:15"), "pigeon", "curiosity", "123", "77.88.99.101")
      message.toXml mustEqual
          <DvlaDlnNotValid messageId="4fe3ad3d-2d34-48ae-876f-5dab415a59a2" serviceType="DvlaPortal" status="NotValid" result="Failure" ipAddress="77.88.99.101" userId="123" enquiryReason="curiosity" contactChannel="pigeon" responseSent="2013-07-13T12:13:15.000+01:00" requestSent="2013-07-13T12:13:14.000+01:00" dln="LEESH702100C99DP"/>.withMessageId(message.messageId)
    }


    "correctly reflect DvlaPersonalDetailsNotValid instance" in {
      val message = DvlaPersonalDetailsNotValid("Alice", "Allison", org.joda.time.DateTime.parse("1984-04-13"), 1, "SW11NA", org.joda.time.DateTime.parse("2013-07-13T12:13:14"), org.joda.time.DateTime.parse("2013-07-13T12:13:15"), "pigeon", "curiosity", "123", "77.88.99.101")
      message.toXml mustEqual
          <DvlaPersonalDetailsNotValid messageId="3a90d16f-f895-4ac5-94c5-2ce2a92196ca" serviceType="DvlaPortal" status="NotFound" result="Failure" ipAddress="77.88.99.101" userId="123" enquiryReason="curiosity" contactChannel="pigeon" responseSent="2013-07-13T12:13:15.000+01:00" requestSent="2013-07-13T12:13:14.000+01:00" postCode="SW11NA" gender="1" dob="1984-04-13T00:00:00.000+01:00" surname="Allison" forename="Alice"/>.withMessageId(message.messageId)
    }


    "correctly reflect MibRealTimeEnquirySuccessful instance" in {
      val message = MibRealTimeEnquirySuccessful(java.util.UUID.fromString("d4831d04-e691-4de0-9b8c-b8ac0309412c"), "LEESH702100C99DP", "SW11NA", org.joda.time.DateTime.parse("2013-07-13T12:13:14"), org.joda.time.DateTime.parse("2013-07-13T12:13:15"), "77.88.99.101")
      message.toXml mustEqual
          <MibRealTimeEnquirySuccessful messageId="0c1f3a7b-85ff-4670-884b-899c134cce24" serviceType="MibRealTime" status="RecordFound" result="Success" ipAddress="77.88.99.101" responseSent="2013-07-13T12:13:15.000+01:00" requestSent="2013-07-13T12:13:14.000+01:00" postCode="SW11NA" dln="LEESH702100C99DP" enquiryId="d4831d04-e691-4de0-9b8c-b8ac0309412c"/>.withMessageId(message.messageId)
    }


    "correctly reflect DvlaPersonalDetailsSuccessful instance" in {
      val message = DvlaPersonalDetailsSuccessful("LEESH702100C99DP", "Alice", "Allison", org.joda.time.DateTime.parse("1984-04-13"), 1, "SW11NA", org.joda.time.DateTime.parse("2013-07-13T12:13:14"), org.joda.time.DateTime.parse("2013-07-13T12:13:15"), "pigeon", "curiosity", "123", "77.88.99.101")
      message.toXml mustEqual
          <DvlaPersonalDetailsSuccessful messageId="8215a57b-9cc3-448f-a00b-24fe68aa9c22" serviceType="DvlaPortal" status="RecordFound" result="Success" ipAddress="77.88.99.101" userId="123" enquiryReason="curiosity" contactChannel="pigeon" responseSent="2013-07-13T12:13:15.000+01:00" requestSent="2013-07-13T12:13:14.000+01:00" postCode="SW11NA" gender="1" dob="1984-04-13T00:00:00.000+01:00" surname="Allison" forename="Alice" dln="LEESH702100C99DP"/>.withMessageId(message.messageId)
    }


    "correctly reflect CustomerDlnServerError instance" in {
      val message = CustomerDlnServerError("LEESH702100C99DP", org.joda.time.DateTime.parse("2013-07-13T12:13:14"), org.joda.time.DateTime.parse("2013-07-13T12:13:15"), "77.88.99.101")
      message.toXml mustEqual
          <CustomerDlnServerError messageId="97e44d8f-748c-4ffd-8d81-165a4d22fa35" serviceType="CustomerPortal" status="ServerError" result="Failure" ipAddress="77.88.99.101" responseSent="2013-07-13T12:13:15.000+01:00" requestSent="2013-07-13T12:13:14.000+01:00" dln="LEESH702100C99DP"/>.withMessageId(message.messageId)
    }


    "correctly reflect CustomerDlnSuccessful instance" in {
      val message = CustomerDlnSuccessful("LEESH702100C99DP", "SW11NA", org.joda.time.DateTime.parse("2013-07-13T12:13:14"), org.joda.time.DateTime.parse("2013-07-13T12:13:15"), "77.88.99.101")
      message.toXml mustEqual
          <CustomerDlnSuccessful messageId="e6326f85-0f14-4f79-9536-def561c1b6b5" serviceType="CustomerPortal" status="RecordFound" result="Success" ipAddress="77.88.99.101" responseSent="2013-07-13T12:13:15.000+01:00" requestSent="2013-07-13T12:13:14.000+01:00" postCode="SW11NA" dln="LEESH702100C99DP"/>.withMessageId(message.messageId)
    }


    "correctly reflect CustomerPersonalDetailsNotFound instance" in {
      val message = CustomerPersonalDetailsNotFound("Alice", "Allison", org.joda.time.DateTime.parse("1984-04-13"), 1, "SW11NA", org.joda.time.DateTime.parse("2013-07-13T12:13:14"), org.joda.time.DateTime.parse("2013-07-13T12:13:15"), "77.88.99.101")
      message.toXml mustEqual
          <CustomerPersonalDetailsNotFound messageId="beb2c431-d62c-46f5-a8e7-5a8ce3f8ef26" serviceType="CustomerPortal" status="NotFound" result="Failure" ipAddress="77.88.99.101" responseSent="2013-07-13T12:13:15.000+01:00" requestSent="2013-07-13T12:13:14.000+01:00" postCode="SW11NA" gender="1" dob="1984-04-13T00:00:00.000+01:00" surname="Allison" forename="Alice"/>.withMessageId(message.messageId)
    }


    "correctly reflect CustomerPersonalDetailsSuccessful instance" in {
      val message = CustomerPersonalDetailsSuccessful("LEESH702100C99DP", "Alice", "Allison", org.joda.time.DateTime.parse("1984-04-13"), 1, "SW11NA", org.joda.time.DateTime.parse("2013-07-13T12:13:14"), org.joda.time.DateTime.parse("2013-07-13T12:13:15"), "77.88.99.101")
      message.toXml mustEqual
          <CustomerPersonalDetailsSuccessful messageId="56bc9e75-7427-49c3-b732-78bded86bac6" serviceType="CustomerPortal" status="RecordFound" result="Success" ipAddress="77.88.99.101" responseSent="2013-07-13T12:13:15.000+01:00" requestSent="2013-07-13T12:13:14.000+01:00" postCode="SW11NA" gender="1" dob="1984-04-13T00:00:00.000+01:00" surname="Allison" forename="Alice" dln="LEESH702100C99DP"/>.withMessageId(message.messageId)
    }


    "correctly reflect DvlaPersonalDetailsSuppressed instance" in {
      val message = DvlaPersonalDetailsSuppressed("LEESH702100C99DP", "Alice", "Allison", org.joda.time.DateTime.parse("1984-04-13"), 1, "SW11NA", org.joda.time.DateTime.parse("2013-07-13T12:13:14"), org.joda.time.DateTime.parse("2013-07-13T12:13:15"), "headache", "pigeon", "curiosity", "77.88.99.101")
      message.toXml mustEqual
          <DvlaPersonalDetailsSuppressed messageId="d078d572-640b-4071-ad18-cb2105793b77" serviceType="DvlaPortal" status="Suppressed" result="Failure" ipAddress="77.88.99.101" enquiryReason="curiosity" contactChannel="pigeon" suppressionReason="headache" responseSent="2013-07-13T12:13:15.000+01:00" requestSent="2013-07-13T12:13:14.000+01:00" postCode="SW11NA" gender="1" dob="1984-04-13T00:00:00.000+01:00" surname="Allison" forename="Alice" dln="LEESH702100C99DP"/>.withMessageId(message.messageId)
    }


    "correctly reflect DvlaMultipleFound instance" in {
      val message = DvlaMultipleFound("Alice", "Allison", org.joda.time.DateTime.parse("1984-04-13"), 1, "SW11NA", org.joda.time.DateTime.parse("2013-07-13T12:13:14"), org.joda.time.DateTime.parse("2013-07-13T12:13:15"), "pigeon", "curiosity", "123", "77.88.99.101")
      message.toXml mustEqual
          <DvlaMultipleFound messageId="35817949-ce9f-42cc-a686-6ccb723c73e4" serviceType="DvlaPortal" status="MultipleRecordsFound" result="Failure" ipAddress="77.88.99.101" userId="123" enquiryReason="curiosity" contactChannel="pigeon" responseSent="2013-07-13T12:13:15.000+01:00" requestSent="2013-07-13T12:13:14.000+01:00" postCode="SW11NA" gender="1" dob="1984-04-13T00:00:00.000+01:00" surname="Allison" forename="Alice"/>.withMessageId(message.messageId)
    }

  }
}
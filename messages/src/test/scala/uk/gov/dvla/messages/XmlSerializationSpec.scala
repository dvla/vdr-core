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

    "correctly reflect DvlaDlnNotFound instance" in {
      val message = DvlaDlnNotFound("LEESH702100C99DP", org.joda.time.DateTime.parse("2013-07-13T12:13:14"), org.joda.time.DateTime.parse("2013-07-13T12:13:15"), "pigeon", "curiosity", "123", "77.88.99.101")
      message.toXml mustEqual
          <DvlaDlnNotFound messageId="99713eb8-63db-46c8-b2bf-4d07e824044c" serviceType="DvlaPortal" status="NotFound" result="Failure" ipAddress="77.88.99.101" userId="123" enquiryReason="curiosity" contactChannel="pigeon" responseSent="2013-07-13T12:13:15.000+01:00" requestSent="2013-07-13T12:13:14.000+01:00" dln="LEESH702100C99DP"/>.withMessageId(message.messageId)
    }


    "correctly reflect DvlaDlnSuppressed instance" in {
      val message = DvlaDlnSuppressed("LEESH702100C99DP", org.joda.time.DateTime.parse("2013-07-13T12:13:14"), org.joda.time.DateTime.parse("2013-07-13T12:13:15"), "headache", "pigeon", "curiosity", "77.88.99.101")
      message.toXml mustEqual
          <DvlaDlnSuppressed messageId="5bdaabe6-ceb4-4f86-8968-2b5502f36f4c" serviceType="DvlaPortal" status="Suppressed" result="Failure" ipAddress="77.88.99.101" enquiryReason="curiosity" contactChannel="pigeon" suppressionReason="headache" responseSent="2013-07-13T12:13:15.000+01:00" requestSent="2013-07-13T12:13:14.000+01:00" dln="LEESH702100C99DP"/>.withMessageId(message.messageId)
    }


    "correctly reflect CustomerPostcodeContainsSpecialCharacter instance" in {
      val message = CustomerPostcodeContainsSpecialCharacter("LEESH702100C99DP", "SW11NA", org.joda.time.DateTime.parse("2013-07-13T12:13:14"), org.joda.time.DateTime.parse("2013-07-13T12:13:15"), "77.88.99.101")
      message.toXml mustEqual
          <CustomerPostcodeContainsSpecialCharacter messageId="1fda610a-363a-4452-924f-db1ae52edede" serviceType="CustomerPortal" status="PostcodeContainsSpecialCharacter" result="Success" ipAddress="77.88.99.101" responseSent="2013-07-13T12:13:15.000+01:00" requestSent="2013-07-13T12:13:14.000+01:00" postCode="SW11NA" dln="LEESH702100C99DP"/>.withMessageId(message.messageId)
    }


    "correctly reflect DvlaDlnSuccessful instance" in {
      val message = DvlaDlnSuccessful("LEESH702100C99DP", org.joda.time.DateTime.parse("2013-07-13T12:13:14"), org.joda.time.DateTime.parse("2013-07-13T12:13:15"), "pigeon", "curiosity", "123", "77.88.99.101")
      message.toXml mustEqual
          <DvlaDlnSuccessful messageId="d838aee6-2a64-47ea-a420-4ce7bb06cab6" serviceType="DvlaPortal" status="RecordFound" result="Success" ipAddress="77.88.99.101" userId="123" enquiryReason="curiosity" contactChannel="pigeon" responseSent="2013-07-13T12:13:15.000+01:00" requestSent="2013-07-13T12:13:14.000+01:00" dln="LEESH702100C99DP"/>.withMessageId(message.messageId)
    }


    "correctly reflect CustomerDlnSuppressed instance" in {
      val message = CustomerDlnSuppressed("LEESH702100C99DP", org.joda.time.DateTime.parse("2013-07-13T12:13:14"), org.joda.time.DateTime.parse("2013-07-13T12:13:15"), "77.88.99.101", "headache")
      message.toXml mustEqual
          <CustomerDlnSuppressed messageId="1dcea49b-9ede-41dc-8e09-6c901112b53d" serviceType="CustomerPortal" status="Suppressed" result="Failure" suppressionReason="headache" ipAddress="77.88.99.101" responseSent="2013-07-13T12:13:15.000+01:00" requestSent="2013-07-13T12:13:14.000+01:00" dln="LEESH702100C99DP"/>.withMessageId(message.messageId)
    }


    "correctly reflect MibRealTimeMissingMandatoryFields instance" in {
      val message = MibRealTimeMissingMandatoryFields(java.util.UUID.fromString("5da8d467-ec76-415e-9edc-8daa2e286208"), "LEESH702100C99DP", "SW11NA", org.joda.time.DateTime.parse("2013-07-13T12:13:14"), org.joda.time.DateTime.parse("2013-07-13T12:13:15"), "77.88.99.101")
      message.toXml mustEqual
          <MibRealTimeMissingMandatoryFields messageId="a4a73c2c-97bb-4815-a2c2-d4dadbf294a2" serviceType="MibRealTime" status="NotValid" result="Failure" ipAddress="77.88.99.101" responseSent="2013-07-13T12:13:15.000+01:00" requestSent="2013-07-13T12:13:14.000+01:00" postCode="SW11NA" dln="LEESH702100C99DP" enquiryId="5da8d467-ec76-415e-9edc-8daa2e286208"/>.withMessageId(message.messageId)
    }


    "correctly reflect DvlaPersonalDetailsNotFound instance" in {
      val message = DvlaPersonalDetailsNotFound("Alice", "Allison", org.joda.time.DateTime.parse("1984-04-13"), 1, "SW11NA", org.joda.time.DateTime.parse("2013-07-13T12:13:14"), org.joda.time.DateTime.parse("2013-07-13T12:13:15"), "pigeon", "curiosity", "123", "77.88.99.101")
      message.toXml mustEqual
          <DvlaPersonalDetailsNotFound messageId="c3c601ec-1925-4ec7-bdb8-9ab6e53beed2" serviceType="DvlaPortal" status="NotFound" result="Failure" ipAddress="77.88.99.101" userId="123" enquiryReason="curiosity" contactChannel="pigeon" responseSent="2013-07-13T12:13:15.000+01:00" requestSent="2013-07-13T12:13:14.000+01:00" postCode="SW11NA" gender="1" dob="1984-04-13T00:00:00.000+01:00" surname="Allison" forename="Alice"/>.withMessageId(message.messageId)
    }


    "correctly reflect CustomerDlnNotValid instance" in {
      val message = CustomerDlnNotValid("LEESH702100C99DP", org.joda.time.DateTime.parse("2013-07-13T12:13:14"), org.joda.time.DateTime.parse("2013-07-13T12:13:15"), "77.88.99.101")
      message.toXml mustEqual
          <CustomerDlnNotValid messageId="abf2e1f0-e7fb-40b3-b3a7-603c24dd891b" serviceType="CustomerPortal" status="NotValid" result="Failure" ipAddress="77.88.99.101" responseSent="2013-07-13T12:13:15.000+01:00" requestSent="2013-07-13T12:13:14.000+01:00" dln="LEESH702100C99DP"/>.withMessageId(message.messageId)
    }


    "correctly reflect CustomerPersonalDetailsSuppressed instance" in {
      val message = CustomerPersonalDetailsSuppressed("Alice", "Allison", org.joda.time.DateTime.parse("1984-04-13"), 1, "SW11NA", org.joda.time.DateTime.parse("2013-07-13T12:13:14"), org.joda.time.DateTime.parse("2013-07-13T12:13:15"), "77.88.99.101", "headache")
      message.toXml mustEqual
          <CustomerPersonalDetailsSuppressed messageId="88310958-f55f-4fc2-bdca-aeafe7ceebb6" serviceType="CustomerPortal" status="Suppressed" result="Failure" suppressionReason="headache" ipAddress="77.88.99.101" responseSent="2013-07-13T12:13:15.000+01:00" requestSent="2013-07-13T12:13:14.000+01:00" postCode="SW11NA" gender="1" dob="1984-04-13T00:00:00.000+01:00" surname="Allison" forename="Alice"/>.withMessageId(message.messageId)
    }


    "correctly reflect DvlaDlnServerError instance" in {
      val message = DvlaDlnServerError("LEESH702100C99DP", org.joda.time.DateTime.parse("2013-07-13T12:13:14"), org.joda.time.DateTime.parse("2013-07-13T12:13:15"), "pigeon", "curiosity", "123", "77.88.99.101")
      message.toXml mustEqual
          <DvlaDlnServerError messageId="544558fb-b9ec-428a-998f-f71c19bee725" serviceType="DvlaPortal" status="ServerError" result="Failure" ipAddress="77.88.99.101" userId="123" enquiryReason="curiosity" contactChannel="pigeon" responseSent="2013-07-13T12:13:15.000+01:00" requestSent="2013-07-13T12:13:14.000+01:00" dln="LEESH702100C99DP"/>.withMessageId(message.messageId)
    }


    "correctly reflect DvlaDlnNotValid instance" in {
      val message = DvlaDlnNotValid("LEESH702100C99DP", org.joda.time.DateTime.parse("2013-07-13T12:13:14"), org.joda.time.DateTime.parse("2013-07-13T12:13:15"), "pigeon", "curiosity", "123", "77.88.99.101")
      message.toXml mustEqual
          <DvlaDlnNotValid messageId="ad604eef-d5be-4e8d-b725-666b4eb97d0d" serviceType="DvlaPortal" status="NotValid" result="Failure" ipAddress="77.88.99.101" userId="123" enquiryReason="curiosity" contactChannel="pigeon" responseSent="2013-07-13T12:13:15.000+01:00" requestSent="2013-07-13T12:13:14.000+01:00" dln="LEESH702100C99DP"/>.withMessageId(message.messageId)
    }


    "correctly reflect CustomerDlnServerError instance" in {
      val message = CustomerDlnServerError("LEESH702100C99DP", org.joda.time.DateTime.parse("2013-07-13T12:13:14"), org.joda.time.DateTime.parse("2013-07-13T12:13:15"), "77.88.99.101")
      message.toXml mustEqual
          <CustomerDlnServerError messageId="6d8bf103-205c-40ed-a812-d0dec6ff6577" serviceType="CustomerPortal" status="ServerError" result="Failure" ipAddress="77.88.99.101" responseSent="2013-07-13T12:13:15.000+01:00" requestSent="2013-07-13T12:13:14.000+01:00" dln="LEESH702100C99DP"/>.withMessageId(message.messageId)
    }


    "correctly reflect MibRealTimeRecordSuppression instance" in {
      val message = MibRealTimeRecordSuppression(java.util.UUID.fromString("5da8d467-ec76-415e-9edc-8daa2e286208"), "LEESH702100C99DP", "SW11NA", org.joda.time.DateTime.parse("2013-07-13T12:13:14"), org.joda.time.DateTime.parse("2013-07-13T12:13:15"), "rule of thumb", "77.88.99.101")
      message.toXml mustEqual
          <MibRealTimeRecordSuppression messageId="89ba6d55-6b78-47fa-b92b-13b5e7167444" serviceType="MibRealTime" status="Suppressed" result="Failure" ipAddress="77.88.99.101" ruleApplied="rule of thumb" responseSent="2013-07-13T12:13:15.000+01:00" requestSent="2013-07-13T12:13:14.000+01:00" postCode="SW11NA" dln="LEESH702100C99DP" enquiryId="5da8d467-ec76-415e-9edc-8daa2e286208"/>.withMessageId(message.messageId)
    }


    "correctly reflect CustomerPersonalDetailsSuccessful instance" in {
      val message = CustomerPersonalDetailsSuccessful("LEESH702100C99DP", "Alice", "Allison", org.joda.time.DateTime.parse("1984-04-13"), 1, "SW11NA", org.joda.time.DateTime.parse("2013-07-13T12:13:14"), org.joda.time.DateTime.parse("2013-07-13T12:13:15"), "77.88.99.101")
      message.toXml mustEqual
          <CustomerPersonalDetailsSuccessful messageId="b2fd9cb4-a827-4a01-a04a-c589c8ec4318" serviceType="CustomerPortal" status="RecordFound" result="Success" ipAddress="77.88.99.101" responseSent="2013-07-13T12:13:15.000+01:00" requestSent="2013-07-13T12:13:14.000+01:00" postCode="SW11NA" gender="1" dob="1984-04-13T00:00:00.000+01:00" surname="Allison" forename="Alice" dln="LEESH702100C99DP"/>.withMessageId(message.messageId)
    }


    "correctly reflect DvlaPersonalDetailsServerError instance" in {
      val message = DvlaPersonalDetailsServerError("Alice", "Allison", org.joda.time.DateTime.parse("1984-04-13"), 1, "SW11NA", org.joda.time.DateTime.parse("2013-07-13T12:13:14"), org.joda.time.DateTime.parse("2013-07-13T12:13:15"), "pigeon", "curiosity", "123", "77.88.99.101")
      message.toXml mustEqual
          <DvlaPersonalDetailsServerError messageId="d20f5f57-dc70-42bd-a56c-453e8ef773bf" serviceType="DvlaPortal" status="ServerError" result="Failure" ipAddress="77.88.99.101" userId="123" enquiryReason="curiosity" contactChannel="pigeon" responseSent="2013-07-13T12:13:15.000+01:00" requestSent="2013-07-13T12:13:14.000+01:00" postCode="SW11NA" gender="1" dob="1984-04-13T00:00:00.000+01:00" surname="Allison" forename="Alice"/>.withMessageId(message.messageId)
    }


    "correctly reflect DvlaPersonalDetailsNotValid instance" in {
      val message = DvlaPersonalDetailsNotValid("Alice", "Allison", org.joda.time.DateTime.parse("1984-04-13"), 1, "SW11NA", org.joda.time.DateTime.parse("2013-07-13T12:13:14"), org.joda.time.DateTime.parse("2013-07-13T12:13:15"), "pigeon", "curiosity", "123", "77.88.99.101")
      message.toXml mustEqual
          <DvlaPersonalDetailsNotValid messageId="71676ef9-4104-4f89-b59f-30a56acb7a0a" serviceType="DvlaPortal" status="NotFound" result="Failure" ipAddress="77.88.99.101" userId="123" enquiryReason="curiosity" contactChannel="pigeon" responseSent="2013-07-13T12:13:15.000+01:00" requestSent="2013-07-13T12:13:14.000+01:00" postCode="SW11NA" gender="1" dob="1984-04-13T00:00:00.000+01:00" surname="Allison" forename="Alice"/>.withMessageId(message.messageId)
    }


    "correctly reflect MibRealTimeServerError instance" in {
      val message = MibRealTimeServerError(java.util.UUID.fromString("5da8d467-ec76-415e-9edc-8daa2e286208"), "LEESH702100C99DP", "SW11NA", org.joda.time.DateTime.parse("2013-07-13T12:13:14"), org.joda.time.DateTime.parse("2013-07-13T12:13:15"), "77.88.99.101")
      message.toXml mustEqual
          <MibRealTimeServerError messageId="8e2a1e56-fb39-4a00-a85c-185317a7dce5" serviceType="MibRealTime" status="ServerError" result="Failure" ipAddress="77.88.99.101" responseSent="2013-07-13T12:13:15.000+01:00" requestSent="2013-07-13T12:13:14.000+01:00" postCode="SW11NA" dln="LEESH702100C99DP" enquiryId="5da8d467-ec76-415e-9edc-8daa2e286208"/>.withMessageId(message.messageId)
    }


    "correctly reflect CustomerDlnNotFound instance" in {
      val message = CustomerDlnNotFound("LEESH702100C99DP", "SW11NA", org.joda.time.DateTime.parse("2013-07-13T12:13:14"), org.joda.time.DateTime.parse("2013-07-13T12:13:15"), "77.88.99.101")
      message.toXml mustEqual
          <CustomerDlnNotFound messageId="0c70b8b4-440e-49d6-a223-7c70a1690cbc" serviceType="CustomerPortal" status="NotFound" result="Failure" ipAddress="77.88.99.101" responseSent="2013-07-13T12:13:15.000+01:00" requestSent="2013-07-13T12:13:14.000+01:00" postCode="SW11NA" dln="LEESH702100C99DP"/>.withMessageId(message.messageId)
    }


    "correctly reflect DvlaMultipleFound instance" in {
      val message = DvlaMultipleFound("Alice", "Allison", org.joda.time.DateTime.parse("1984-04-13"), 1, "SW11NA", org.joda.time.DateTime.parse("2013-07-13T12:13:14"), org.joda.time.DateTime.parse("2013-07-13T12:13:15"), "pigeon", "curiosity", "123", "77.88.99.101")
      message.toXml mustEqual
          <DvlaMultipleFound messageId="c28ee9b2-7ebc-44ca-b47e-84095910dcc9" serviceType="DvlaPortal" status="MultipleRecordsFound" result="Failure" ipAddress="77.88.99.101" userId="123" enquiryReason="curiosity" contactChannel="pigeon" responseSent="2013-07-13T12:13:15.000+01:00" requestSent="2013-07-13T12:13:14.000+01:00" postCode="SW11NA" gender="1" dob="1984-04-13T00:00:00.000+01:00" surname="Allison" forename="Alice"/>.withMessageId(message.messageId)
    }


    "correctly reflect CustomerPersonalDetailsServerError instance" in {
      val message = CustomerPersonalDetailsServerError("Alice", "Allison", org.joda.time.DateTime.parse("1984-04-13"), 1, "SW11NA", org.joda.time.DateTime.parse("2013-07-13T12:13:14"), org.joda.time.DateTime.parse("2013-07-13T12:13:15"), "77.88.99.101")
      message.toXml mustEqual
          <CustomerPersonalDetailsServerError messageId="9b89b01e-7dfa-43f3-80f7-cf4cc7d45a5c" serviceType="CustomerPortal" status="ServerError" result="Failure" ipAddress="77.88.99.101" responseSent="2013-07-13T12:13:15.000+01:00" requestSent="2013-07-13T12:13:14.000+01:00" postCode="SW11NA" gender="1" dob="1984-04-13T00:00:00.000+01:00" surname="Allison" forename="Alice"/>.withMessageId(message.messageId)
    }


    "correctly reflect CustomerPostcodeNotMatched instance" in {
      val message = CustomerPostcodeNotMatched("LEESH702100C99DP", "SW11NA", org.joda.time.DateTime.parse("2013-07-13T12:13:14"), org.joda.time.DateTime.parse("2013-07-13T12:13:15"), "77.88.99.101")
      message.toXml mustEqual
          <CustomerPostcodeNotMatched messageId="a865867a-ee61-487a-a34b-cb052f4dee15" serviceType="CustomerPortal" status="NotValid" result="Failure" ipAddress="77.88.99.101" responseSent="2013-07-13T12:13:15.000+01:00" requestSent="2013-07-13T12:13:14.000+01:00" postCode="SW11NA" dln="LEESH702100C99DP"/>.withMessageId(message.messageId)
    }


    "correctly reflect CustomerPersonalDetailsNotValid instance" in {
      val message = CustomerPersonalDetailsNotValid("Alice", "Allison", org.joda.time.DateTime.parse("1984-04-13"), 1, "SW11NA", org.joda.time.DateTime.parse("2013-07-13T12:13:14"), org.joda.time.DateTime.parse("2013-07-13T12:13:15"), "77.88.99.101")
      message.toXml mustEqual
          <CustomerPersonalDetailsNotValid messageId="278aa3af-154c-4e01-bc21-fa15b2cad7eb" serviceType="CustomerPortal" status="NotValid" result="Failure" ipAddress="77.88.99.101" responseSent="2013-07-13T12:13:15.000+01:00" requestSent="2013-07-13T12:13:14.000+01:00" postCode="SW11NA" gender="1" dob="1984-04-13T00:00:00.000+01:00" surname="Allison" forename="Alice"/>.withMessageId(message.messageId)
    }


    "correctly reflect MibRealTimeEnquiryMessageReturned instance" in {
      val message = MibRealTimeEnquiryMessageReturned(java.util.UUID.fromString("5da8d467-ec76-415e-9edc-8daa2e286208"), "LEESH702100C99DP", "SW11NA", org.joda.time.DateTime.parse("2013-07-13T12:13:14"), org.joda.time.DateTime.parse("2013-07-13T12:13:15"), "77.88.99.101", "Hello, World!")
      message.toXml mustEqual
          <MibRealTimeEnquiryMessageReturned messageId="fbb28ea7-dd33-4745-add5-2e92cfcd287e" serviceType="MibRealTime" status="MessageReturned" result="Success" message="Hello, World!" ipAddress="77.88.99.101" responseSent="2013-07-13T12:13:15.000+01:00" requestSent="2013-07-13T12:13:14.000+01:00" postCode="SW11NA" dln="LEESH702100C99DP" enquiryId="5da8d467-ec76-415e-9edc-8daa2e286208"/>.withMessageId(message.messageId)
    }


    "correctly reflect DvlaPersonalDetailsSuppressed instance" in {
      val message = DvlaPersonalDetailsSuppressed("LEESH702100C99DP", "Alice", "Allison", org.joda.time.DateTime.parse("1984-04-13"), 1, "SW11NA", org.joda.time.DateTime.parse("2013-07-13T12:13:14"), org.joda.time.DateTime.parse("2013-07-13T12:13:15"), "headache", "pigeon", "curiosity", "77.88.99.101")
      message.toXml mustEqual
          <DvlaPersonalDetailsSuppressed messageId="e010d990-46ec-4794-801f-2b7bbe8f2ad2" serviceType="DvlaPortal" status="Suppressed" result="Failure" ipAddress="77.88.99.101" enquiryReason="curiosity" contactChannel="pigeon" suppressionReason="headache" responseSent="2013-07-13T12:13:15.000+01:00" requestSent="2013-07-13T12:13:14.000+01:00" postCode="SW11NA" gender="1" dob="1984-04-13T00:00:00.000+01:00" surname="Allison" forename="Alice" dln="LEESH702100C99DP"/>.withMessageId(message.messageId)
    }


    "correctly reflect DvlaUnauthorisedAccess instance" in {
      val message = DvlaUnauthorisedAccess("123", org.joda.time.DateTime.parse("2013-07-13T12:13:14"), org.joda.time.DateTime.parse("2013-07-13T12:13:15"), "77.88.99.101")
      message.toXml mustEqual
          <DvlaUnauthorisedAccess messageId="47962ebb-d443-4d99-9515-ef5df6ed7db5" serviceType="DvlaPortal" status="UnauthorisedAccess" result="Failure" ipAddress="77.88.99.101" responseSent="2013-07-13T12:13:15.000+01:00" requestSent="2013-07-13T12:13:14.000+01:00" userId="123"/>.withMessageId(message.messageId)
    }


    "correctly reflect CustomerPostcodeIsBlank instance" in {
      val message = CustomerPostcodeIsBlank("LEESH702100C99DP", "SW11NA", org.joda.time.DateTime.parse("2013-07-13T12:13:14"), org.joda.time.DateTime.parse("2013-07-13T12:13:15"), "77.88.99.101")
      message.toXml mustEqual
          <CustomerPostcodeIsBlank messageId="410eea9f-5757-4d56-959e-a3238cb62882" serviceType="CustomerPortal" status="PostcodeIsBlank" result="Success" ipAddress="77.88.99.101" responseSent="2013-07-13T12:13:15.000+01:00" requestSent="2013-07-13T12:13:14.000+01:00" postCode="SW11NA" dln="LEESH702100C99DP"/>.withMessageId(message.messageId)
    }


    "correctly reflect MibRealTimeDlnNotFound instance" in {
      val message = MibRealTimeDlnNotFound(java.util.UUID.fromString("5da8d467-ec76-415e-9edc-8daa2e286208"), "LEESH702100C99DP", "SW11NA", org.joda.time.DateTime.parse("2013-07-13T12:13:14"), org.joda.time.DateTime.parse("2013-07-13T12:13:15"), "77.88.99.101")
      message.toXml mustEqual
          <MibRealTimeDlnNotFound messageId="dd44f2db-abb7-4b83-a59f-3b5509897562" serviceType="MibRealTime" status="NotFound" result="Failure" ipAddress="77.88.99.101" responseSent="2013-07-13T12:13:15.000+01:00" requestSent="2013-07-13T12:13:14.000+01:00" postCode="SW11NA" dln="LEESH702100C99DP" enquiryId="5da8d467-ec76-415e-9edc-8daa2e286208"/>.withMessageId(message.messageId)
    }


    "correctly reflect MibRealTimeDlnNotValid instance" in {
      val message = MibRealTimeDlnNotValid(java.util.UUID.fromString("5da8d467-ec76-415e-9edc-8daa2e286208"), "LEESH702100C99DP", "SW11NA", org.joda.time.DateTime.parse("2013-07-13T12:13:14"), org.joda.time.DateTime.parse("2013-07-13T12:13:15"), "77.88.99.101")
      message.toXml mustEqual
          <MibRealTimeDlnNotValid messageId="40a8df2d-fcfd-4f78-a519-ce811b55afac" serviceType="MibRealTime" status="NotValid" result="Failure" ipAddress="77.88.99.101" responseSent="2013-07-13T12:13:15.000+01:00" requestSent="2013-07-13T12:13:14.000+01:00" postCode="SW11NA" dln="LEESH702100C99DP" enquiryId="5da8d467-ec76-415e-9edc-8daa2e286208"/>.withMessageId(message.messageId)
    }


    "correctly reflect MibRealTimeEnquirySuccessful instance" in {
      val message = MibRealTimeEnquirySuccessful(java.util.UUID.fromString("5da8d467-ec76-415e-9edc-8daa2e286208"), "LEESH702100C99DP", "SW11NA", org.joda.time.DateTime.parse("2013-07-13T12:13:14"), org.joda.time.DateTime.parse("2013-07-13T12:13:15"), "77.88.99.101")
      message.toXml mustEqual
          <MibRealTimeEnquirySuccessful messageId="31500241-5d56-4c10-b36e-adf559aa7e22" serviceType="MibRealTime" status="RecordFound" result="Success" ipAddress="77.88.99.101" responseSent="2013-07-13T12:13:15.000+01:00" requestSent="2013-07-13T12:13:14.000+01:00" postCode="SW11NA" dln="LEESH702100C99DP" enquiryId="5da8d467-ec76-415e-9edc-8daa2e286208"/>.withMessageId(message.messageId)
    }


    "correctly reflect DvlaPersonalDetailsSuccessful instance" in {
      val message = DvlaPersonalDetailsSuccessful("LEESH702100C99DP", "Alice", "Allison", org.joda.time.DateTime.parse("1984-04-13"), 1, "SW11NA", org.joda.time.DateTime.parse("2013-07-13T12:13:14"), org.joda.time.DateTime.parse("2013-07-13T12:13:15"), "pigeon", "curiosity", "123", "77.88.99.101")
      message.toXml mustEqual
          <DvlaPersonalDetailsSuccessful messageId="f60e29e2-d15f-4cc4-a19d-212bc58cc8a4" serviceType="DvlaPortal" status="RecordFound" result="Success" ipAddress="77.88.99.101" userId="123" enquiryReason="curiosity" contactChannel="pigeon" responseSent="2013-07-13T12:13:15.000+01:00" requestSent="2013-07-13T12:13:14.000+01:00" postCode="SW11NA" gender="1" dob="1984-04-13T00:00:00.000+01:00" surname="Allison" forename="Alice" dln="LEESH702100C99DP"/>.withMessageId(message.messageId)
    }


    "correctly reflect CustomerDlnSuccessful instance" in {
      val message = CustomerDlnSuccessful("LEESH702100C99DP", "SW11NA", org.joda.time.DateTime.parse("2013-07-13T12:13:14"), org.joda.time.DateTime.parse("2013-07-13T12:13:15"), "77.88.99.101")
      message.toXml mustEqual
          <CustomerDlnSuccessful messageId="4c749e51-f438-4ce7-b5d5-bbc8a4511fef" serviceType="CustomerPortal" status="RecordFound" result="Success" ipAddress="77.88.99.101" responseSent="2013-07-13T12:13:15.000+01:00" requestSent="2013-07-13T12:13:14.000+01:00" postCode="SW11NA" dln="LEESH702100C99DP"/>.withMessageId(message.messageId)
    }


    "correctly reflect MibRealTimeNoEntitlements instance" in {
      val message = MibRealTimeNoEntitlements(java.util.UUID.fromString("5da8d467-ec76-415e-9edc-8daa2e286208"), "LEESH702100C99DP", "SW11NA", org.joda.time.DateTime.parse("2013-07-13T12:13:14"), org.joda.time.DateTime.parse("2013-07-13T12:13:15"), "77.88.99.101")
      message.toXml mustEqual
          <MibRealTimeNoEntitlements messageId="be6ec1cc-1d2f-4701-ae44-2736984faa27" serviceType="MibRealTime" status="NotAvailable" result="Failure" ipAddress="77.88.99.101" responseSent="2013-07-13T12:13:15.000+01:00" requestSent="2013-07-13T12:13:14.000+01:00" postCode="SW11NA" dln="LEESH702100C99DP" enquiryId="5da8d467-ec76-415e-9edc-8daa2e286208"/>.withMessageId(message.messageId)
    }


    "correctly reflect CustomerPersonalDetailsNotFound instance" in {
      val message = CustomerPersonalDetailsNotFound("Alice", "Allison", org.joda.time.DateTime.parse("1984-04-13"), 1, "SW11NA", org.joda.time.DateTime.parse("2013-07-13T12:13:14"), org.joda.time.DateTime.parse("2013-07-13T12:13:15"), "77.88.99.101")
      message.toXml mustEqual
          <CustomerPersonalDetailsNotFound messageId="2754f26a-da14-4ccf-bb39-608e7cc119fd" serviceType="CustomerPortal" status="NotFound" result="Failure" ipAddress="77.88.99.101" responseSent="2013-07-13T12:13:15.000+01:00" requestSent="2013-07-13T12:13:14.000+01:00" postCode="SW11NA" gender="1" dob="1984-04-13T00:00:00.000+01:00" surname="Allison" forename="Alice"/>.withMessageId(message.messageId)
    }


    "correctly reflect CustomerMultipleFound instance" in {
      val message = CustomerMultipleFound("Alice", "Allison", org.joda.time.DateTime.parse("1984-04-13"), 1, "SW11NA", org.joda.time.DateTime.parse("2013-07-13T12:13:14"), org.joda.time.DateTime.parse("2013-07-13T12:13:15"), "77.88.99.101")
      message.toXml mustEqual
          <CustomerMultipleFound messageId="403ff8e0-6989-4efc-ad35-e8acf3700e0c" serviceType="CustomerPortal" status="MultipleRecordsFound" result="Failure" ipAddress="77.88.99.101" responseSent="2013-07-13T12:13:15.000+01:00" requestSent="2013-07-13T12:13:14.000+01:00" postCode="SW11NA" gender="1" dob="1984-04-13T00:00:00.000+01:00" surname="Allison" forename="Alice"/>.withMessageId(message.messageId)
    }

  }
}

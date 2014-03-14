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

    "correctly reflect CustomerMultipleFound instance" in {
      val message = CustomerMultipleFound("Alice", "Allison", org.joda.time.DateTime.parse("1984-04-13"), 1, "SW11NA", org.joda.time.DateTime.parse("2013-07-13T12:13:14"), org.joda.time.DateTime.parse("2013-07-13T12:13:15"), "77.88.99.101")
      message.toXml mustEqual
          <CustomerMultipleFound messageId="8c033343-7504-4239-897c-a44b24767e01" serviceType="CustomerPortal" status="MultipleRecordsFound" result="Failure" ipAddress="77.88.99.101" responseSent="2013-07-13T12:13:15.000+01:00" requestSent="2013-07-13T12:13:14.000+01:00" postCode="SW11NA" gender="1" dob="1984-04-13T00:00:00.000+01:00" surname="Allison" forename="Alice"/>.withMessageId(message.messageId)
    }


    "correctly reflect CustomerDlnSuccessful instance" in {
      val message = CustomerDlnSuccessful("LEESH702100C99DP", "SW11NA", org.joda.time.DateTime.parse("2013-07-13T12:13:14"), org.joda.time.DateTime.parse("2013-07-13T12:13:15"), "77.88.99.101")
      message.toXml mustEqual
          <CustomerDlnSuccessful messageId="4e7918ff-3767-4484-8724-b333e576d67a" serviceType="CustomerPortal" status="RecordFound" result="Success" ipAddress="77.88.99.101" responseSent="2013-07-13T12:13:15.000+01:00" requestSent="2013-07-13T12:13:14.000+01:00" postCode="SW11NA" dln="LEESH702100C99DP"/>.withMessageId(message.messageId)
    }


    "correctly reflect DvlaPersonalDetailsNotFound instance" in {
      val message = DvlaPersonalDetailsNotFound("Alice", "Allison", org.joda.time.DateTime.parse("1984-04-13"), 1, "SW11NA", org.joda.time.DateTime.parse("2013-07-13T12:13:14"), org.joda.time.DateTime.parse("2013-07-13T12:13:15"), "pigeon", "curiosity" :: Nil, "123", "77.88.99.101")
      message.toXml mustEqual
          <DvlaPersonalDetailsNotFound messageId="bf84b65e-5a9c-4f91-925a-287a338a7d46" serviceType="DvlaPortal" status="NotFound" result="Failure" ipAddress="77.88.99.101" userId="123" enquiryReasons="List(curiosity)" contactChannel="pigeon" responseSent="2013-07-13T12:13:15.000+01:00" requestSent="2013-07-13T12:13:14.000+01:00" postCode="SW11NA" gender="1" dob="1984-04-13T00:00:00.000+01:00" surname="Allison" forename="Alice"/>.withMessageId(message.messageId)
    }


    "correctly reflect MibBatchResponseCreated instance" in {
      val message = MibBatchResponseCreated("big-bad-batch", uk.gov.dvla.messages.Result.Success, org.joda.time.DateTime.parse("2013-07-13T12:13:14"))
      message.toXml mustEqual
          <MibBatchResponseCreated messageId="2b4f4195-c696-4983-a84e-f0072e2251e4" serviceType="MibBatch" status="BatchRespondedTo" created="2013-07-13T12:13:14.000+01:00" result="Success" batchId="big-bad-batch"/>.withMessageId(message.messageId)
    }


    "correctly reflect DvlaUnauthorisedAccess instance" in {
      val message = DvlaUnauthorisedAccess("123", org.joda.time.DateTime.parse("2013-07-13T12:13:14"), org.joda.time.DateTime.parse("2013-07-13T12:13:15"), "77.88.99.101")
      message.toXml mustEqual
          <DvlaUnauthorisedAccess messageId="dd52f879-34d4-494b-90a3-d19116b9b1c0" serviceType="DvlaPortal" status="UnauthorisedAccess" result="Failure" ipAddress="77.88.99.101" responseSent="2013-07-13T12:13:15.000+01:00" requestSent="2013-07-13T12:13:14.000+01:00" userId="123"/>.withMessageId(message.messageId)
    }


    "correctly reflect MibRealTimeDlnNotValid instance" in {
      val message = MibRealTimeDlnNotValid(java.util.UUID.fromString("cf09ed40-1353-4622-a59e-e640a38e2202"), "LEESH702100C99DP", "SW11NA", org.joda.time.DateTime.parse("2013-07-13T12:13:14"), org.joda.time.DateTime.parse("2013-07-13T12:13:15"), "77.88.99.101", "big-bad-batch", true)
      message.toXml mustEqual
          <MibRealTimeDlnNotValid messageId="55bff250-0bb8-480d-842b-81179881cca8" serviceType="MibRealTime" status="NotValid" result="Failure" vrmProvided="true" batchId="big-bad-batch" ipAddress="77.88.99.101" responseSent="2013-07-13T12:13:15.000+01:00" requestSent="2013-07-13T12:13:14.000+01:00" postCode="SW11NA" dln="LEESH702100C99DP" enquiryId="cf09ed40-1353-4622-a59e-e640a38e2202"/>.withMessageId(message.messageId)
    }


    "correctly reflect IDAMatchRequest instance" in {
      val message = IDAMatchRequest("1", org.joda.time.DateTime.parse("2013-07-13T12:13:14"), "marriage", "both over 40", "1234")
      message.toXml mustEqual
          <IDAMatchRequest messageId="ed0a1b02-5637-436d-9ebe-a7465586af88" serviceType="IDAMatcherService" status="IDAMatchRequestReceived" result="Success" authenticationType="IDA" pid="1234" matchingBasis="both over 40" matchingOutcome="marriage" requestReceived="2013-07-13T12:13:14.000+01:00" matchId="1"/>.withMessageId(message.messageId)
    }


    "correctly reflect DvlaDlnServerError instance" in {
      val message = DvlaDlnServerError("LEESH702100C99DP", org.joda.time.DateTime.parse("2013-07-13T12:13:14"), org.joda.time.DateTime.parse("2013-07-13T12:13:15"), "pigeon", "curiosity" :: Nil, "123", "77.88.99.101")
      message.toXml mustEqual
          <DvlaDlnServerError messageId="5dca133a-2033-4667-b8fd-79d1070b4c9e" serviceType="DvlaPortal" status="ServerError" result="Failure" ipAddress="77.88.99.101" userId="123" enquiryReasons="List(curiosity)" contactChannel="pigeon" responseSent="2013-07-13T12:13:15.000+01:00" requestSent="2013-07-13T12:13:14.000+01:00" dln="LEESH702100C99DP"/>.withMessageId(message.messageId)
    }


    "correctly reflect CustomerDlnServerError instance" in {
      val message = CustomerDlnServerError("LEESH702100C99DP", org.joda.time.DateTime.parse("2013-07-13T12:13:14"), org.joda.time.DateTime.parse("2013-07-13T12:13:15"), "77.88.99.101")
      message.toXml mustEqual
          <CustomerDlnServerError messageId="fc60c60e-107c-41d5-bc1c-adc42f5a7336" serviceType="CustomerPortal" status="ServerError" result="Failure" ipAddress="77.88.99.101" responseSent="2013-07-13T12:13:15.000+01:00" requestSent="2013-07-13T12:13:14.000+01:00" dln="LEESH702100C99DP"/>.withMessageId(message.messageId)
    }


    "correctly reflect NINOAuthenticateFailure instance" in {
      val message = NINOAuthenticateFailure("LEESH702100C99DP", "what?", "pardon?", "died by snu snu", org.joda.time.DateTime.parse("2013-07-13T12:13:14"), org.joda.time.DateTime.parse("2013-07-13T12:13:15"), "77.88.99.101")
      message.toXml mustEqual
          <NINOAuthenticateFailure messageId="6531bb9c-8da2-445a-af9a-6bc78f5a4986" serviceType="CustomerPortal" status="NegativeCoreMatch" result="Failure" authenticationType="DWP" ipAddress="77.88.99.101" responseSent="2013-07-13T12:13:15.000+01:00" requestSent="2013-07-13T12:13:14.000+01:00" deceased="died by snu snu" coreAndAddressMatch="pardon?" coreMatch="what?" dln="LEESH702100C99DP"/>.withMessageId(message.messageId)
    }


    "correctly reflect MibRealTimeServerError instance" in {
      val message = MibRealTimeServerError(java.util.UUID.fromString("cf09ed40-1353-4622-a59e-e640a38e2202"), "LEESH702100C99DP", "SW11NA", org.joda.time.DateTime.parse("2013-07-13T12:13:14"), org.joda.time.DateTime.parse("2013-07-13T12:13:15"), "77.88.99.101", "big-bad-batch", true)
      message.toXml mustEqual
          <MibRealTimeServerError messageId="4c5dc366-2e24-466d-b9cd-e199c025f46e" serviceType="MibRealTime" status="ServerError" result="Failure" vrmProvided="true" batchId="big-bad-batch" ipAddress="77.88.99.101" responseSent="2013-07-13T12:13:15.000+01:00" requestSent="2013-07-13T12:13:14.000+01:00" postCode="SW11NA" dln="LEESH702100C99DP" enquiryId="cf09ed40-1353-4622-a59e-e640a38e2202"/>.withMessageId(message.messageId)
    }


    "correctly reflect MibRealTimeDlnNotFound instance" in {
      val message = MibRealTimeDlnNotFound(java.util.UUID.fromString("cf09ed40-1353-4622-a59e-e640a38e2202"), "LEESH702100C99DP", "SW11NA", org.joda.time.DateTime.parse("2013-07-13T12:13:14"), org.joda.time.DateTime.parse("2013-07-13T12:13:15"), "77.88.99.101", "big-bad-batch", true)
      message.toXml mustEqual
          <MibRealTimeDlnNotFound messageId="3020c4db-b5b3-43a4-9ab7-2a559617715a" serviceType="MibRealTime" status="NotFound" result="Failure" vrmProvided="true" batchId="big-bad-batch" ipAddress="77.88.99.101" responseSent="2013-07-13T12:13:15.000+01:00" requestSent="2013-07-13T12:13:14.000+01:00" postCode="SW11NA" dln="LEESH702100C99DP" enquiryId="cf09ed40-1353-4622-a59e-e640a38e2202"/>.withMessageId(message.messageId)
    }


    "correctly reflect CustomerDlnNotFound instance" in {
      val message = CustomerDlnNotFound("LEESH702100C99DP", "SW11NA", org.joda.time.DateTime.parse("2013-07-13T12:13:14"), org.joda.time.DateTime.parse("2013-07-13T12:13:15"), "77.88.99.101")
      message.toXml mustEqual
          <CustomerDlnNotFound messageId="94c2e9f0-c227-427e-9086-a851b93c2838" serviceType="CustomerPortal" status="NotFound" result="Failure" ipAddress="77.88.99.101" responseSent="2013-07-13T12:13:15.000+01:00" requestSent="2013-07-13T12:13:14.000+01:00" postCode="SW11NA" dln="LEESH702100C99DP"/>.withMessageId(message.messageId)
    }


    "correctly reflect DvlaPersonalDetailsNotValid instance" in {
      val message = DvlaPersonalDetailsNotValid("Alice", "Allison", org.joda.time.DateTime.parse("1984-04-13"), 1, "SW11NA", org.joda.time.DateTime.parse("2013-07-13T12:13:14"), org.joda.time.DateTime.parse("2013-07-13T12:13:15"), "pigeon", "curiosity" :: Nil, "123", "77.88.99.101")
      message.toXml mustEqual
          <DvlaPersonalDetailsNotValid messageId="35dc77bc-720e-4515-a815-fe551cc0fc2f" serviceType="DvlaPortal" status="NotFound" result="Failure" ipAddress="77.88.99.101" userId="123" enquiryReasons="List(curiosity)" contactChannel="pigeon" responseSent="2013-07-13T12:13:15.000+01:00" requestSent="2013-07-13T12:13:14.000+01:00" postCode="SW11NA" gender="1" dob="1984-04-13T00:00:00.000+01:00" surname="Allison" forename="Alice"/>.withMessageId(message.messageId)
    }


    "correctly reflect NINOAuthenticateServiceMaintenance instance" in {
      val message = NINOAuthenticateServiceMaintenance("LEESH702100C99DP", org.joda.time.DateTime.parse("2013-07-13T12:13:14"), org.joda.time.DateTime.parse("2013-07-13T12:13:15"), "77.88.99.101")
      message.toXml mustEqual
          <NINOAuthenticateServiceMaintenance messageId="73432ff9-bf8d-4a74-9c32-dc1437589e22" serviceType="CustomerPortal" status="Maintenance" result="Failure" authenticationType="DWP" ipAddress="77.88.99.101" responseSent="2013-07-13T12:13:15.000+01:00" requestSent="2013-07-13T12:13:14.000+01:00" dln="LEESH702100C99DP"/>.withMessageId(message.messageId)
    }


    "correctly reflect CustomerPostcodeNotMatched instance" in {
      val message = CustomerPostcodeNotMatched("LEESH702100C99DP", "SW11NA", org.joda.time.DateTime.parse("2013-07-13T12:13:14"), org.joda.time.DateTime.parse("2013-07-13T12:13:15"), "77.88.99.101")
      message.toXml mustEqual
          <CustomerPostcodeNotMatched messageId="58a3200f-ffb9-41ec-bad5-8bf0f057baae" serviceType="CustomerPortal" status="NotValid" result="Failure" ipAddress="77.88.99.101" responseSent="2013-07-13T12:13:15.000+01:00" requestSent="2013-07-13T12:13:14.000+01:00" postCode="SW11NA" dln="LEESH702100C99DP"/>.withMessageId(message.messageId)
    }


    "correctly reflect MibBatchReceived instance" in {
      val message = MibBatchReceived("big-bad-batch", org.joda.time.DateTime.parse("2013-07-13T12:13:14"), 100, Nil)
      message.toXml mustEqual
          <MibBatchReceived messageId="effd1a38-dc53-40f2-ad11-acf61ad8a4f8" serviceType="MibBatch" status="BatchReceived" result="Success" errorCodes="List()" noRequests="100" received="2013-07-13T12:13:14.000+01:00" batchId="big-bad-batch"/>.withMessageId(message.messageId)
    }


    "correctly reflect IDASamlResponse instance" in {
      val message = IDASamlResponseSuccess("123456-abc", "1234", org.joda.time.DateTime.parse("2013-07-13T12:13:14"))
      message.toXml mustEqual
          <IDASamlResponseSuccess messageId="321741ef-0980-4d33-88e7-88122cb39a98" serviceType="CustomerPortal" status="IDASamlResponseReceived" result="Success" authenticationType="IDA" requestSent="2013-07-13T12:13:14.000+01:00" pid="1234" requestId="123456-abc"/>.withMessageId(message.messageId)
    }


    "correctly reflect CustomerPersonalDetailsSuppressed instance" in {
      val message = CustomerPersonalDetailsSuppressed("Alice", "Allison", org.joda.time.DateTime.parse("1984-04-13"), 1, "SW11NA", org.joda.time.DateTime.parse("2013-07-13T12:13:14"), org.joda.time.DateTime.parse("2013-07-13T12:13:15"), "77.88.99.101", "headache")
      message.toXml mustEqual
          <CustomerPersonalDetailsSuppressed messageId="3ffe014a-b21c-46ac-9326-efeb38aad4f1" serviceType="CustomerPortal" status="Suppressed" result="Failure" suppressionReason="headache" ipAddress="77.88.99.101" responseSent="2013-07-13T12:13:15.000+01:00" requestSent="2013-07-13T12:13:14.000+01:00" postCode="SW11NA" gender="1" dob="1984-04-13T00:00:00.000+01:00" surname="Allison" forename="Alice"/>.withMessageId(message.messageId)
    }


    "correctly reflect CustomerPostcodeIsBlank instance" in {
      val message = CustomerPostcodeIsBlank("LEESH702100C99DP", "SW11NA", org.joda.time.DateTime.parse("2013-07-13T12:13:14"), org.joda.time.DateTime.parse("2013-07-13T12:13:15"), "77.88.99.101")
      message.toXml mustEqual
          <CustomerPostcodeIsBlank messageId="881a2c0a-cde7-4f1b-a471-47a59cd34931" serviceType="CustomerPortal" status="PostcodeIsBlank" result="Success" ipAddress="77.88.99.101" responseSent="2013-07-13T12:13:15.000+01:00" requestSent="2013-07-13T12:13:14.000+01:00" postCode="SW11NA" dln="LEESH702100C99DP"/>.withMessageId(message.messageId)
    }


    "correctly reflect DvlaDlnSuppressed instance" in {
      val message = DvlaDlnSuppressed("LEESH702100C99DP", org.joda.time.DateTime.parse("2013-07-13T12:13:14"), org.joda.time.DateTime.parse("2013-07-13T12:13:15"), "headache", "pigeon", "curiosity" :: Nil, "77.88.99.101")
      message.toXml mustEqual
          <DvlaDlnSuppressed messageId="ecf6e287-5dca-491a-ba2a-096a0b25c69b" serviceType="DvlaPortal" status="Suppressed" result="Failure" ipAddress="77.88.99.101" enquiryReasons="List(curiosity)" contactChannel="pigeon" suppressionReason="headache" responseSent="2013-07-13T12:13:15.000+01:00" requestSent="2013-07-13T12:13:14.000+01:00" dln="LEESH702100C99DP"/>.withMessageId(message.messageId)
    }


    "correctly reflect CustomerPersonalDetailsSuccessful instance" in {
      val message = CustomerPersonalDetailsSuccessful("LEESH702100C99DP", "Alice", "Allison", org.joda.time.DateTime.parse("1984-04-13"), 1, "SW11NA", org.joda.time.DateTime.parse("2013-07-13T12:13:14"), org.joda.time.DateTime.parse("2013-07-13T12:13:15"), "77.88.99.101")
      message.toXml mustEqual
          <CustomerPersonalDetailsSuccessful messageId="59effb79-c4d7-4076-98a5-01fb10beab30" serviceType="CustomerPortal" status="RecordFound" result="Success" ipAddress="77.88.99.101" responseSent="2013-07-13T12:13:15.000+01:00" requestSent="2013-07-13T12:13:14.000+01:00" postCode="SW11NA" gender="1" dob="1984-04-13T00:00:00.000+01:00" surname="Allison" forename="Alice" dln="LEESH702100C99DP"/>.withMessageId(message.messageId)
    }


    "correctly reflect CustomerDlnNotValid instance" in {
      val message = CustomerDlnNotValid("LEESH702100C99DP", org.joda.time.DateTime.parse("2013-07-13T12:13:14"), org.joda.time.DateTime.parse("2013-07-13T12:13:15"), "77.88.99.101")
      message.toXml mustEqual
          <CustomerDlnNotValid messageId="5769dad2-6480-44f5-917f-1fdf1a3b8cd6" serviceType="CustomerPortal" status="NotValid" result="Failure" ipAddress="77.88.99.101" responseSent="2013-07-13T12:13:15.000+01:00" requestSent="2013-07-13T12:13:14.000+01:00" dln="LEESH702100C99DP"/>.withMessageId(message.messageId)
    }


    "correctly reflect IDASamlRequest instance" in {
      val message = IDASamlRequest("123456-abc", org.joda.time.DateTime.parse("2013-07-13T12:13:14"))
      message.toXml mustEqual
          <IDASamlRequest messageId="0fe47bf0-38b4-47b4-adda-cb7c95a2b6b9" serviceType="CustomerPortal" status="IDASamlRequestSent" result="Success" authenticationType="IDA" requestSent="2013-07-13T12:13:14.000+01:00" requestId="123456-abc"/>.withMessageId(message.messageId)
    }


    "correctly reflect DvlaMultipleFound instance" in {
      val message = DvlaMultipleFound("Alice", "Allison", org.joda.time.DateTime.parse("1984-04-13"), 1, "SW11NA", org.joda.time.DateTime.parse("2013-07-13T12:13:14"), org.joda.time.DateTime.parse("2013-07-13T12:13:15"), "pigeon", "curiosity" :: Nil, "123", "77.88.99.101")
      message.toXml mustEqual
          <DvlaMultipleFound messageId="a6d565e5-a7b7-4b34-9832-221d89d6b592" serviceType="DvlaPortal" status="MultipleRecordsFound" result="Failure" ipAddress="77.88.99.101" userId="123" enquiryReasons="List(curiosity)" contactChannel="pigeon" responseSent="2013-07-13T12:13:15.000+01:00" requestSent="2013-07-13T12:13:14.000+01:00" postCode="SW11NA" gender="1" dob="1984-04-13T00:00:00.000+01:00" surname="Allison" forename="Alice"/>.withMessageId(message.messageId)
    }


    "correctly reflect CustomerPersonalDetailsNotValid instance" in {
      val message = CustomerPersonalDetailsNotValid("Alice", "Allison", org.joda.time.DateTime.parse("1984-04-13"), 1, "SW11NA", org.joda.time.DateTime.parse("2013-07-13T12:13:14"), org.joda.time.DateTime.parse("2013-07-13T12:13:15"), "77.88.99.101")
      message.toXml mustEqual
          <CustomerPersonalDetailsNotValid messageId="0f47fc0a-bf77-4562-a116-4ec76d18a970" serviceType="CustomerPortal" status="NotValid" result="Failure" ipAddress="77.88.99.101" responseSent="2013-07-13T12:13:15.000+01:00" requestSent="2013-07-13T12:13:14.000+01:00" postCode="SW11NA" gender="1" dob="1984-04-13T00:00:00.000+01:00" surname="Allison" forename="Alice"/>.withMessageId(message.messageId)
    }


    "correctly reflect DvlaDlnNotValid instance" in {
      val message = DvlaDlnNotValid("LEESH702100C99DP", org.joda.time.DateTime.parse("2013-07-13T12:13:14"), org.joda.time.DateTime.parse("2013-07-13T12:13:15"), "pigeon", "curiosity" :: Nil, "123", "77.88.99.101")
      message.toXml mustEqual
          <DvlaDlnNotValid messageId="60b222d8-3c64-4173-b0ac-9ebd20fdfa17" serviceType="DvlaPortal" status="NotValid" result="Failure" ipAddress="77.88.99.101" userId="123" enquiryReasons="List(curiosity)" contactChannel="pigeon" responseSent="2013-07-13T12:13:15.000+01:00" requestSent="2013-07-13T12:13:14.000+01:00" dln="LEESH702100C99DP"/>.withMessageId(message.messageId)
    }


    "correctly reflect CustomerPersonalDetailsNotFound instance" in {
      val message = CustomerPersonalDetailsNotFound("Alice", "Allison", org.joda.time.DateTime.parse("1984-04-13"), 1, "SW11NA", org.joda.time.DateTime.parse("2013-07-13T12:13:14"), org.joda.time.DateTime.parse("2013-07-13T12:13:15"), "77.88.99.101")
      message.toXml mustEqual
          <CustomerPersonalDetailsNotFound messageId="336235d0-5ada-4d0d-9493-e72173367fe6" serviceType="CustomerPortal" status="NotFound" result="Failure" ipAddress="77.88.99.101" responseSent="2013-07-13T12:13:15.000+01:00" requestSent="2013-07-13T12:13:14.000+01:00" postCode="SW11NA" gender="1" dob="1984-04-13T00:00:00.000+01:00" surname="Allison" forename="Alice"/>.withMessageId(message.messageId)
    }


    "correctly reflect MibRealTimeNoEntitlements instance" in {
      val message = MibRealTimeNoEntitlements(java.util.UUID.fromString("cf09ed40-1353-4622-a59e-e640a38e2202"), "LEESH702100C99DP", "SW11NA", org.joda.time.DateTime.parse("2013-07-13T12:13:14"), org.joda.time.DateTime.parse("2013-07-13T12:13:15"), "77.88.99.101", "big-bad-batch", true)
      message.toXml mustEqual
          <MibRealTimeNoEntitlements messageId="1a756ec2-9edf-4a5e-8610-9c91d96dbef3" serviceType="MibRealTime" status="NotAvailable" result="Failure" vrmProvided="true" batchId="big-bad-batch" ipAddress="77.88.99.101" responseSent="2013-07-13T12:13:15.000+01:00" requestSent="2013-07-13T12:13:14.000+01:00" postCode="SW11NA" dln="LEESH702100C99DP" enquiryId="cf09ed40-1353-4622-a59e-e640a38e2202"/>.withMessageId(message.messageId)
    }


    "correctly reflect MibRealTimeRecordSuppression instance" in {
      val message = MibRealTimeRecordSuppression(java.util.UUID.fromString("cf09ed40-1353-4622-a59e-e640a38e2202"), "LEESH702100C99DP", "SW11NA", org.joda.time.DateTime.parse("2013-07-13T12:13:14"), org.joda.time.DateTime.parse("2013-07-13T12:13:15"), "rule of thumb", "77.88.99.101", "big-bad-batch", true)
      message.toXml mustEqual
          <MibRealTimeRecordSuppression messageId="c14b5022-b871-4d30-b386-8b643f298b13" serviceType="MibRealTime" status="Suppressed" result="Failure" vrmProvided="true" batchId="big-bad-batch" ipAddress="77.88.99.101" ruleApplied="rule of thumb" responseSent="2013-07-13T12:13:15.000+01:00" requestSent="2013-07-13T12:13:14.000+01:00" postCode="SW11NA" dln="LEESH702100C99DP" enquiryId="cf09ed40-1353-4622-a59e-e640a38e2202"/>.withMessageId(message.messageId)
    }


    "correctly reflect CustomerDlnSuppressed instance" in {
      val message = CustomerDlnSuppressed("LEESH702100C99DP", org.joda.time.DateTime.parse("2013-07-13T12:13:14"), org.joda.time.DateTime.parse("2013-07-13T12:13:15"), "77.88.99.101", "headache")
      message.toXml mustEqual
          <CustomerDlnSuppressed messageId="2439aa3a-ced2-4550-ad97-81f0a05deaec" serviceType="CustomerPortal" status="Suppressed" result="Failure" suppressionReason="headache" ipAddress="77.88.99.101" responseSent="2013-07-13T12:13:15.000+01:00" requestSent="2013-07-13T12:13:14.000+01:00" dln="LEESH702100C99DP"/>.withMessageId(message.messageId)
    }


    "correctly reflect MibRealTimeEnquirySuccessful instance" in {
      val message = MibRealTimeEnquirySuccessful(java.util.UUID.fromString("cf09ed40-1353-4622-a59e-e640a38e2202"), "LEESH702100C99DP", "SW11NA", org.joda.time.DateTime.parse("2013-07-13T12:13:14"), org.joda.time.DateTime.parse("2013-07-13T12:13:15"), "77.88.99.101", "big-bad-batch", true)
      message.toXml mustEqual
          <MibRealTimeEnquirySuccessful messageId="b7c6acc4-5e31-408f-b569-3258820ca7a1" serviceType="MibRealTime" status="RecordFound" result="Success" vrmProvided="true" batchId="big-bad-batch" ipAddress="77.88.99.101" responseSent="2013-07-13T12:13:15.000+01:00" requestSent="2013-07-13T12:13:14.000+01:00" postCode="SW11NA" dln="LEESH702100C99DP" enquiryId="cf09ed40-1353-4622-a59e-e640a38e2202"/>.withMessageId(message.messageId)
    }


    "correctly reflect CustomerPostcodeContainsSpecialCharacter instance" in {
      val message = CustomerPostcodeContainsSpecialCharacter("LEESH702100C99DP", "SW11NA", org.joda.time.DateTime.parse("2013-07-13T12:13:14"), org.joda.time.DateTime.parse("2013-07-13T12:13:15"), "77.88.99.101")
      message.toXml mustEqual
          <CustomerPostcodeContainsSpecialCharacter messageId="fde04de2-0996-4a3a-85ff-d57c0153fc5c" serviceType="CustomerPortal" status="PostcodeContainsSpecialCharacter" result="Success" ipAddress="77.88.99.101" responseSent="2013-07-13T12:13:15.000+01:00" requestSent="2013-07-13T12:13:14.000+01:00" postCode="SW11NA" dln="LEESH702100C99DP"/>.withMessageId(message.messageId)
    }


    "correctly reflect NINOAuthenticateServiceError instance" in {
      val message = NINOAuthenticateServiceError("LEESH702100C99DP", org.joda.time.DateTime.parse("2013-07-13T12:13:14"), org.joda.time.DateTime.parse("2013-07-13T12:13:15"), "77.88.99.101")
      message.toXml mustEqual
          <NINOAuthenticateServiceError messageId="d3a47d26-5f55-4426-90e0-4bd5923b1bca" serviceType="CustomerPortal" status="ServerError" result="Failure" authenticationType="DWP" ipAddress="77.88.99.101" responseSent="2013-07-13T12:13:15.000+01:00" requestSent="2013-07-13T12:13:14.000+01:00" dln="LEESH702100C99DP"/>.withMessageId(message.messageId)
    }


    "correctly reflect CustomerPersonalDetailsServerError instance" in {
      val message = CustomerPersonalDetailsServerError("Alice", "Allison", org.joda.time.DateTime.parse("1984-04-13"), 1, "SW11NA", org.joda.time.DateTime.parse("2013-07-13T12:13:14"), org.joda.time.DateTime.parse("2013-07-13T12:13:15"), "77.88.99.101")
      message.toXml mustEqual
          <CustomerPersonalDetailsServerError messageId="ef8e6126-708d-4d15-831e-df2cd6349445" serviceType="CustomerPortal" status="ServerError" result="Failure" ipAddress="77.88.99.101" responseSent="2013-07-13T12:13:15.000+01:00" requestSent="2013-07-13T12:13:14.000+01:00" postCode="SW11NA" gender="1" dob="1984-04-13T00:00:00.000+01:00" surname="Allison" forename="Alice"/>.withMessageId(message.messageId)
    }


    "correctly reflect MibRealTimeEnquiryMessageReturned instance" in {
      val message = MibRealTimeEnquiryMessageReturned(java.util.UUID.fromString("cf09ed40-1353-4622-a59e-e640a38e2202"), "LEESH702100C99DP", "SW11NA", org.joda.time.DateTime.parse("2013-07-13T12:13:14"), org.joda.time.DateTime.parse("2013-07-13T12:13:15"), "Hello, World!", "77.88.99.101", "big-bad-batch", true)
      message.toXml mustEqual
          <MibRealTimeEnquiryMessageReturned messageId="30791a3f-fe4b-4b0c-b15b-b8c9d3c6fccd" serviceType="MibRealTime" status="MessageReturned" result="Success" vrmProvided="true" batchId="big-bad-batch" ipAddress="77.88.99.101" message="Hello, World!" responseSent="2013-07-13T12:13:15.000+01:00" requestSent="2013-07-13T12:13:14.000+01:00" postCode="SW11NA" dln="LEESH702100C99DP" enquiryId="cf09ed40-1353-4622-a59e-e640a38e2202"/>.withMessageId(message.messageId)
    }


    "correctly reflect NINOAuthenticateDeceased instance" in {
      val message = NINOAuthenticateDeceased("LEESH702100C99DP", "what?", "pardon?", "died by snu snu", org.joda.time.DateTime.parse("2013-07-13T12:13:14"), org.joda.time.DateTime.parse("2013-07-13T12:13:15"), "77.88.99.101")
      message.toXml mustEqual
          <NINOAuthenticateDeceased messageId="456f88e8-5067-42a0-aa10-8cb9d5c15bdc" serviceType="CustomerPortal" status="Deceased" result="Failure" authenticationType="DWP" ipAddress="77.88.99.101" responseSent="2013-07-13T12:13:15.000+01:00" requestSent="2013-07-13T12:13:14.000+01:00" deceased="died by snu snu" coreAndAddressMatch="pardon?" coreMatch="what?" dln="LEESH702100C99DP"/>.withMessageId(message.messageId)
    }


    "correctly reflect DvlaDlnNotFound instance" in {
      val message = DvlaDlnNotFound("LEESH702100C99DP", org.joda.time.DateTime.parse("2013-07-13T12:13:14"), org.joda.time.DateTime.parse("2013-07-13T12:13:15"), "pigeon", "curiosity" :: Nil, "123", "77.88.99.101")
      message.toXml mustEqual
          <DvlaDlnNotFound messageId="b130e9f9-c004-4d02-9ede-d0361b784f19" serviceType="DvlaPortal" status="NotFound" result="Failure" ipAddress="77.88.99.101" userId="123" enquiryReasons="List(curiosity)" contactChannel="pigeon" responseSent="2013-07-13T12:13:15.000+01:00" requestSent="2013-07-13T12:13:14.000+01:00" dln="LEESH702100C99DP"/>.withMessageId(message.messageId)
    }


    "correctly reflect DvlaDlnSuccessful instance" in {
      val message = DvlaDlnSuccessful("LEESH702100C99DP", org.joda.time.DateTime.parse("2013-07-13T12:13:14"), org.joda.time.DateTime.parse("2013-07-13T12:13:15"), "pigeon", "curiosity" :: Nil, "123", "77.88.99.101")
      message.toXml mustEqual
          <DvlaDlnSuccessful messageId="0eb6e89f-71d3-482f-8a6b-2eeea6d3c6e7" serviceType="DvlaPortal" status="RecordFound" result="Success" ipAddress="77.88.99.101" userId="123" enquiryReasons="List(curiosity)" contactChannel="pigeon" responseSent="2013-07-13T12:13:15.000+01:00" requestSent="2013-07-13T12:13:14.000+01:00" dln="LEESH702100C99DP"/>.withMessageId(message.messageId)
    }


    "correctly reflect MibRealTimeMissingMandatoryFields instance" in {
      val message = MibRealTimeMissingMandatoryFields(java.util.UUID.fromString("cf09ed40-1353-4622-a59e-e640a38e2202"), "LEESH702100C99DP", "SW11NA", org.joda.time.DateTime.parse("2013-07-13T12:13:14"), org.joda.time.DateTime.parse("2013-07-13T12:13:15"), "77.88.99.101", "big-bad-batch", true)
      message.toXml mustEqual
          <MibRealTimeMissingMandatoryFields messageId="37b39f82-30ab-4f18-aaae-a514c85422ce" serviceType="MibRealTime" status="NotValid" result="Failure" vrmProvided="true" batchId="big-bad-batch" ipAddress="77.88.99.101" responseSent="2013-07-13T12:13:15.000+01:00" requestSent="2013-07-13T12:13:14.000+01:00" postCode="SW11NA" dln="LEESH702100C99DP" enquiryId="cf09ed40-1353-4622-a59e-e640a38e2202"/>.withMessageId(message.messageId)
    }


    "correctly reflect DvlaPersonalDetailsSuppressed instance" in {
      val message = DvlaPersonalDetailsSuppressed("LEESH702100C99DP", "Alice", "Allison", org.joda.time.DateTime.parse("1984-04-13"), 1, "SW11NA", org.joda.time.DateTime.parse("2013-07-13T12:13:14"), org.joda.time.DateTime.parse("2013-07-13T12:13:15"), "headache", "pigeon", "curiosity" :: Nil, "77.88.99.101")
      message.toXml mustEqual
          <DvlaPersonalDetailsSuppressed messageId="578821f1-11ee-445c-815b-3cb459102449" serviceType="DvlaPortal" status="Suppressed" result="Failure" ipAddress="77.88.99.101" enquiryReasons="List(curiosity)" contactChannel="pigeon" suppressionReason="headache" responseSent="2013-07-13T12:13:15.000+01:00" requestSent="2013-07-13T12:13:14.000+01:00" postCode="SW11NA" gender="1" dob="1984-04-13T00:00:00.000+01:00" surname="Allison" forename="Alice" dln="LEESH702100C99DP"/>.withMessageId(message.messageId)
    }


    "correctly reflect NINOAuthenticateSuccess instance" in {
      val message = NINOAuthenticateSuccess("LEESH702100C99DP", "what?", "pardon?", "died by snu snu", org.joda.time.DateTime.parse("2013-07-13T12:13:14"), org.joda.time.DateTime.parse("2013-07-13T12:13:15"), "77.88.99.101")
      message.toXml mustEqual
          <NINOAuthenticateSuccess messageId="9d3ff5d4-1475-4514-a085-94c2a9d45a59" serviceType="CustomerPortal" status="CoreMatch" result="Success" authenticationType="DWP" ipAddress="77.88.99.101" responseSent="2013-07-13T12:13:15.000+01:00" requestSent="2013-07-13T12:13:14.000+01:00" deceased="died by snu snu" coreAndAddressMatch="pardon?" coreMatch="what?" dln="LEESH702100C99DP"/>.withMessageId(message.messageId)
    }


    "correctly reflect DvlaPersonalDetailsServerError instance" in {
      val message = DvlaPersonalDetailsServerError("Alice", "Allison", org.joda.time.DateTime.parse("1984-04-13"), 1, "SW11NA", org.joda.time.DateTime.parse("2013-07-13T12:13:14"), org.joda.time.DateTime.parse("2013-07-13T12:13:15"), "pigeon", "curiosity" :: Nil, "123", "77.88.99.101")
      message.toXml mustEqual
          <DvlaPersonalDetailsServerError messageId="d772ce24-2052-4c57-ac45-c676ee1350bf" serviceType="DvlaPortal" status="ServerError" result="Failure" ipAddress="77.88.99.101" userId="123" enquiryReasons="List(curiosity)" contactChannel="pigeon" responseSent="2013-07-13T12:13:15.000+01:00" requestSent="2013-07-13T12:13:14.000+01:00" postCode="SW11NA" gender="1" dob="1984-04-13T00:00:00.000+01:00" surname="Allison" forename="Alice"/>.withMessageId(message.messageId)
    }


    "correctly reflect DvlaPersonalDetailsSuccessful instance" in {
      val message = DvlaPersonalDetailsSuccessful("LEESH702100C99DP", "Alice", "Allison", org.joda.time.DateTime.parse("1984-04-13"), 1, "SW11NA", org.joda.time.DateTime.parse("2013-07-13T12:13:14"), org.joda.time.DateTime.parse("2013-07-13T12:13:15"), "pigeon", "curiosity" :: Nil, "123", "77.88.99.101")
      message.toXml mustEqual
          <DvlaPersonalDetailsSuccessful messageId="7bb8c331-76b4-40ca-a35c-aeff6c37e04f" serviceType="DvlaPortal" status="RecordFound" result="Success" ipAddress="77.88.99.101" userId="123" enquiryReasons="List(curiosity)" contactChannel="pigeon" responseSent="2013-07-13T12:13:15.000+01:00" requestSent="2013-07-13T12:13:14.000+01:00" postCode="SW11NA" gender="1" dob="1984-04-13T00:00:00.000+01:00" surname="Allison" forename="Alice" dln="LEESH702100C99DP"/>.withMessageId(message.messageId)
    }

  }
}
package uk.gov.dvla.messages

import scala.reflect.runtime.universe._
import scala.reflect.runtime.{currentMirror => cm}
import scala.tools.reflect.ToolBox
import java.util.UUID

/* Generates the testing code for serializing audit messages to XML
 * Use responsibly - DO NOT REMOVE
 */

object ValExp {
  val toolBox = cm.mkToolBox()
  def eval(expr: String) = toolBox.eval(toolBox.parse(expr))
  def apply(expr: String): ValExp = ValExp(eval(expr), expr)
}

object ValStr {
  def apply(expr: String) = ValExp(expr, "\"%s\"" format expr)
}

case class ValExp(value: Any, expr: String)

case class MessageUnit(name: String, ctor: String, xml: String)

object XmlSerializationSpecGenerator {

  val valExps = Map[String, ValExp](
    "dln" -> ValStr("LEESH702100C99DP"),
    "postCode" -> ValStr("SW11NA"),
    "dob" -> ValExp("""org.joda.time.DateTime.parse("1984-04-13")"""),
    "requestSent" -> ValExp("""org.joda.time.DateTime.parse("2013-07-13T12:13:14")"""),
    "responseSent" -> ValExp("""org.joda.time.DateTime.parse("2013-07-13T12:13:15")"""),
    "ipAddress" -> ValStr("77.88.99.101"),
    "forename" -> ValStr("Alice"),
    "surname" -> ValStr("Allison"),
    "gender" -> ValExp("1"),
    "suppressionReason" -> ValStr("headache"),
    "enquiryReasons" -> ValExp("\"curiosity\" :: Nil"),
    "contactChannel" -> ValStr("pigeon"),
    "userId" -> ValStr("123"),
    "enquiryId" -> ValExp(s"""java.util.UUID.fromString("${UUID.randomUUID()}")"""),
    "requestId" -> ValStr("123456-abc"),
    "ruleApplied" -> ValStr("rule of thumb"),
    "message" -> ValStr("Hello, World!"),
    "batchId" -> ValStr("big-bad-batch"),
    "vrmProvided" -> ValExp("true"),
    "coreMatch" -> ValStr("what?"),
    "matchingOutcome" -> ValStr("marriage"),
    "matchingBasis" -> ValStr("both over 40"),
    "pid" -> ValStr("1234"),
    "received" -> ValExp("""org.joda.time.DateTime.parse("2013-07-13T12:13:14")"""),
    "created" -> ValExp("""org.joda.time.DateTime.parse("2013-07-13T12:13:14")"""),
    "result" -> ValExp("uk.gov.dvla.messages.Result.Success"),
    "noRequests" -> ValExp("100"),
    "errorCodes" -> ValExp("Nil"),
    "coreAndAddressMatch" -> ValStr("pardon?"),
    "deceased" -> ValStr("died by snu snu"),
    "matchId" -> ValStr("1"),
    "requestReceived" -> ValExp("""org.joda.time.DateTime.parse("2013-07-13T12:13:14")""")
  )

  val values = valExps map { case (key, ValExp(value, _)) => key -> value }
  val expressions = valExps map { case (key, ValExp(_, expr)) => key -> expr }

  val messageClasses: Set[ClassSymbol] = {
    val cls = typeOf[AuditMessage].typeSymbol.asClass
    require { cls.isSealed }
    cls.knownDirectSubclasses.map(_.asClass)
  }

  def constructor(cls: ClassSymbol) =
    cls.toType.declaration(nme.CONSTRUCTOR).asMethod

  def paramNames(ctor: MethodSymbol) =
    ctor.paramss.head map (_.name.toString)

  def constructExpression(cls: ClassSymbol): String = {
    val args = paramNames(constructor(cls)) map expressions mkString ("(", ", ", ")")
    cls.name.toString + args
  }

  def constructInstance(cls: ClassSymbol): AuditMessage = {
    val ctor = constructor(cls)
    val args = paramNames(ctor) map values
    cm.reflectClass(cls).reflectConstructor(ctor)(args: _*).asInstanceOf[AuditMessage]
  }

  val messageUnits = messageClasses map {
    cls =>
      MessageUnit(cls.name.toString,
        constructExpression(cls),
        constructInstance(cls).toXml.toString())
  }

  def unitTemplate(mu: MessageUnit) =
    s"""
      |"correctly reflect ${mu.name} instance" in {
      |  val message = ${mu.ctor}
      |  message.toXml mustEqual
      |    ${mu.xml}.withMessageId(message.messageId)
      |}
    """.stripMargin split "\n" map ("  " * 2 + _) mkString "\n"

  val spec =
    s"""
      |package uk.gov.dvla.messages
      |
      |/* Code generated with XmlSerializationSpecGenerator.scala */
      |
      |import org.specs2.mutable._
      |import scala.xml._
      |import java.util.UUID
      |
      |class MesssageIdModifier(elem: Elem) {
      |  def withMessageId(uuid: UUID) = {
      |    val attrs = MetaData.concatenate(
      |      elem.attributes.remove("messageId"),
      |      <a messageId={uuid.toString}/>.attributes)
      |    elem.copy(attributes = attrs)
      |  }
      |}
      |
      |object XmlSerializationSpec extends Specification {
      |
      |  implicit def elem2MessageIdModifier(elem: Elem) = new MesssageIdModifier(elem)
      |
      |  "XML serialization of an AuditMessage" should {
      |    ${messageUnits map unitTemplate mkString "\n"}
      |  }
      |}
      |
    """.stripMargin
}

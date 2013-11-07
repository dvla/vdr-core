package uk.gov.dvla.services.mib

import org.apache.commons.lang3.StringUtils
import uk.gov.dvla.services.mib.MibMessageCodes._
import uk.gov.dvla.core.Validators._
import java.util.{List => JList}
import scala.collection.JavaConversions._

object MibRequestValidator {

  // don't validate if the field is missing (for fields that have been
  // validated for presence and for optional fields)
  def ifPresent(validated: String, validator: String => Boolean): Boolean =
    Option(validated) filterNot (_.isEmpty) map validator getOrElse true

  val validatorsBatch = List[(MibRequest => Boolean, String)] (
    (r => !StringUtils.isEmpty(r.requestId), VALIDATION_ERROR_MISSING_GUID),
    (r => !StringUtils.isEmpty(r.dln), VALIDATION_ERROR_MISSING_DLN),
    (r => !StringUtils.isEmpty(r.proposerIndicator), VALIDATION_ERROR_MISSING_PROPOSER),
    (r => ifPresent(r.requestId, validateGuid), VALIDATION_ERROR_INVALID_GUID),
    (r => ifPresent(r.dln, validateDln), VALIDATION_ERROR_INVALID_DLN),
    (r => ifPresent(r.postcode, validatePostcode), VALIDATION_ERROR_INVALID_PC),
    (r => ifPresent(r.vrm, validateVrm), VALIDATION_ERROR_INVALID_VRM),
    (r => ifPresent(r.proposerIndicator, validateProposer), VALIDATION_ERROR_INVALID_PROPOSER)
  )

  val validatorsRealTime = validatorsBatch filterNot {
    case (_, code) => Set(VALIDATION_ERROR_MISSING_PROPOSER,
      VALIDATION_ERROR_INVALID_PROPOSER) contains code
  }

  def validate(validators: List[(MibRequest => Boolean, String)])(request: MibRequest): List[String] =
    validators filter { case (v, _) => !v(request) } map (_._2)

  val validateBatch = validate(validatorsBatch) _

  def validateRealTime(r: MibRequest): JList[String] =
    validate(validatorsRealTime)(r)
}

package uk.gov.dvla.services.mib

import java.util.{List => JList}
import org.slf4j.LoggerFactory
import scala.collection.JavaConversions._

object MibRequest {
  val logger = LoggerFactory.getLogger(classOf[MibRequest])
  val NOColumns = 6

  def apply(batchId: String, columns: JList[String]): MibRequest =
    apply(batchId, columns.toList)

  def apply(batchId: String, columns: List[String]): MibRequest = {
    val (groupId :: requestId ::
      proposerIndicator :: dln ::
      postcode :: vrm :: tail) = supplementList(columns)

    if (!tail.isEmpty)
      logger.warn("Ignoring extra columns in request [{}]", requestId)

    MibRequest(batchId, groupId, requestId, proposerIndicator, dln, postcode, vrm)
  }

  def supplementList(list: List[String]) =
    list ++ List.fill(math.max(NOColumns - list.size, 0))(null)
}

case class MibRequest(
  batchId: String,
  groupId: String,
  requestId: String,
  proposerIndicator: String,
  dln: String,
  postcode: String,
  vrm: String)

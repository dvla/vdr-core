package uk.gov.dvla.services.transform

import uk.gov.dvla.domain.Address
import uk.gov.dvla.domain.portal.PortalDTO
import scala.collection.JavaConversions._

object AddressTransformer {
  def apply(address: Address): PortalDTO.Address = address.getType match {
    case "UN" => unstructured(address)
    case _    => structured(address)
  }

  def structured(address: Address) = {
    val addrLine =
      address.getSubBuildingName ::
      address.getBuildingName ::
      address.getBuildingNumber ::
      address.getDdtfare ::
      address.getDtfare ::
      address.getTfare ::
      address.getDdLocality ::
      address.getdLocality ::
      address.getPostTown :: Nil

    val result = new PortalDTO.Address
    result.setAddrLine(addrLine filterNot (_ == null) mkString " ")
    result.setPostCode(address.getPostCode)
    result
  }

  def unstructured(address: Address) = {
    val result = new PortalDTO.Address
    result.setAddrLine(address.getuLine mkString " ")
    result.setPostCode(address.getuPostCode)
    result
  }
}

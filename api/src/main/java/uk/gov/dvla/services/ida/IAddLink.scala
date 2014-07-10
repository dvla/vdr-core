package uk.gov.dvla.services.ida

trait IAddLink {
  def add(puid: String, partyId: String)
}
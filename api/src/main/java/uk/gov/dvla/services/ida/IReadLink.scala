package uk.gov.dvla.services.ida

import uk.gov.dvla.domain.ida.IdaLinkToPartyPair

trait IReadLink {
  def getLinkPair(puid: String): Option[IdaLinkToPartyPair]
}
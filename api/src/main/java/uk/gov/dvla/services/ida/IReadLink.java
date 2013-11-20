package uk.gov.dvla.services.ida;


import com.google.common.base.Optional;
import uk.gov.dvla.domain.ida.IdaLinkToPartyPair;

public interface IReadLink {
    Optional<IdaLinkToPartyPair> getLinkPair(String puid);
}

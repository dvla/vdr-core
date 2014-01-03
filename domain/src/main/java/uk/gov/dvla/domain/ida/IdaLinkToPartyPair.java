package uk.gov.dvla.domain.ida;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Indexed;

import java.util.Date;

@Entity(value = "links", noClassnameStored = true)
public class IdaLinkToPartyPair {

    @Id
    @Indexed(name = "puid", unique = true)
    private String puid;

    private String partyId;

    private Date created;

    public IdaLinkToPartyPair() {
    }

    public IdaLinkToPartyPair(String puid, String partyId) {
        this.partyId = partyId;
        this.puid = puid;
        created = new Date();
    }

    public String getPuid() {
        return puid;
    }

    public void setPuid(String puid) {
        this.puid = puid;
    }

    public String getPartyId() {
        return partyId;
    }

    public void setPartyId(String partyId) {
        this.partyId = partyId;
    }

    public Date getCreated() {
        return created;
    }
}

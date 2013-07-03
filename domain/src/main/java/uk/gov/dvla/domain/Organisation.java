package uk.gov.dvla.domain;

import com.google.code.morphia.annotations.Embedded;

import java.lang.String;
import java.util.Date;

@Embedded
public class Organisation {
    private String name;
    private String type;
    private Date validFrom;
    private Date validTo;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(Date validFrom) {
        this.validFrom = validFrom;
    }

    public Date getValidTo() {
        return validTo;
    }

    public void setValidTo(Date validTo) {
        this.validTo = validTo;
    }
}

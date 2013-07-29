package uk.gov.dvla.domain;

import com.google.code.morphia.annotations.Embedded;

@Embedded
public class Telephone {
    private String number;
    private Integer contactType;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Integer getContactType() {
        return contactType;
    }

    public void setContactType(Integer contactType) {
        this.contactType = contactType;
    }
}

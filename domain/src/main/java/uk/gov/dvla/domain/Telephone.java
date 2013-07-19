package uk.gov.dvla.domain;

import com.google.code.morphia.annotations.Embedded;

@Embedded
public class Telephone {
    private String number;
    private ContactType contactType;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public ContactType getContactType() {
        return contactType;
    }

    public void setContactType(ContactType contactType) {
        this.contactType = contactType;
    }
}

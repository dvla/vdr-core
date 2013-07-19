package uk.gov.dvla.domain;

import com.google.code.morphia.annotations.Embedded;

@Embedded
public class ElectronicAddress {
    private String address;
    private ContactType contactType;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ContactType getContactType() {
        return contactType;
    }

    public void setContactType(ContactType contactType) {
        this.contactType = contactType;
    }
}

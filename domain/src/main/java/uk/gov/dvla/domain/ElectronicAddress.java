package uk.gov.dvla.domain;

import org.mongodb.morphia.annotations.Embedded;

@Embedded
public class ElectronicAddress {
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

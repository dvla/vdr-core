package uk.gov.dvla.domain;

import com.google.code.morphia.annotations.Embedded;

@Embedded
public enum AddressType {
    CountryOnly(0, "CO"),
    Military(1, "M"),
    UKStructured(2, "UK"),
    Unstructured(3,"UN"),
    POBox(4, "PO");


    public int getAddressType()
    {
        return value;
    }

    private int value;
    private String valueName;

    private AddressType(int value, String valueName) {
        this.value = value;
        this.valueName = valueName;
    }
}
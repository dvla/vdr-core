package uk.gov.dvla.domain;

import com.google.code.morphia.annotations.Embedded;

@Embedded
public enum AddressType {
    CountryOnly("CO", "CO"),
    Military("M", "M"),
    UKStructured("UK", "UK"),
    Unstructured("UN","UN");


    public String getAddressType()
    {
        return value;
    }

    private String value;
    private String valueName;

    private AddressType(String value, String valueName) {
        this.value = value;
        this.valueName = valueName;
    }
}
package uk.gov.dvla.domain;

import com.google.code.morphia.annotations.Embedded;

@Embedded
public enum ContactType {
    DaytimeTelephone(1, "Daytime"),
    HomeTelephone(2, "Home"),
    Email(3, "Email"),
    Fax(4,"Fax"),
    Mobile(5, "Mobile"),
    ContactName(6, "Contact");

    public int getContactType()
    {
        return value;
    }

    private int value;
    private String valueName;

    private ContactType(int value, String valueName) {
        this.value = value;
        this.valueName = valueName;
    }
}

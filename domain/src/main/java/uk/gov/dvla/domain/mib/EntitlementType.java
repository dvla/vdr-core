package uk.gov.dvla.domain.mib;

import com.fasterxml.jackson.annotation.JsonValue;

public enum EntitlementType {
    Full(0, "F"),
    Provisional(1, "P"),
    UnclaimedTestPass(2, "U");

    public int getEntitlementType()
    {
        return value;
    }

    @JsonValue
    final String getValueName() {
        return this.valueName;
    }

    private int value;
    private String valueName;

    private EntitlementType(int value, String valueName) {
        this.value = value;
        this.valueName = valueName;
    }
}

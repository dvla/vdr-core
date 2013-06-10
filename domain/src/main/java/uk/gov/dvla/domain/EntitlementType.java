package uk.gov.dvla.domain;

public enum EntitlementType {
    Full(0, "Full"),
    Provisional(1, "Provisional"),
    UnclaimedTestPass(2, "Unclaimed Test Pass");


    public int getEntitlementType()
    {
        return value;
    }

    private int value;
    private String valueName;

    private EntitlementType(int value, String valueName) {
        this.value = value;
        this.valueName = valueName;
    }
}

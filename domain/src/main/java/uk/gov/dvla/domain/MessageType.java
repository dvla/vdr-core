package uk.gov.dvla.domain;

public enum MessageType {
    SuppressFullRecord(0, "Full Record Suppression"),
    SuppressEntitlements(1, "Entitlement Suppression"),
    SuppressLicenceStatus(2, "Suppress Licence Status"),
    SuppressLicenceValidFrom(3, "Suppress Licence Valid From Date"),
    SuppressLicenceValidTo(4, "Suppress Licence Valid To Date"),
    LicenceExpired(5,"Driving Licence Expired"),
    PostcodeMismatch(6,"Postcode Mismatch");

    public int getMessageType()
    {
        return value;
    }

    private int value;
    private String valueName;

    private MessageType(int value, String valueName) {
        this.value = value;
        this.valueName = valueName;
    }
}


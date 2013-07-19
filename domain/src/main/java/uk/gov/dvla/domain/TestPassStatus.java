package uk.gov.dvla.domain;

public enum TestPassStatus {
    Cancelled("CAN", "CAN"),
    CancelledRTTP("CANRTTP", "CANRTTP"),
    NotYetClaimed("NYC", "NYC"),
    NotYetClaimedCancelled("NYCCAN", "NYCCAN"),
    NotYetClaimedCancelledRTTP("NYCCANRTTP", "NYCCANRTTP"),
    OnLicence("ONLIC", "ONLIC");

    public String getTestPassStatus()
    {
        return value;
    }

    private String value;
    private String valueName;

    private TestPassStatus(String value, String valueName) {
        this.value = value;
        this.valueName = valueName;
    }
}
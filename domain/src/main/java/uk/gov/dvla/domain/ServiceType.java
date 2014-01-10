package uk.gov.dvla.domain;

public enum ServiceType {
    DVLAPortal(0, "DVLA Portal"),
    CustomerPortal(1, "Customer Portal"),
    EnrichmentPortal(2, "Enrichment Portal");


    public int getServiceType()
    {
        return value;
    }

    private int value;
    private String valueName;

    private ServiceType(int value, String valueName) {
        this.value = value;
        this.valueName = valueName;
    }
}

package uk.gov.dvla.domain;

/**
 * Used by the Drools environment to "tag" outbound data with additional information.
 * Should match that in iep-customer-portal/app/model/Message.scala/MessageType.
 */
public enum MessageType {
    SuppressFullRecord(0, "Full Record Suppression"),
    SuppressEntitlements(1, "Entitlement Suppression"),
    SuppressLicenceStatus(2, "Suppress Licence Status"),
    SuppressLicenceValidFrom(3, "Suppress Licence Valid From Date"),
    SuppressLicenceValidTo(4, "Suppress Licence Valid To Date"),
    LicenceExpired(5,"Driving Licence Expired"),
    PostcodeMismatch(6,"Postcode Mismatch"),
    NoData(7, "No Data to provide"),
    LicenceStatusModified(8, "Licence status text modified"),
    WithholdFullRecord(9, "Record withheld"),
    SuppressionReason(10, "Suppression Reason"),
    PartialSuppressionReason(11, "Partial Suppression Reason");

    public int getMessageType() {
        return value;
    }

    private int value;
    private String valueName;

    private MessageType(int value, String valueName) {
        this.value = value;
        this.valueName = valueName;
    }
}

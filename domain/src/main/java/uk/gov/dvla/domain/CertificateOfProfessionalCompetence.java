package uk.gov.dvla.domain;

import com.google.code.morphia.annotations.Embedded;

import java.util.Date;

@Embedded
public class CertificateOfProfessionalCompetence {
    private String creatingReasonCode;
    private String updatingReasonCode;
    private Date recordValidFrom;
    private Date recordValidTo;
    private Date LGVValidFrom;
    private Date LGVValidTo;
    private Date PCVValidFrom;
    private Date PCVValidTo;

    public String getCreatingReasonCode() {
        return creatingReasonCode;
    }

    public void setCreatingReasonCode(String creatingReasonCode) {
        this.creatingReasonCode = creatingReasonCode;
    }

    public String getUpdatingReasonCode() {
        return updatingReasonCode;
    }

    public void setUpdatingReasonCode(String updatingReasonCode) {
        this.updatingReasonCode = updatingReasonCode;
    }

    public Date getRecordValidFrom() {
        return recordValidFrom;
    }

    public void setRecordValidFrom(Date recordValidFrom) {
        this.recordValidFrom = recordValidFrom;
    }

    public Date getRecordValidTo() {
        return recordValidTo;
    }

    public void setRecordValidTo(Date recordValidTo) {
        this.recordValidTo = recordValidTo;
    }

    public Date getLGVValidFrom() {
        return LGVValidFrom;
    }

    public void setLGVValidFrom(Date LGVValidFrom) {
        this.LGVValidFrom = LGVValidFrom;
    }

    public Date getLGVValidTo() {
        return LGVValidTo;
    }

    public void setLGVValidTo(Date LGVValidTo) {
        this.LGVValidTo = LGVValidTo;
    }

    public Date getPCVValidFrom() {
        return PCVValidFrom;
    }

    public void setPCVValidFrom(Date PCVValidFrom) {
        this.PCVValidFrom = PCVValidFrom;
    }

    public Date getPCVValidTo() {
        return PCVValidTo;
    }

    public void setPCVValidTo(Date PCVValidTo) {
        this.PCVValidTo = PCVValidTo;
    }
}

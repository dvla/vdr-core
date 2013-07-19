package uk.gov.dvla.domain;

import com.google.code.morphia.annotations.Embedded;

import java.lang.String;
import java.util.Date;

@Embedded
public class Passport {

    private String number;
    private Date expiryDate;
    private Date issueDate;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }
}

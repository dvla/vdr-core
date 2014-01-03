package uk.gov.dvla.domain;

import org.mongodb.morphia.annotations.Embedded;

@Embedded
public enum UnclaimedTestPass {
    NotUnclaimed(0, "False"),
    Unclaimed(1, "True"),
    Cancelled(2, "Cancelled");


    public int getUnclaimedTestPass()
    {
        return value;
    }

    private int value;
    private String valueName;

    private UnclaimedTestPass(int value, String valueName) {
        this.value = value;
        this.valueName = valueName;
    }
}
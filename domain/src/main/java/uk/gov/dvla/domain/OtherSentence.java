package uk.gov.dvla.domain;

import java.util.Date;
import java.util.List;

import com.google.code.morphia.annotations.Embedded;

@Embedded
public class OtherSentence {

    private String code;
    private String duration;
    private String periodType;

    public String getCode() {
        return code;
    }
    public void setCode(String code ) {
        this.code = code;
    }
    public String getDuration() {
        return duration;
    }
    public void setDuration(String duration ) {
        this.duration = duration;
    }
    public String periodType() {
        return periodType;
    }
    public void setPeriodType(String periodType ) {
        this.periodType = periodType;
    }
}
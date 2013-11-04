package uk.gov.dvla.domain;

import java.lang.String;
import java.util.Date;
import java.util.List;

import com.google.code.morphia.annotations.Embedded;

@Embedded
public class OtherSentence {

    private String code;
    private String name;
    private String duration;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        if (duration != null)
            return code + duration.replace("P", "");
        else
            return code;
    }
}
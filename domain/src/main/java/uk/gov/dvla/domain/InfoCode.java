package uk.gov.dvla.domain;

import com.google.code.morphia.annotations.Embedded;
import java.util.List;

@Embedded
public class InfoCode {
    private String code;
    private List<String> categoryCodes;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<String> getCategoryCodes() {
        return categoryCodes;
    }

    public void setCategoryCodes(List<String> categoryCodes) {
        this.categoryCodes = categoryCodes;
    }

    public InfoCode(String code, List<String> categoryCodes) {
        this.code = code;
        this.categoryCodes = categoryCodes;
    }

    public InfoCode() {
    }
}

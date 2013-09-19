package uk.gov.dvla.domain.mib;

import java.util.List;

public class ErrorResponse {
    private List<String> errorCodes;

    public List<String> getErrorCodes() {
        return  errorCodes;
    }

    public void setErrorCodes(List<String> errorCodes) {
        this.errorCodes = errorCodes;
    }
}

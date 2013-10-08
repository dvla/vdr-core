package uk.gov.dvla.services.authentication.exceptions;

public class DWPNegativeMatchException extends AuthenticationException {

    public DWPNegativeMatchException(String msg) {
        super(msg);
    }

    public DWPNegativeMatchException(String msg, Throwable t) {
        super(msg, t);
    }
}
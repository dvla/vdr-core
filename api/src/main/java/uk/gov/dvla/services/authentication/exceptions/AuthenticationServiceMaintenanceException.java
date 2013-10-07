package uk.gov.dvla.services.authentication.exceptions;

public class AuthenticationServiceMaintenanceException extends AuthenticationException {

    public AuthenticationServiceMaintenanceException(String msg) {
        super(msg);
    }

    public AuthenticationServiceMaintenanceException(String msg, Throwable t) {
        super(msg, t);
    }
}
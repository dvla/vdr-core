package uk.gov.dvla.services.ida.dcs;

public interface DriverMatcher<A, B> {
    public boolean match(A matchRequest, B matchResponse);
}

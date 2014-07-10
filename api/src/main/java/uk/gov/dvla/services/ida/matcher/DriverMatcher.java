package uk.gov.dvla.services.ida.matcher;

import com.google.common.base.Optional;

import java.util.List;

public interface DriverMatcher<A, B> {
    public Optional<List<String>> match(A matchRequest, B matchResponse);
}

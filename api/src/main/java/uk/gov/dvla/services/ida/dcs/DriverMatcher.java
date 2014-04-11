package uk.gov.dvla.services.ida.dcs;

import com.google.common.base.Optional;
import java.util.List;
import java.util.Map;

public interface DriverMatcher<A, B> {
    public Optional<Map<String, Boolean>> match(A matchRequest, B matchResponse);
}

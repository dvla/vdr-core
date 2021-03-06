package uk.gov.dvla.services.authentication;

import com.google.common.base.Optional;
import uk.gov.dvla.domain.authentication.DriverAuthToken;

import java.util.Date;
import java.util.List;

public interface DriverAuthTokenProvider {
    DriverAuthToken findDriverAuthTokenByDln(String dln);

    List<DriverAuthToken> findDriverAuthTokenByPersonalDetails(List<String> forenames, String surname, Date dob, int gender, Optional<String> postCode);
}

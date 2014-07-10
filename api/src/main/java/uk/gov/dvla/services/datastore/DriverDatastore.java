package uk.gov.dvla.services.datastore;

import com.google.common.base.Optional;
import uk.gov.dvla.domain.Driver;
import uk.gov.dvla.services.ManagedService;
import uk.gov.dvla.services.authentication.DriverAuthTokenProvider;

import java.util.Date;
import java.util.List;

public interface DriverDatastore extends Datastore, DriverAuthTokenProvider, ManagedService {
    public Driver findByDln(String dln);

    public Driver findByPartyId(String partyId);

    public List<Driver> findByPersonalDetails(List<String> forenames, String surname, Date dob, int gender, Optional<String> postCode);

    public void add(Driver driver);

    public void delete(Driver driver);

}

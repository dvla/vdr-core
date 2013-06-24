package uk.gov.dvla.services.write;

import uk.gov.dvla.domain.Driver;
import uk.gov.dvla.domain.Person;
import uk.gov.dvla.services.ManagedService;

public interface DriverWrite extends ManagedService
{
    public static final String ADD_URI = "/add/";

//    public void post(Driver driver);
}

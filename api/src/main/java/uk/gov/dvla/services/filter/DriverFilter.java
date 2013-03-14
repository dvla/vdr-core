package uk.gov.dvla.services.filter;

import uk.gov.dvla.domain.Driver;

public interface DriverFilter extends Filter
{
    public Driver filter(Driver driverToFilter);
}

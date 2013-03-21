package uk.gov.dvla.services.filter;

import uk.gov.dvla.domain.ServiceResult;

public interface FilterService<T>
{
    public ServiceResult<T> filter(T objectToFilter);
}

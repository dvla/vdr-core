package uk.gov.dvla.services.filter;

import uk.gov.dvla.domain.ServiceResult;
import java.util.UUID;

public interface FilterService<T>
{
    //public ServiceResult<T> filter(UUID id, T objectToFilter, String Context);

    public ServiceResult<T> filter(T objectToFilter, String Context);

}

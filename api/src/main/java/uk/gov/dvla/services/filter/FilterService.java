package uk.gov.dvla.services.filter;

import uk.gov.dvla.domain.ServiceResult;
import java.util.HashMap;

public interface FilterService<T>
{
    public ServiceResult<T> filter(T objectToFilter, HashMap<String, Object> otherValues);
}

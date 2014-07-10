package uk.gov.dvla.services.filter;

import uk.gov.dvla.domain.RulesDriver;

public interface FilterService<T>
{
    public RulesDriver filter(T objectToFilter, String Context);
}

package uk.gov.dvla.services.filter;

public interface FilterService<T>
{
    public T filter(T objectToFilter);
}

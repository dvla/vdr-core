package uk.gov.dvla.services.transform;

public interface TransformService<T, U> {

    public U transform(T objectToTransform);
}

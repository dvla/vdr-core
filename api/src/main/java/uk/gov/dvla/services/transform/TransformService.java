package uk.gov.dvla.services.transform;

import uk.gov.dvla.domain.Message;

import java.util.List;

public interface TransformService<T, U> {

    public U transform(T objectToTransform);
}

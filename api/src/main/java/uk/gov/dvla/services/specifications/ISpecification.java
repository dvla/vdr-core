package uk.gov.dvla.services.specifications;

public interface ISpecification<A, B> {
    public boolean isSatisfiedBy(A compare1, B compare2);
}

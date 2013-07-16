package uk.gov.dvla.domain.authentication;

public abstract class Authentication
{
    protected boolean valid_i = false;

    public boolean isValid()
    {
        return this.valid_i;
    }
}

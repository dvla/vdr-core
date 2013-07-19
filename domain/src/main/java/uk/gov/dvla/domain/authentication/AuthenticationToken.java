package uk.gov.dvla.domain.authentication;

public abstract class AuthenticationToken
{
    protected boolean valid_i = false;

    public boolean getIsValid()
    {
        return this.valid_i;
    }

    public void setIsValid(Boolean isValid)
    {
        this.valid_i = isValid;
    }
}

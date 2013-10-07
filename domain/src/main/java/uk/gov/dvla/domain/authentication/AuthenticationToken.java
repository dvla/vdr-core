package uk.gov.dvla.domain.authentication;

public abstract class AuthenticationToken
{
    private boolean valid_i = false;
    private String token;

    public boolean getIsValid()
    {
        return this.valid_i;
    }

    public void setIsValid(boolean isValid)
    {
        this.valid_i = isValid;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}

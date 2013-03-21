package uk.gov.dvla.domain;


public class Message
{
    private String key;
    private String message;
    private boolean error;

    public Message(){}

    public Message(String key)
    {
        this.key = key;
    }

    public Message(String message, boolean error)
    {
        this.message = message;
        this.error = error;
    }

    public String getKey()
    {
        return key;
    }

    public void setKey(String key)
    {
        this.key = key;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

    public void setError(boolean error)
    {
        this.error = error;
    }

    public boolean isError()
    {
        return this.error;
    }
}

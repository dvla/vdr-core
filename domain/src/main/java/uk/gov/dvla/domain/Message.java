package uk.gov.dvla.domain;


public class Message
{
    private String key;
    private String description;
    private boolean error;
    private int type;

    public Message(){}

    public Message(String key)
    {
        this.key = key;
    }

    public Message(String key, MessageType type)
    {
        this.key = key;
        this.type = type.getMessageType();
    }

    public Message(String description, boolean error)
    {
        this.description = description;
        this.error = error;
    }

    public Message(String description, MessageType type, boolean error)
    {
        this.description = description;
        this.type = type.getMessageType();
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

    public String getDescription()
    {
        return this.description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public void setError(boolean error)
    {
        this.error = error;
    }

    public boolean isError()
    {
        return this.error;
    }

    public int getType()
    {
        return type;
    }

    public void setType(int type)
    {
        this.type = type;
    }
}
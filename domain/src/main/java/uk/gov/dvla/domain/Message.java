package uk.gov.dvla.domain;


public class Message {
    private String key;
    private String description;
    private boolean error;
    private int type;
    private Object extra;

    public Message() {
    }

    public Message(String key) {
        this.key = key;
    }

    public Message(String key, MessageType type) {
        this.key = key;
        this.type = type.getMessageType();
    }

    public Message(String key, MessageType type, Object extra) {
        this.key = key;
        this.type = type.getMessageType();
        this.extra = extra;
    }

    public Message(String description, boolean error) {
        this.description = description;
        this.error = error;
    }

    public Message(String description, MessageType type, boolean error) {
        this.description = description;
        this.type = type.getMessageType();
        this.error = error;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public boolean isError() {
        return this.error;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Object getExtra() {
        return extra;
    }

    public void setExtra(Object extra) {
        this.extra = extra;
    }
}
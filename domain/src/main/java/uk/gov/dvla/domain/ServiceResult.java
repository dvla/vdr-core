package uk.gov.dvla.domain;

import java.util.List;
import java.util.UUID;

public class ServiceResult<T>
{
    private UUID enquiryId;
    private T result;
    private List<Message> messages;
    private String ruleApplied;

    public ServiceResult(){}


    public ServiceResult(T result)
    {
        this(UUID.randomUUID(), result, null, null);
    }

    public ServiceResult(T result, List<Message> messages)
    {
        this(UUID.randomUUID(), result, messages, null);
    }

    public ServiceResult(T result, List<Message> messages, String ruleApplied)
    {
        this(UUID.randomUUID(), result, messages, ruleApplied);
    }

    public ServiceResult(UUID enquiryId, T result)
    {
        this(enquiryId, result, null, null);
    }

    public ServiceResult(UUID enquiryId, T result, List<Message> messages)
    {
        this(enquiryId, result, messages, null);
    }

    public ServiceResult(UUID enquiryId, T result, List<Message> messages, String ruleApplied)
    {
        this.enquiryId = enquiryId;
        this.result = result;
        this.messages = messages;
        this.ruleApplied = ruleApplied;
    }

    public T getResult()
    {
        return result;
    }

    public List<Message> getMessages()
    {
        return messages;
    }

    public boolean hasMessages()
    {
        if ( null != messages && !messages.isEmpty())
        {
            return true;
        }
        return false;
    }

    public String getRuleApplied() {
        return ruleApplied;
    }

    public void setRuleApplied(String ruleApplied) {
        this.ruleApplied = ruleApplied;
    }

    public UUID getEnquiryId() {
        return enquiryId;
    }
}

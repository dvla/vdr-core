package uk.gov.dvla.domain;

import org.joda.time.DateTime;

import java.util.List;
import java.util.UUID;

public class ServiceResult<T>
{
    private UUID guid;
    private String version;
    private DateTime date;
    private T result;
    private List<String> messages;
    private String ruleApplied;

    public ServiceResult(){}


    public ServiceResult(T result)
    {
        this(null, null, null, result, null, null);
    }

    public ServiceResult(T result, List<String> messages)
    {
        this(null, null, null, result, messages, null);
    }

    public ServiceResult(T result, List<String> messages, String ruleApplied)
    {
        this(null, null, null, result, messages, ruleApplied);
    }

    public ServiceResult(UUID enquiryId, String version, DateTime date, T result)
    {
        this(enquiryId, version, date, result, null, null);
    }

    public ServiceResult(UUID enquiryId, String version, DateTime date, T result, List<String> messages)
    {
        this(enquiryId, version, date, result, messages, null);
    }

    public ServiceResult(UUID guid, String version, DateTime date, T result, List<String> messages, String ruleApplied)
    {
        this.guid = guid;
        this.result = result;
        this.messages = messages;
        this.ruleApplied = ruleApplied;
        this.version = version;
        this.date = date;
    }

    public T getResult()
    {
        return result;
    }

    public List<String> getMessages()
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

    public UUID getGuid() {
        return guid;
    }

    public String getVersion() {
        return version;
    }

    public DateTime getDate() {
        return date;
    }
}

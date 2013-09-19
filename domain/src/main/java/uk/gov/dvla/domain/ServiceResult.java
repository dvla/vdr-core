package uk.gov.dvla.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.joda.time.DateTime;

public class ServiceResult<T>
{
    private String guid;
    private String version;
    private DateTime date;
    private T result;

    @JsonIgnore
    private String ruleApplied;

    public ServiceResult(){}

    public ServiceResult(T result)
    {
        this(null, null, null, result, null);
    }

    public ServiceResult(T result, String ruleApplied)
    {
        this(null, null, null, result, ruleApplied);
    }

    public ServiceResult(String enquiryId, String version, DateTime date, T result)
    {
        this(enquiryId, version, date, result, null);
    }

    public ServiceResult(String guid, String version, DateTime date, T result, String ruleApplied)
    {
        this.guid = guid;
        this.result = result;
        this.ruleApplied = ruleApplied;
        this.version = version;
        this.date = date;
    }

    public T getResult()
    {
        return result;
    }

    public String getRuleApplied() {
        return ruleApplied;
    }

    public void setRuleApplied(String ruleApplied) {
        this.ruleApplied = ruleApplied;
    }

    public String getGuid() {
        return guid;
    }

    public String getVersion() {
        return version;
    }

    public DateTime getDate() {
        return date;
    }
}

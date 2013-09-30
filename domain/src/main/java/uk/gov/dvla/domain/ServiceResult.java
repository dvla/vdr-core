package uk.gov.dvla.domain;

import org.joda.time.DateTime;

public class ServiceResult<T> {
    private String guid;
    private String version;
    private DateTime date;
    private T result;

    public ServiceResult() {
    }

    public ServiceResult(T result) {
        this(null, null, null, result);
    }

    public ServiceResult(String guid, String version, DateTime date, T result) {
        this.guid = guid;
        this.result = result;
        this.version = version;
        this.date = date;
    }

    public T getResult() {
        return result;
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

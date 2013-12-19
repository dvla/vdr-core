package uk.gov.dvla.messages;

import org.joda.time.DateTime;
import uk.gov.dvla.servicebus.core.NewMessage;

public class NINOAuthenticateServiceError implements NewMessage {

    public NINOAuthenticateServiceError(String dln, DateTime requestSent, DateTime responseSent, String ipAddress) {
        this.dln = dln;
        this.requestSent = requestSent;
        this.responseSent = responseSent;
        this.ipAddress = ipAddress;
    }

    public String getDln() {
        return dln;
    }

    public void setDln(String dln) {
        this.dln = dln;
    }

    public DateTime getRequestSent() {
        return requestSent;
    }

    public void setRequestSent(DateTime requestSent) {
        this.requestSent = requestSent;
    }

    public DateTime getResponseSent() {
        return responseSent;
    }

    public void setResponseSent(DateTime responseSent) {
        this.responseSent = responseSent;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getAuthenticationType() {
        return authenticationType;
    }

    public void setAuthenticationType(String authenticationType) {
        this.authenticationType = authenticationType;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getServiceType() {
        return serviceType;
    }

    public void setServiceType(int serviceType) {
        this.serviceType = serviceType;
    }

    String dln;
    DateTime requestSent;
    DateTime responseSent;
    String ipAddress;
    String authenticationType = "DWP";
    int result = 0;
    int status = 0;
    int serviceType = 1;
}
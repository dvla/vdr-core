package uk.gov.dvla.domain;

import java.util.List;

public class RulesDriver {
    Driver driver;
    List<Message> messages;
    String ruleApplied;
    String requestedDln;

    public Driver getDriver() {
        return driver;
    }

    public String getRequestedDln() {
        return  requestedDln;
    }

    public void setRequestedDln(String requestedDln) {
        this.requestedDln = requestedDln;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public String getRuleApplied() {
        return ruleApplied;
    }

    public void setRuleApplied(String ruleApplied) {
        this.ruleApplied = ruleApplied;
    }
}

package uk.gov.dvla.domain.mib;

import java.util.List;

public class ErrorResponse {
    private List<String> messages;

    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }
}

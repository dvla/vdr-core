package uk.gov.dvla.domain;

import java.util.List;

public class ServiceResult<T>
{
    private T result;
    private List<Message> messages;
    private String ruleApplied;

    public ServiceResult(){}

    public ServiceResult(T result)
    {
        this(result, null, null);
    }

    public ServiceResult(T result, List<Message> messages, String ruleApplied)
    {
        this.result = result;
        this.messages = messages;
        this.ruleApplied = ruleApplied;
    }

    public void setResult(T result)
    {
        this.result = result;
    }

    public T getResult()
    {
        return result;
    }

    public void setMessages(List<Message> messages)
    {
        this.messages = messages;
    }

    public List<Message> getMessages()
    {
        return messages;
    }

    public boolean hasErrors()
    {
        if ( null != messages && !messages.isEmpty())
        {
            for(Message message : messages)
            {
                if ( message.isError() )
                {
                    return true;
                }
            }
        }
        return false;
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
}

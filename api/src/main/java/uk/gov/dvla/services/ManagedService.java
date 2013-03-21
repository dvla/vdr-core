package uk.gov.dvla.services;

public interface ManagedService 
{
	public void start() throws Exception;
	public void stop();
    public boolean isAlive();
    public String getName();
}

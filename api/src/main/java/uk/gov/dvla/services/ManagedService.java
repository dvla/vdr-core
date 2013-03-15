package uk.gov.dvla.services;

public interface ManagedService 
{
	public void start();
	public void stop();
    public String getName();
    public boolean isAlive();
}

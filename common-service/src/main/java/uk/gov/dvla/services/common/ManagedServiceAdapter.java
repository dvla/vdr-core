package uk.gov.dvla.services.common;

import uk.gov.dvla.services.ManagedService;

import com.yammer.dropwizard.lifecycle.Managed;

public final class ManagedServiceAdapter implements Managed
{
	private ManagedService service_i;
	
	public ManagedServiceAdapter(ManagedService service)
	{
		this.service_i = service;
	}

	@Override
	public void start() throws Exception 
	{
		this.service_i.start();
	}

	@Override
	public void stop() throws Exception 
	{
		this.service_i.stop();
	}
}

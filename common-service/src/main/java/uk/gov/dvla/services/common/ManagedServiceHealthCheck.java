package uk.gov.dvla.services.common;

import uk.gov.dvla.services.ManagedService;
import com.yammer.metrics.core.HealthCheck;

public final class ManagedServiceHealthCheck extends HealthCheck
{
	private ManagedService service_i;

	public ManagedServiceHealthCheck(ManagedService service)
	{
		super(service.getName());
		this.service_i = service;
	}
	
	
	@Override
	protected Result check() throws Exception 
	{
		try
		{
			this.service_i.isAlive();
			return Result.healthy();
		}
		catch(Exception e)
		{
			return Result.unhealthy(e);
		}
	}
}

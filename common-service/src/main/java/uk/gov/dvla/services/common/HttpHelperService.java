package uk.gov.dvla.services.common;

import javax.servlet.http.HttpServletRequest;

public interface HttpHelperService
{
    public String getIpAddress(HttpServletRequest request);
}


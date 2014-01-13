package uk.gov.dvla.services.common;

import javax.servlet.http.HttpServletRequest;

/**
 * What the heck is that supposed to be?!
 * Use HttpRequestHelper instead.
 */
@Deprecated
public interface HttpHelperService
{
    public String getIpAddress(HttpServletRequest request);
}


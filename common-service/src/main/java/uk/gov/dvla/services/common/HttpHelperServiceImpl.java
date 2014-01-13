package uk.gov.dvla.services.common;

import javax.servlet.http.HttpServletRequest;

/**
 * What the heck is that supposed to be?!
 * Use HttpRequestHelper instead.
 */
@Deprecated
public class HttpHelperServiceImpl implements HttpHelperService {

    private final String HEADER_X_FORWARDED_FOR = "X-FORWARDED-FOR";

    @Override
    public String getIpAddress(HttpServletRequest request)
    {
        // Get the originating IP Address, given that we may have a number of hops, check HEADER_X_FORWARDED_FOR first
        String ipAddress = request.getHeader(HEADER_X_FORWARDED_FOR);

        if (ipAddress == null)
        {
            ipAddress = request.getRemoteAddr();
        }

        return ipAddress;
    }
}

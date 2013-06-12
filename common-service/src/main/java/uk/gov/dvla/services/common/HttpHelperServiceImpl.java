package uk.gov.dvla.services.common;

import org.joda.time.DateTime;

import javax.servlet.http.HttpServletRequest;

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

package uk.gov.dvla.services.common;

import javax.servlet.http.HttpServletRequest;

public class HttpRequestHelper {

    public static final String HEADER_X_FORWARDED_FOR = "X-FORWARDED-FOR";

    public static String getIpAddress(HttpServletRequest request) {
        // Get the originating IP Address, given that we may have a number of hops,
        // check HEADER_X_FORWARDED_FOR first
        String ipAddress = request.getHeader(HEADER_X_FORWARDED_FOR);
        return (ipAddress == null) ? request.getRemoteAddr() : ipAddress;
    }
}

package uk.gov.dvla.services.common;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

public final class ServiceDateFormat
{
    public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";
    public static final TimeZone TIME_ZONE = TimeZone.getTimeZone("GMT");
    public static final DateFormat DEFAULT = new SimpleDateFormat(DEFAULT_DATE_FORMAT);
    static {
        DEFAULT.setTimeZone(TIME_ZONE);
    }

}

package uk.gov.dvla.services.common;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public final class ServiceDateFormat
{
    private static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";
    public static final DateFormat DEFAULT = new SimpleDateFormat(DEFAULT_DATE_FORMAT);
}

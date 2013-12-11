package uk.gov.dvla.services.mib;

import org.joda.time.*;

public class CustodialPeriodCalculator {

    /**
     * Arbitrary date for calculating comparable durations from periods
     */
    public static final DateTime START_DATE = DateTime.parse("2000-01-01");

    public static final Duration TIER_1 = Period.parse("P30M").toDurationFrom(START_DATE);
    public static final Duration TIER_2 = Period.parse("P48M").toDurationFrom(START_DATE);

    public static String calculate(String periodStr) {
        try {
            return calculateSafe(Period.parse(periodStr));
        } catch (Exception e) {
            return null;
        }
    }

    private static String calculateSafe(Period period) {
        Duration duration = period.toDurationFrom(START_DATE);
        if (duration.isLongerThan(TIER_2)) {
            return "3";
        } else if (duration.isLongerThan(TIER_1)) {
            return "2";
        } else if (duration.isLongerThan(Duration.ZERO)) {
            return "1";
        } else {
            return null;
        }
    }
}

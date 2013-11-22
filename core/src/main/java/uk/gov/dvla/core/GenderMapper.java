package uk.gov.dvla.core;

import org.apache.commons.lang3.StringUtils;

public class GenderMapper {
    private static final String MALE = "MALE";
    private static final String FEMALE = "FEMALE";
    private static final String NOT_SPECIFIED = "NOT_SPECIFIED";

    public static int toInt(String genderStr) {
        if (StringUtils.equalsIgnoreCase(genderStr, MALE))
            return 1;
        if (StringUtils.equalsIgnoreCase(genderStr, FEMALE))
            return 2;
        if (StringUtils.equalsIgnoreCase(genderStr, NOT_SPECIFIED))
            return 9;

        throw new IllegalArgumentException("The gender String value assumed was to be MALE or FEMALE. " + genderStr + " provided");
    }

    public static String toString(int genderInt) {
        switch (genderInt) {
            case 1:
                return MALE;
            case 2:
                return FEMALE;
            case 9:
                return NOT_SPECIFIED;
            default:
                throw new IllegalArgumentException("The gender String value assumed was to be 1 for MALE or 2 for FEMALE. " + genderInt + " provided");
        }
    }
}

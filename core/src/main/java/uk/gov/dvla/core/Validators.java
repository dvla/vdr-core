package uk.gov.dvla.core;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Validators {

    private static final String DLN_REGEX = new String("(^([A-Za-z]{1}[9]{4}|[A-Za-z]{2}[9]{3}|[A-Za-z]{3}[9]{2}|[A-Za-z]{4}[9]{1}|[A-Za-z]{5})([0-9]{6})([A-Za-z]{1}9{1}|[A-Za-z]{2})([A-Za-z2-9]{1})([A-Za-z0-9]{2}))");
    private static final String POSTCODE_REGEX = new String("(^[A-Za-z0-9\\s]{5,8})");
    private static final String VRM_REGEX = new String("(^A-Za-z0-9\\s-){1,15}");

    public static final boolean validateDln(final String hex) {
        Pattern pattern = Pattern.compile(DLN_REGEX);
        Matcher matcher = pattern.matcher(hex);
        return matcher.matches();
    }

    public static final boolean validatePostcode(String postcode) {
        Pattern pattern = Pattern.compile(POSTCODE_REGEX);
        Matcher matcher = pattern.matcher(postcode);
        return matcher.matches();
    }

    public static final boolean validateVRM(String vrm) {
        Pattern pattern = Pattern.compile(VRM_REGEX);
        Matcher matcher = pattern.matcher(vrm);
        return matcher.matches();
    }
}
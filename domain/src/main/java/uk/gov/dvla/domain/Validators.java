package uk.gov.dvla.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Validators {

    private static final String DLNRegex = new String("(^([A-Za-z]{1}[9]{4}|[A-Za-z]{2}[9]{3}|[A-Za-z]{3}[9]{2}|[A-Za-z]{4}[9]{1}|[A-Za-z]{5})([0-9]{6})([A-Za-z]{1}9{1}|[A-Za-z]{2})([A-Za-z2-9]{1})([A-Za-z0-9]{2}))");

    public static final boolean validateDln(final String hex) {
        Pattern pattern = Pattern.compile(DLNRegex);
        Matcher matcher = pattern.matcher(hex);
        return matcher.matches();
    }
}
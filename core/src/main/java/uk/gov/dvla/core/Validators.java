package uk.gov.dvla.core;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Validators {

    private static final String DLN_REGEX =
            "^(?=\\w{16}$)[A-Za-z]{1,5}9{0,4}[0-9]{6}[A-Za-z][A-Za-z9][A-Za-z2-9][A-Za-z0-9]{2}";

    private static final Pattern DLN_PATTERN = Pattern.compile(DLN_REGEX);

    public static boolean validateDln(final String hex) {
        Matcher matcher = DLN_PATTERN.matcher(hex);
        return matcher.matches();
    }
}
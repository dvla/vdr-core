package uk.gov.dvla.core;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Validators {
    /*
        The regular expression below is the GDS official regex for matching DLN (info from lmlynik).
        It is not very well written. It unnecessarily uses alternatives and creates redundant capturing groups.
        Consider:
            "^(?=\\w{16}$)[A-Za-z]{1,5}9{0,4}[0-9]{6}[A-Za-z][A-Za-z9][A-Za-z2-9][A-Za-z0-9]{2}"
        which is cleaner, shorter and faster.
     */
    private static final String DLN_REGEX =
            "(^([A-Za-z]{1}[9]{4}|[A-Za-z]{2}[9]{3}|[A-Za-z]{3}[9]{2}|[A-Za-z]{4}[9]{1}|[A-Za-z]{5})([0-9]{6})([A-Za-z]{1}9{1}|[A-Za-z]{2})([A-Za-z2-9]{1})([A-Za-z0-9]{2}))";

    private static final Pattern DLN_PATTERN = Pattern.compile(DLN_REGEX);

    public static boolean validateDln(final String hex) {
        Matcher matcher = DLN_PATTERN.matcher(hex);
        return matcher.matches();
    }
}
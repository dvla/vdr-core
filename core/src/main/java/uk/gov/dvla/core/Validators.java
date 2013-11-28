package uk.gov.dvla.core;

import java.util.regex.Pattern;

public final class Validators {

    public static final String DLN_REGEX = "^(?=.{16}$)[A-Za-z]{1,5}9{0,4}[0-9](?:[05][1-9]|[16][0-2])(?:[0][1-9]|[12][0-9]|3[01])[0-9](?:99|[A-Za-z][A-Za-z9])(?![IOQYZioqyz01_])\\w[A-Za-z]{2}";
    public static final String POSTCODE_REGEX = "^[a-zA-Z0-9](?:\\s*[a-zA-Z0-9]){4,7}$";
    public static final String VRM_REGEX = "^(?:[a-zA-z0-9]){1,15}(?:;(?:[a-zA-z0-9]){1,15})*;?$";
    public static final String GUID_REGEX = "^[A-Fa-f0-9]{8}-[A-Fa-f0-9]{4}-[A-Fa-f0-9]{4}-[A-Fa-f0-9]{4}-[A-Fa-f0-9]{12}$";


    public static final Pattern DLN_PATTERN = Pattern.compile(DLN_REGEX);
    public static final Pattern POSTCODE_PATTERN = Pattern.compile(POSTCODE_REGEX);
    public static final Pattern VRM_PATTERN = Pattern.compile(VRM_REGEX);
    public static final Pattern GUID_PATTERN = Pattern.compile(GUID_REGEX);

    public static boolean validateDln(final String hex) {
        return DLN_PATTERN.matcher(hex).matches();
    }

    public static boolean validatePostcode(String postcode) {
        return POSTCODE_PATTERN.matcher(postcode).matches();
    }

    public static boolean validateVrm(String vrm) {
        return VRM_PATTERN.matcher(vrm.replaceAll("[\\s-]+", "")).matches();
    }

    public static boolean validateGuid(String guid) {
        return GUID_PATTERN.matcher(guid).matches();
    }

    public static boolean validateProposer(String proposer) {
        return proposer.equalsIgnoreCase("P") || proposer.equalsIgnoreCase("N");
    }
}
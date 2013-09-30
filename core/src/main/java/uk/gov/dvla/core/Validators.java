package uk.gov.dvla.core;

import java.util.regex.Pattern;

public final class Validators {

    private static final String DLN_REGEX = "^(?=\\w{16}$)[A-Za-z]{1,5}9{0,4}[0-9]{6}[A-Za-z][A-Za-z9][A-Za-z2-9][A-Za-z0-9]{2}";
    private static final String POSTCODE_REGEX = "^(?:\\s*[a-zA-Z0-9]){5,8}\\s*$";
    private static final String VRM_REGEX = "^(?:[a-zA-z0-9]){1,15}(?:;(?:[a-zA-z0-9]){1,15})*;?$";
    private static final String GUID_REGEX = "^[A-Fa-f0-9]{8}-[A-Fa-f0-9]{4}-[A-Fa-f0-9]{4}-[A-Fa-f0-9]{4}-[A-Fa-f0-9]{12}$";


    private static final Pattern DLN_PATTERN = Pattern.compile(DLN_REGEX);
    private static final Pattern POSTCODE_PATTERN = Pattern.compile(POSTCODE_REGEX);
    private static final Pattern VRM_PATTERN = Pattern.compile(VRM_REGEX);
    private static final Pattern GUID_PATTERN = Pattern.compile(GUID_REGEX);

    public static boolean validateDln(final String hex) {
        return DLN_PATTERN.matcher(hex).matches();
    }

    public static boolean validatePostcode(String postcode) {
        return POSTCODE_PATTERN.matcher(postcode).matches();
    }

    public static boolean validateVrm(String vrm) {
        return VRM_PATTERN.matcher(vrm).matches();
    }

    public static boolean validateGuid(String guid) {
        return GUID_PATTERN.matcher(guid.replaceAll("[\\s-]+", "")).matches();
    }

    public static boolean validateProposerIndicator(String pi) {
        return pi.equalsIgnoreCase("P") || pi.equalsIgnoreCase("N");
    }
}
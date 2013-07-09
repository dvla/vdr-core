package uk.gov.dvla.services.common;

import java.util.List;
import java.util.regex.Pattern;

public class PostcodeHelper {

    /**
     * Checks if a postcode contains any non-alpha characters
     *
     * @param postcodeToCheck The postcode you need to check
     * @return True if actualPostcode contains non-alpha characters
     */
    public static boolean hasSpecialChars(String postcodeToCheck) {
        Pattern p = Pattern.compile("[^a-zA-Z0-9]");
        return p.matcher(cleanPostcode(postcodeToCheck)).find();
    }

    public static boolean postcodeIsBlank(String postcodeToCheck) {
        return (postcodeToCheck.isEmpty() || postcodeToCheck.equals(null));
    }

    /**
     * Checks to see if the postcode on record matches the user submitted postcode
     *
     * @param actualPostcode   The postcode on the driver record
     * @param searchedPostcode The postcode searched for by the user
     * @param dummyPostcodes   A list of dummy postcodes to ignore
     * @return True if the postcodes match, false if they do not or actualPostcode contained a value in dummyPostcodes
     */
    public static boolean postcodeMismatch(String actualPostcode, String searchedPostcode, List<String> dummyPostcodes) {
        Boolean postcodeMismatch = false;
        String cleanSearchPostcode = cleanPostcode(searchedPostcode);
        String cleanActualPostcode = cleanPostcode(actualPostcode);

        if (PostcodeHelper.postcodeIsBlank(cleanActualPostcode)) {
            return false;
        }

        if (PostcodeHelper.hasSpecialChars(cleanActualPostcode)) {
            return false; //Ignore postcode match if it contains non postcode chars
        }

        if (cleanSearchPostcode != null && !cleanSearchPostcode.equals("")) {

            if (!dummyPostcodes.contains(cleanActualPostcode)) {
                if (!cleanSearchPostcode.equalsIgnoreCase(cleanActualPostcode)) {
                    postcodeMismatch = true;
                }
            }
        }
        return postcodeMismatch;
    }

    private static String cleanPostcode(String originalPostcode) {
        return originalPostcode.replace(" ", "");
    }
}

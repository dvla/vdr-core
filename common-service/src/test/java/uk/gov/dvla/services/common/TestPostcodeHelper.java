package uk.gov.dvla.services.common;

import org.junit.Assert;
import org.junit.Test;
import uk.gov.dvla.services.common.PostcodeHelper;

import java.util.Arrays;

public class TestPostcodeHelper {

    @Test
    public void testPostcodeWithSpace() {
        String postcode = "SA1 7NW";

        boolean postcodeMismatch = PostcodeHelper.postcodeMismatch(
                "SA017NW", postcode, Arrays.asList("AA88", "AA89"));

        Assert.assertFalse(postcodeMismatch);
    }
}

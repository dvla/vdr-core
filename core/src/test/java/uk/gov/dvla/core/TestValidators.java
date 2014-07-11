package uk.gov.dvla.core;


import junit.framework.Assert;
import org.junit.Test;

public class TestValidators {

    @Test
    public void testDlnValidators() {
        String validDlns[] = {
                "LEESH702100C99DP", "KITSO802192GT2BD", "T9999812208B99DG",
                "TONY9810121MS2DB", "TYPEO606158A99QQ", "EXXXX811260EA9RE",
                "e9999811260EA9Re", "JAM99711268KA9OP", "LEESH702100999DP" };

        String invalidDlns[] = {
                "LEE999702100C99DP", "KITSO802192GT1BD", "99999812208B99DG",
                "TON9810121MS2DB", "TYPE9O606158A99QQ", "EXXXX81T260EA9RE",
                "e9999811260E89Re", "JAM98711268KA90P", "LEESH762400C99DP",
                "LEESH7021009C9DP", "LEESH702000C99DP" };

        for (String dln : validDlns) {
            Assert.assertTrue(
                    String.format("DLN [%s] incorrectly considered invalid", dln),
                    Validators.validateDln(dln));
        }

        for (String dln : invalidDlns) {
            Assert.assertFalse(
                    String.format("DLN [%s] incorrectly considered valid", dln),
                    Validators.validateDln(dln));
        }
    }
}

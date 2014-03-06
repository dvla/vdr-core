package uk.gov.dvla.services.common.disqualifications;

import static uk.gov.dvla.services.mib.MibDriverTransformService.*;

public enum DisqualificationStatus {
    DISQ_FOR_LIFE("licence.status.disqualified.for.life", MIB_DISQUALIFIED_FOR_LIFE),
    DISQ_UNTIL_SENTENCING("licence.status.disqualified", MIB_DISQUALIFIED_UNTIL_SENTENCED),
    DISQ_UNTIL_DATE("licence.status.disqualified.until.date", MIB_DISQUALIFIED_UNTIL_GIVEN_DATE),
    DISQ_TEST_PASS("licence.status.disqualified.reapply", MIB_DISQUALIFIED_UNTIL_TEST_PASS),
    DISQ_TEST_PASS_GB("licence.status.disqualified.reapply.gb", null),
    DISQ_PAST_DATE_REAPPLY_FULL("licence.status.not.disqualified.reapply.with.date", MIB_EXPIRED_FULL_LICENCE),
    DISQ_PAST_DATE_REAPPLY_PROV("licence.status.not.disqualified.reapply.with.date", MIB_EXPIRED_PROV_LICENCE),
    DISQ_PAST_DATE("licence.status.not.disqualified", null),
    DISQ_PAST_DATE_REAPPLY_GB("licence.status.disqualification.expired.without.renewal", null),
    REVOKED_TEST_PASS("licence.status.revoked.reapply", MIB_REVOKED_UNTIL_TEST_PASS),
    REVOKED_FULL("licence.status.revoked", MIB_EXPIRED_FULL_LICENCE),
    REVOKED_PROV("licence.status.revoked", MIB_EXPIRED_PROV_LICENCE);

    final public String portalBanner;

    /**
     * if null it means such record won't be released to the MIB (as covered by other rules)
     */
    final public String mibCode;

    private DisqualificationStatus(String portalBanner, String mibCode) {
        this.portalBanner = portalBanner;
        this.mibCode = mibCode;
    }
}

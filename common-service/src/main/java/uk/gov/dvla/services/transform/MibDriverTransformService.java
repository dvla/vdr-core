package uk.gov.dvla.services.transform;

import uk.gov.dvla.domain.*;
import uk.gov.dvla.domain.mib.EntitlementType;
import uk.gov.dvla.domain.mib.MibDTO;

import java.util.*;

public class MibDriverTransformService implements TransformService<RulesDriver, MibDTO> {

    private static final String MIB_CURRENT_FULL_LICENCE = "FC";
    private static final String MIB_CURRENT_PROV_LICENCE = "PC";
    private static final String MIB_EXPIRED_FULL_LICENCE = "FE";
    private static final String MIB_EXPIRED_PROV_LICENCE = "PE";
    private static final String MIB_DISQUALIFIED_LICENCE = "DQ";
    private static final String MIB_DISQUALIFIED_UNTIL_GIVEN_DATE = "DD";
    private static final String MIB_DISQUALIFIED_UNTIL_TEST_PASS = "DT";
    private static final String MIB_DISQUALIFIED_UNTIL_GIVEN_DATE_AND_TEST_PASS = "DP";
    private static final String MIB_DISQUALIFIED_UNTIL_SENTENCED = "DS";
    private static final String MIB_DISQUALIFIED_FOR_LIFE = "DX";
    private static final String MIB_REVOKED_UNTIL_TEST_PASS = "RV";

    private static final String LICENCE_STATUS_A = "A";
    private static final String LICENCE_STATUS_B = "B";
    private static final String LICENCE_STATUS_E = "E";
    private static final String LICENCE_STATUS_F = "F";
    private static final String LICENCE_STATUS_G = "G";
    private static final String LICENCE_STATUS_M = "M";
    private static final String LICENCE_STATUS_O = "O";
    private static final String LICENCE_STATUS_Q = "Q";
    private static final String LICENCE_STATUS_S = "S";

    private static final String DISQUALIFIED_FOR_LIFE = "licence.status.disqualified.for.life";
    private static final String DISQUALIFIED_REAPPLY_WITH_DATE = "licence.status.disqualified.reapply.with.date";
    private static final String DISQUALIFICATION_EXPIRED_REAPPLY_WITH_DATE =
            "licence.status.not.disqualified.reapply.with.date";
    private static final String DISQUALIFIED_UNTIL_DATE = "licence.status.disqualified.until.date";
    private static final String REVOKED_REAPPLY = "licence.status.revoked.reapply";
    private static final String REVOKED = "licence.status.revoked";
    private static final String DISQUALIFIED_UNTIL_SENTENCING = "licence.status.disqualified.until.sentencing";
    private static final String DISQUALIFIED = "licence.status.disqualified";
    private static final String DISQUALIFIED_REAPPLY  = "licence.status.disqualified.reapply";


    @Override
    public MibDTO transform(RulesDriver result) {
        MibDTO mibDTO = new MibDTO();

        Driver driver = result.getDriver();
        Licence licence = driver.getLicence();

        if(null != licence)
        {
            mibDTO.setLicence(getLicence(licence));
            MibDTO.Licence mibLicence = mibDTO.getLicence();
            mibLicence.setStatus(getStatus(result));
            mibLicence.setEntitlements(getEntitlements(driver));
            mibLicence.setEndorsements(getEndorsements(driver));
        }
        return mibDTO;
    }

    private MibDTO.Licence getLicence(Licence licence) {

        MibDTO.Licence mibLicence = new MibDTO.Licence();
        mibLicence.setValidFrom(licence.getValidFrom());
        mibLicence.setValidTo(licence.getValidTo());
        mibLicence.setDirectiveIndicator(licence.getDirectiveStatus());
        return mibLicence;
    }

    private List<MibDTO.Entitlement> getEntitlements(Driver driver) {
        Licence licence = driver.getLicence();
        List<MibDTO.Entitlement> entitlements = new ArrayList<MibDTO.Entitlement>();
        if (licence.getEntitlements() == null) return entitlements;

        for (Entitlement ent : licence.getEntitlements()) {
            MibDTO.Entitlement mibEntitlement = new MibDTO.Entitlement();
            TestPass testPass = driver.getTestPassForEntitlement(ent);
            mibEntitlement.setCode(ent.getCode());
            mibEntitlement.setValidFrom(getValidFrom(ent, testPass));
            mibEntitlement.setValidTo(getValidTo(ent, testPass));
            mibEntitlement.setPriorTo(ent.getPriorTo());
            mibEntitlement.setType(getEntitlementType(ent, testPass));
            mibEntitlement.setRestrictions(getEntitlementRestrictions(ent));
            
            entitlements.add(mibEntitlement);
        }
        return entitlements;
    }

    private List<MibDTO.Endorsement> getEndorsements(Driver driver) {
        List<MibDTO.Endorsement> endorsements = new ArrayList<MibDTO.Endorsement>();
        if (driver.getLicence().getEndorsements() == null) return endorsements;

        for (Endorsement end : driver.getLicence().getEndorsements()) {
            MibDTO.Endorsement mibEndorsement = new MibDTO.Endorsement();
            mibEndorsement.setCode(end.getCode());
            mibEndorsement.setOffenceDate(end.getOffence());
            mibEndorsement.setConvictionDate(end.getConviction());
            mibEndorsement.setFine(end.getFine());
            mibEndorsement.setNoOfPoints(end.getNoPoints());
            mibEndorsement.setIsDisqual(end.getDisqual());
            mibEndorsement.setDisqualPeriod(end.getDuration());
            // TODO: this logic needs to be updated once we confirm what disqual should be returned
            if (driver.getDisqualifications() != null) {
                for (Disqualification disq : driver.getDisqualifications()) {
                    if (disq.getEndorsementID() == end.getId()) {
                        mibEndorsement.setDisqualStartDate(disq.getDisqFromDate());
                        mibEndorsement.setDisqualEndDate(disq.getDisqToDate());
                    }
                }
            }
            // TODO: rehab spent date will be updated as part of US276
            mibEndorsement.setRehabSpentDate(new Date());
            endorsements.add(mibEndorsement);
        }

        return endorsements;
    }

    private EntitlementType getEntitlementType(Entitlement ent, TestPass testPass) {
        EntitlementType entitlementType = EntitlementType.Full;
        if(ent.getProvisional() != null && ent.getProvisional())
        {
            entitlementType = EntitlementType.Provisional;
            if(testPass != null
                    && testPass.getStatusType().equals(TestPassStatus.NotYetClaimed.getTestPassStatus())
                    && testPass.getExpiryDate().after(new Date()))
            {
                entitlementType = EntitlementType.UnclaimedTestPass;
            }
        }
        return entitlementType;
    }

    private List<MibDTO.EntitlementRestriction> getEntitlementRestrictions(Entitlement ent) {

        List<MibDTO.EntitlementRestriction> restrictions = new ArrayList<MibDTO.EntitlementRestriction>();

        if (ent.getRestrictions() != null) {
            for (EntitlementRestriction er : ent.getRestrictions()) {
                restrictions.add(new MibDTO.EntitlementRestriction(er.getCode(), er.getCategoryCode()));
            }
        }

        return restrictions;
    }

    private Date getValidFrom(Entitlement entitlement, TestPass testPass) {
        Date validFrom = entitlement.getValidFrom();
        if (entitlement.getProvisional() != null && entitlement.getProvisional() && testPass != null
                && testPass.getStatusType().equals(TestPassStatus.NotYetClaimed.getTestPassStatus())
                && testPass.getExpiryDate().after(new Date())) {
            validFrom = testPass.getTestPassDate();
        }

        return validFrom;
    }

    private Date getValidTo(Entitlement entitlement, TestPass testPass) {
        Date validTo = entitlement.getValidTo();
        Date expiryDate = null;
        if(testPass != null
                && testPass.getStatusType().equals(TestPassStatus.NotYetClaimed.getTestPassStatus())
                && testPass.getExpiryDate().after(new Date()))
        {
            expiryDate = testPass.getExpiryDate();
        }

        return (expiryDate == null) ? validTo : expiryDate;
    }

    private String getStatus(RulesDriver rulesDriver) {

        String mibLicenceStatusCode = null;
        if (rulesDriver.getDriver().getStatus() != null && rulesDriver.getDriver().getStatus().getCode() != null) {
            String code = rulesDriver.getDriver().getStatus().getCode();

            if (code.equalsIgnoreCase(LICENCE_STATUS_A)) {
                mibLicenceStatusCode = MIB_CURRENT_PROV_LICENCE;
            }
            else if (code.equalsIgnoreCase(LICENCE_STATUS_B)) {
                mibLicenceStatusCode = MIB_EXPIRED_PROV_LICENCE;
            }
            else if (code.equalsIgnoreCase(LICENCE_STATUS_E)) {
                mibLicenceStatusCode = MIB_DISQUALIFIED_LICENCE;
            }
            else if (code.equalsIgnoreCase(LICENCE_STATUS_F)) {
                mibLicenceStatusCode = MIB_CURRENT_FULL_LICENCE;
            }
            else if (code.equalsIgnoreCase(LICENCE_STATUS_G)) {
                mibLicenceStatusCode = MIB_EXPIRED_FULL_LICENCE;
            }
            else if (code.equalsIgnoreCase(LICENCE_STATUS_M)) {
                // TODO: find out what status should be returned to the MIB
                mibLicenceStatusCode = LICENCE_STATUS_M;
            }
            else if (code.equalsIgnoreCase(LICENCE_STATUS_O)) {
                // TODO: find out what status should be returned to the MIB
                mibLicenceStatusCode = LICENCE_STATUS_O;
            }
            else if (code.equalsIgnoreCase(LICENCE_STATUS_Q)) {
                // TODO: find out what status should be returned to the MIB
                mibLicenceStatusCode = LICENCE_STATUS_Q;
            }
            else if (code.equalsIgnoreCase(LICENCE_STATUS_S)) {
                // TODO: find out what status should be returned to the MIB
                mibLicenceStatusCode = LICENCE_STATUS_S;
            }
        }
        // Now check if there are any messages returned from the rules
        String disqualificationStatus = checkDisqualifications(rulesDriver.getMessages());
        if (disqualificationStatus != null) {
            mibLicenceStatusCode = disqualificationStatus;
        }
        return mibLicenceStatusCode;
    }

    private String checkDisqualifications(List<Message> messages) {
        if (messages != null) {
            for (Message m : messages) {
                if (m.getKey().equalsIgnoreCase(DISQUALIFIED_FOR_LIFE)) {
                    return MIB_DISQUALIFIED_FOR_LIFE;
                }
                else if (m.getKey().equalsIgnoreCase(DISQUALIFIED_REAPPLY_WITH_DATE)
                        || m.getKey().equalsIgnoreCase(DISQUALIFICATION_EXPIRED_REAPPLY_WITH_DATE)) {
                    return MIB_DISQUALIFIED_UNTIL_GIVEN_DATE_AND_TEST_PASS;
                }
                else if (m.getKey().equalsIgnoreCase(DISQUALIFIED_UNTIL_DATE)) {
                    return MIB_DISQUALIFIED_UNTIL_GIVEN_DATE;
                }
                else if (m.getKey().equalsIgnoreCase(REVOKED_REAPPLY)
                        || m.getKey().equalsIgnoreCase(REVOKED)) {
                    // TODO: Revoked will be removed from this list and set to a specific status - future user story
                    return MIB_REVOKED_UNTIL_TEST_PASS;
                }
                else if (m.getKey().equalsIgnoreCase(DISQUALIFIED_UNTIL_SENTENCING)) {
                    return MIB_DISQUALIFIED_UNTIL_SENTENCED;
                }
                else if (m.getKey().equalsIgnoreCase(DISQUALIFIED)) {
                    return MIB_DISQUALIFIED_LICENCE;
                }
                else if (m.getKey().equalsIgnoreCase(DISQUALIFIED_REAPPLY)) {
                    return MIB_DISQUALIFIED_UNTIL_TEST_PASS;
                }
            }
        }
        return null;
    }
}

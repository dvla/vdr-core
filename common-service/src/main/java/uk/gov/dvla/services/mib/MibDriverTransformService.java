package uk.gov.dvla.services.mib;

import uk.gov.dvla.domain.*;
import uk.gov.dvla.domain.mib.EntitlementType;
import uk.gov.dvla.domain.mib.MibDTO;
import uk.gov.dvla.services.common.disqualifications.DisqualificationStatus;
import uk.gov.dvla.services.transform.TransformService;

import java.util.*;

public class MibDriverTransformService implements TransformService<RulesDriver, MibDTO> {

    public static final String MIB_CURRENT_FULL_LICENCE = "FC";
    public static final String MIB_CURRENT_PROV_LICENCE = "PC";
    public static final String MIB_EXPIRED_FULL_LICENCE = "FE";
    public static final String MIB_EXPIRED_PROV_LICENCE = "PE";
    public static final String MIB_DISQUALIFIED_LICENCE = "DQ";
    public static final String MIB_SURRENDERED_PROV_LICENCE = "PS";
    public static final String MIB_SURRENDERED_FULL_LICENCE = "FS";
    public static final String MIB_DISQUALIFIED_UNTIL_GIVEN_DATE = "DD";
    public static final String MIB_DISQUALIFIED_UNTIL_TEST_PASS = "DT";
    //What about this one?
    public static final String MIB_DISQUALIFIED_UNTIL_GIVEN_DATE_AND_TEST_PASS = "DP";
    public static final String MIB_DISQUALIFIED_UNTIL_SENTENCED = "DS";
    public static final String MIB_DISQUALIFIED_FOR_LIFE = "DX";
    public static final String MIB_REVOKED_UNTIL_TEST_PASS = "RV";
    public static final String MIB_NO_CURRENT_GB_LICENCE_HELP = "NE";

    private static final String LICENCE_STATUS_A = "A";
    private static final String LICENCE_STATUS_B = "B";
    private static final String LICENCE_STATUS_E = "E";
    private static final String LICENCE_STATUS_F = "F";
    private static final String LICENCE_STATUS_G = "G";
    private static final String LICENCE_STATUS_M = "M";
    private static final String LICENCE_STATUS_O = "O";
    private static final String LICENCE_STATUS_Q = "Q";
    private static final String LICENCE_STATUS_S = "S";


    @Override
    public MibDTO transform(RulesDriver result) {
        MibDTO mibDTO = new MibDTO();

        Driver driver = result.getDriver();
        Licence licence = driver.getLicence();

        if (null != licence) {
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

            mibEndorsement.setCustodialPeriod(end.getCustodialPeriod());
            mibEndorsement.setIndicativeRehabilitationSpentDate(end.getIndicativeRehabSpentDate());
            if (driver.getDisqualifications() != null) {
                for (Disqualification disq : driver.getDisqualifications()) {
                    if (end.getId().equals(disq.getEndorsementID())) {
                        mibEndorsement.setDisqualStartDate(disq.getDisqFromDate());
                        mibEndorsement.setDisqualEndDate(disq.getDisqToDate());
                    }
                }
            }
            endorsements.add(mibEndorsement);
        }

        return endorsements;
    }

    private EntitlementType getEntitlementType(Entitlement ent, TestPass testPass) {
        EntitlementType entitlementType = EntitlementType.Full;
        if (ent.getProvisional() != null && ent.getProvisional()) {
            entitlementType = EntitlementType.Provisional;
            if (testPass != null
                    && testPass.getStatusType().equals(TestPassStatus.NotYetClaimed.getTestPassStatus())
                    && testPass.getExpiryDate().after(new Date())) {
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
        if (testPass != null
                && testPass.getStatusType().equals(TestPassStatus.NotYetClaimed.getTestPassStatus())
                && testPass.getExpiryDate().after(new Date())) {
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
            } else if (code.equalsIgnoreCase(LICENCE_STATUS_B)) {
                mibLicenceStatusCode = MIB_EXPIRED_PROV_LICENCE;
            } else if (code.equalsIgnoreCase(LICENCE_STATUS_E)) {
                mibLicenceStatusCode = MIB_DISQUALIFIED_LICENCE;
            } else if (code.equalsIgnoreCase(LICENCE_STATUS_F)) {
                mibLicenceStatusCode = MIB_CURRENT_FULL_LICENCE;
            } else if (code.equalsIgnoreCase(LICENCE_STATUS_G)) {
                mibLicenceStatusCode = MIB_EXPIRED_FULL_LICENCE;
            } else if (code.equalsIgnoreCase(LICENCE_STATUS_M)) {
                mibLicenceStatusCode = MIB_NO_CURRENT_GB_LICENCE_HELP;
            } else if (code.equalsIgnoreCase(LICENCE_STATUS_O)) {
                mibLicenceStatusCode = MIB_SURRENDERED_PROV_LICENCE;
            } else if (code.equalsIgnoreCase(LICENCE_STATUS_Q)) {
                mibLicenceStatusCode = MIB_NO_CURRENT_GB_LICENCE_HELP;
            } else if (code.equalsIgnoreCase(LICENCE_STATUS_S)) {
                mibLicenceStatusCode = MIB_SURRENDERED_FULL_LICENCE;
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
                if (m.getExtra() instanceof DisqualificationStatus) {
                    return ((DisqualificationStatus) m.getExtra()).mibCode;
                }
            }
        }
        return null;
    }
}

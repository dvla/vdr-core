package uk.gov.dvla.services.transform;

import uk.gov.dvla.domain.*;
import uk.gov.dvla.domain.mib.EntitlementType;
import uk.gov.dvla.domain.mib.MibDTO;

import java.util.*;

public class MibDriverTransformService implements TransformService<ServiceResult<Driver>, MibDTO> {

    @Override
    public MibDTO transform(ServiceResult<Driver> result) {
        MibDTO mibDTO = new MibDTO();
        MibDTO.Driver mibDriver = new MibDTO.Driver();
        mibDTO.setDriver(mibDriver);

        Driver driver = result.getResult();
        Licence licence = driver.getLicence();

        if(null != licence)
        {
            mibDriver.setLicence(getLicence(licence));
            MibDTO.Licence mibLicence = mibDriver.getLicence();
            mibLicence.setStatus(getStatus(driver, result.getMessages()));
            mibLicence.setEntitlements(getEntitlements(driver));
            mibLicence.setEndorsements(getEndorsements(licence));
        }
        return mibDTO;
    }

    private MibDTO.Licence getLicence(Licence licence) {

        MibDTO.Licence mibLicence = new MibDTO.Licence();
        mibLicence.setValidFrom(licence.getValidFrom());
        mibLicence.setValidTo(licence.getValidTo());
        mibLicence.setDirectiveStatus(licence.getDirectiveStatus());

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

    private List<MibDTO.Endorsement> getEndorsements(Licence licence) {
        List<MibDTO.Endorsement> endorsements = new ArrayList<MibDTO.Endorsement>();
        if (licence.getEndorsements() == null) return endorsements;

        for (Endorsement end : licence.getEndorsements()) {
            MibDTO.Endorsement mibEndorsement = new MibDTO.Endorsement();
            mibEndorsement.setCode(end.getCode());
            mibEndorsement.setOffenceDate(end.getOffence());
            mibEndorsement.setConvictionDate(end.getConviction());
            mibEndorsement.setFine(end.getFine());
            mibEndorsement.setNoOfPoints(end.getNoPoints());
            mibEndorsement.setIsDisqual(end.getDisqual());
            mibEndorsement.setDisqualPeriod(end.getDuration());
            // TODO: Disqual start date
            // TODO: Disqual end date
            // TODO: rehab spent date

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

    private String getStatus(Driver driver, List<String> messages) {
        String mibLicenceStatusCode = null;
        if (driver.getStatus() != null && driver.getStatus().getCode() != null) {
            String code = driver.getStatus().getCode();

            if (code.equalsIgnoreCase("A")) {
                mibLicenceStatusCode = "PC";
            }
            else if (code.equalsIgnoreCase("B")) {
                mibLicenceStatusCode = "PE";
            }
            else if (code.equalsIgnoreCase("E")) {
                mibLicenceStatusCode = "DQ";
            }
            else if (code.equalsIgnoreCase("F")) {
                mibLicenceStatusCode = "FC";
            }
            else if (code.equalsIgnoreCase("G")) {
                mibLicenceStatusCode = "FE";
            }
            else if (code.equalsIgnoreCase("M")) {
                // TODO: find out what status should be returned to the MIB
                mibLicenceStatusCode = "M";
            }
            else if (code.equalsIgnoreCase("O")) {
                // TODO: find out what status should be returned to the MIB
                mibLicenceStatusCode = "O";
            }
            else if (code.equalsIgnoreCase("Q")) {
                // TODO: find out what status should be returned to the MIB
                mibLicenceStatusCode = "Q";
            }
            else if (code.equalsIgnoreCase("S")) {
                // TODO: find out what status should be returned to the MIB
                mibLicenceStatusCode = "S";
            }
            // Now check if there are any messages returned from the rules
            String disqualificationStatus = checkDisqualifications(messages);
            if (disqualificationStatus != null) {
                mibLicenceStatusCode = disqualificationStatus;
            }
        }
        return mibLicenceStatusCode;
    }

    private String checkDisqualifications(List<String> messages) {
        if (messages != null) {
            for (String m : messages) {
                if (m.equalsIgnoreCase(Message.DISQUALIFIED_FOR_LIFE)) {
                    return "DX";
                }
                else if (m.equalsIgnoreCase(Message.DISQUALIFIED_REAPPLY_WITH_DATE)
                        || m.equalsIgnoreCase(Message.NOT_DISQUALIFIED_UNTIL_DATE)) {
                    return "DP";
                }
                else if (m.equalsIgnoreCase(Message.DISQUALIFIED_UNTIL_DATE)) {
                    return "DD";
                }
                else if (m.equalsIgnoreCase(Message.REVOKED_REAPPLY_FOR_LICENCE)
                        || m.equalsIgnoreCase(Message.LICENCE_REVOKED)) {
                    return "RV";
                }
                else if (m.equalsIgnoreCase(Message.DISQUALIFIED_UNTIL_SENTENCING)) {
                    return "DS";
                }
                else if (m.equals(Message.DISQUALIFIED)) {
                    return "DQ";
                }
            }
        }
        return null;
    }
}

package uk.gov.dvla.services.transform;


import uk.gov.dvla.domain.Driver;
import uk.gov.dvla.domain.Endorsement;
import uk.gov.dvla.domain.Entitlement;
import uk.gov.dvla.domain.EntitlementRestriction;
import uk.gov.dvla.domain.Licence;
import uk.gov.dvla.domain.ServiceResult;
import uk.gov.dvla.domain.TestPass;
import uk.gov.dvla.domain.TestPassStatus;
import uk.gov.dvla.domain.mib.EntitlementType;
import uk.gov.dvla.domain.mib.MibDTO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PortalDriverTransformService implements TransformService<ServiceResult<Driver>, ServiceResult<MibDTO>> {

    @Override
    public ServiceResult<MibDTO> transform(ServiceResult<Driver> objectToTransform) {
        MibDTO mibDTO = new MibDTO();
        MibDTO.Driver mibDriver = new MibDTO.Driver();
        mibDTO.setDriver(mibDriver);

        Driver driver = objectToTransform.getResult();

        Licence licence = driver.getLicence();

        if (null != licence) {
            mibDriver.setLicence(getLicence(licence));
            MibDTO.Licence mibLicence = mibDriver.getLicence();
            mibLicence.setEntitlements(getEntitlements(driver));
            mibLicence.setEndorsements(getEndorsements(licence));
        }

        return new ServiceResult<MibDTO>(objectToTransform.getEnquiryId(), mibDTO, objectToTransform.getMessages());
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
        List<TestPass> testPasses = driver.getTestPasses();
        List<MibDTO.Entitlement> entitlements = new ArrayList<MibDTO.Entitlement>();
        if (licence.getEntitlements() == null) return entitlements;

        for (Entitlement ent : licence.getEntitlements()) {
            MibDTO.Entitlement mibEntitlement = new MibDTO.Entitlement();
            TestPass testPass = driver.getTestPassForEntitlement(ent);
            mibEntitlement.setCode(ent.getCode());
            mibEntitlement.setValidFrom(getValidFrom(ent, testPass));
            mibEntitlement.setValidTo(getValidTo(ent, testPass));
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
            mibEndorsement.setSentencingDate(end.getSentencing());
            mibEndorsement.setFine(end.getFine());
            mibEndorsement.setNoOfPoints(end.getNoPoints());
            mibEndorsement.setIsDisqual(end.getDisqual());
            mibEndorsement.setDisqualPeriod(end.getDuration());

            endorsements.add(mibEndorsement);
        }

        return endorsements;
    }

    private EntitlementType getEntitlementType(Entitlement ent, TestPass testPass) {
        EntitlementType entitlementType = EntitlementType.Full;
        if (ent.getProvisional()) {
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

        if (entitlement.getProvisional() && testPass != null
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
}


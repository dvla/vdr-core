package uk.gov.dvla.services.transform;

import uk.gov.dvla.domain.*;
import uk.gov.dvla.domain.mib.EntitlementType;
import uk.gov.dvla.domain.portal.PortalDTO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PortalDriverTransformService implements TransformService<ServiceResult<Driver>, ServiceResult<PortalDTO>> {

    @Override
    public ServiceResult<PortalDTO> transform(ServiceResult<Driver> objectToTransform) {
        PortalDTO portalDTO = new PortalDTO();
        PortalDTO.Driver portalDriver = new PortalDTO.Driver();
        portalDTO.setDriver(portalDriver);

        Driver driver = objectToTransform.getResult();

        Licence licence = driver.getLicence();

        if (null != licence) {
            portalDriver.setLicence(getLicence(licence));
            PortalDTO.Licence portalLicence = portalDriver.getLicence();
            portalLicence.setEntitlements(getEntitlements(driver));
            portalLicence.setEndorsements(getEndorsements(licence));
        }

        return new ServiceResult<PortalDTO>(objectToTransform.getEnquiryId(), portalDTO, objectToTransform.getMessages());
    }

    private PortalDTO.Licence getLicence(Licence licence) {

        PortalDTO.Licence portalLicence = new PortalDTO.Licence();
        portalLicence.setCurrentIssueNum(licence.getCurrentIssueNum());
        portalLicence.setValidFrom(licence.getValidFrom());
        portalLicence.setValidTo(licence.getValidTo());
        portalLicence.setDirectiveStatus(licence.getDirectiveStatus());
        portalLicence.setPhotoExpiryDate(licence.getPhotoExpiryDate());
        return portalLicence;
    }

    private List<PortalDTO.Entitlement> getEntitlements(Driver driver) {
        Licence licence = driver.getLicence();
        List<TestPass> testPasses = driver.getTestPasses();
        List<PortalDTO.Entitlement> entitlements = new ArrayList<PortalDTO.Entitlement>();
        if (licence.getEntitlements() == null) return entitlements;

        for (Entitlement ent : licence.getEntitlements()) {
            PortalDTO.Entitlement portalEntitlement = new PortalDTO.Entitlement();
            TestPass testPass = driver.getTestPassForEntitlement(ent);
            portalEntitlement.setCode(ent.getCode());
            portalEntitlement.setValidFrom(getValidFrom(ent, testPass));
            portalEntitlement.setValidTo(getValidTo(ent, testPass));
            portalEntitlement.setProvisional(ent.getProvisional());
            portalEntitlement.setPriorTo(ent.getPriorTo());
            portalEntitlement.setRestrictions(getEntitlementRestrictions(ent));
            portalEntitlement.setVocational(ent.getVocational());
            entitlements.add(portalEntitlement);
        }

        return entitlements;
    }

    private List<PortalDTO.Endorsement> getEndorsements(Licence licence) {
        List<PortalDTO.Endorsement> endorsements = new ArrayList<PortalDTO.Endorsement>();
        if (licence.getEndorsements() == null) return endorsements;

        for (PortalDTO.Endorsement end : licence.getEndorsements()) {
            PortalDTO.Endorsement portalEndorsement = new PortalDTO.Endorsement();
            portalEndorsement.setId(end.getId());
            portalEndorsement.setDisqual(end.getDisqual());
            portalEndorsement.setCode(end.getCode());
            portalEndorsement.setOffence(end.getOffence());
            portalEndorsement.setExpires(end.getExpires());
            portalEndorsement.setRemoved(end.getRemoved());
            portalEndorsement.setConviction(end.getConviction());
            portalEndorsement.setSentencing(end.getSentencing());
            portalEndorsement.setDuration(end.getDuration());
            portalEndorsement.setFine(end.getFine());
            portalEndorsement.setNoPoints(end.getNoPoints());
            portalEndorsement.setOtherSentence(end.getOtherSentence());
            endorsements.add(portalEndorsement);
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

    private List<PortalDTO.EntitlementRestriction> getEntitlementRestrictions(Entitlement ent) {

        List<PortalDTO.EntitlementRestriction> restrictions = new ArrayList<PortalDTO.EntitlementRestriction>();

        if (ent.getRestrictions() != null) {
            for (EntitlementRestriction er : ent.getRestrictions()) {
                restrictions.add(new PortalDTO.EntitlementRestriction(er.getCode(), er.getCategoryCode()));
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


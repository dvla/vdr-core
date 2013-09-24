package uk.gov.dvla.services.transform;

import uk.gov.dvla.domain.*;
import uk.gov.dvla.domain.portal.PortalDTO;

import java.util.*;

public class PortalDriverTransformService implements TransformService<RulesDriver, PortalDTO> {

    @Override
    public PortalDTO transform(RulesDriver objectToTransform) {
        PortalDTO portalDTO = new PortalDTO();
        Driver driver = objectToTransform.getDriver();

        if (null != driver) {
            PortalDTO.Driver portalDriver = new PortalDTO.Driver();
            Licence licence = driver.getLicence();
            portalDriver.setName(getName(driver.getName()));
            portalDriver.setAddress(getAddress(driver.getAddress()));
            portalDriver.setBirthDetails(getBirthDetails(driver.getBirthDetails()));
            portalDriver.setStatus(getStatus(driver.getStatus()));
            portalDriver.setDriverStatedFlags(getDriverStatedFlags(driver));
            portalDriver.setFlags(getFlags(driver));
            portalDriver.setCurrentDriverNumber(driver.getCurrentDriverNumber());
            portalDriver.setGender(driver.getGender());
            portalDriver.setDisqualifiedUntilDate(driver.getDisqualifiedUntilDate());
            portalDriver.setTestPasses(getTestPasses(driver));
            portalDriver.setDisqualifications(getDisqualifications(driver));

            if (null != licence) {
                portalDriver.setLicence(getLicence(licence));
                PortalDTO.Licence portalLicence = portalDriver.getLicence();
                portalLicence.setEntitlements(getEntitlements(driver));
                portalLicence.setEndorsements(getEndorsements(licence));
            }
            portalDTO.setDriver(portalDriver);
        }
        return portalDTO;
    }

    private PortalDTO.Name getName(Name name) {

        PortalDTO.Name portalName = new PortalDTO.Name();
        if (name == null) {
            return portalName;
        }

        portalName.setTitle(name.getTitle());
        portalName.setGivenName(name.getGivenName());
        portalName.setFamilyName(name.getFamilyName());
        return portalName;
    }

    private PortalDTO.Address getAddress(Address address) {

        PortalDTO.Address portalAddress = new PortalDTO.Address();
        if (address == null) {
            return portalAddress;
        }

        portalAddress.setBuildingName(address.getBuildingName());
        portalAddress.setDdtfare(address.getDdtfare());
        portalAddress.setPostTown(address.getPostTown());
        portalAddress.setPostCode(address.getPostCode());
        portalAddress.setType(address.getType());
        portalAddress.setuPostCode(address.getuPostCode());
        portalAddress.setuLine(address.getuLine());
        return portalAddress;
    }

    private PortalDTO.BirthDetails getBirthDetails(BirthDetails birthDetails) {

        PortalDTO.BirthDetails portalBirthDetails = new PortalDTO.BirthDetails();
        if (birthDetails == null) {
            return portalBirthDetails;
        }
        portalBirthDetails.setDate(birthDetails.getDate());
        return portalBirthDetails;
    }

    private PortalDTO.DriverStatus getStatus(DriverStatus driverStatus) {

        PortalDTO.DriverStatus portalDriverStatus = new PortalDTO.DriverStatus();
        if (driverStatus == null) {
            return portalDriverStatus;
        }
        portalDriverStatus.setCode(driverStatus.getCode());
        return portalDriverStatus;
    }

    private PortalDTO.DriverStatedFlags getDriverStatedFlags(Driver driver) {
        PortalDTO.DriverStatedFlags portalDriverStatedFlags = new PortalDTO.DriverStatedFlags();

        if (driver.getDriverStatedFlags() == null) {
            return portalDriverStatedFlags;
        }

        portalDriverStatedFlags.setExcessEndorsements(driver.getDriverStatedFlags().getExcessEndorsements());
        return portalDriverStatedFlags;
    }

    private List<PortalDTO.DriverFlag> getFlags(Driver driver) {
        List<PortalDTO.DriverFlag> flags = new ArrayList<PortalDTO.DriverFlag>();

        if (driver.getFlags() == null) {
            return flags;
        }
        for (DriverFlag flag : driver.getFlags()) {
            PortalDTO.DriverFlag portalDriverFlag = new PortalDTO.DriverFlag();
            portalDriverFlag.setFlag(flag.getFlag());
            portalDriverFlag.setManual(flag.isManual());
            portalDriverFlag.setCaseType(flag.isCaseType());
            flags.add(portalDriverFlag);
        }
        return flags;
    }

    private PortalDTO.Licence getLicence(Licence licence) {

        PortalDTO.Licence portalLicence = new PortalDTO.Licence();
        if (licence == null) {
            return portalLicence;
        }
        portalLicence.setCurrentIssueNum(licence.getCurrentIssueNum());
        portalLicence.setValidFrom(licence.getValidFrom());
        portalLicence.setValidTo(licence.getValidTo());
        portalLicence.setDirectiveStatus(licence.getDirectiveStatus());
        portalLicence.setPhotoExpiryDate(licence.getPhotoExpiryDate());
        return portalLicence;
    }

    private List<PortalDTO.Entitlement> getEntitlements(Driver driver) {
        Licence licence = driver.getLicence();

        List<PortalDTO.Entitlement> entitlements = new ArrayList<PortalDTO.Entitlement>();
        if (licence.getEntitlements() == null) {
            return entitlements;
        }

        for (Entitlement ent : licence.getEntitlements()) {
            PortalDTO.Entitlement portalEntitlement = new PortalDTO.Entitlement();
            portalEntitlement.setCode(ent.getCode());
            portalEntitlement.setValidFrom(ent.getValidFrom());
            portalEntitlement.setValidTo(ent.getValidTo());
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
        if (licence.getEndorsements() == null) {
            return endorsements;
        }

        for (Endorsement end : licence.getEndorsements()) {
            PortalDTO.Endorsement portalEndorsement = new PortalDTO.Endorsement();
            portalEndorsement.setId(end.getId());
            portalEndorsement.setDisqual(end.getDisqual());
            portalEndorsement.setCode(end.getCode());
            portalEndorsement.setConvictingCourt(end.getConvictingCourt());
            portalEndorsement.setOffence(end.getOffence());
            portalEndorsement.setExpires(end.getExpires());
            portalEndorsement.setRemoved(end.getRemoved());
            portalEndorsement.setConviction(end.getConviction());
            portalEndorsement.setSentencing(end.getSentencing());
            portalEndorsement.setDuration(end.getDuration());
            portalEndorsement.setFine(end.getFine());
            portalEndorsement.setNoPoints(end.getNoPoints());
            if (end.getOtherSentence() == null) {
                portalEndorsement.setOtherSentence(new OtherSentence());
            } else {
                portalEndorsement.setOtherSentence(end.getOtherSentence());
            }

            endorsements.add(portalEndorsement);
        }

        return endorsements;
    }

    private List<PortalDTO.EntitlementRestriction> getEntitlementRestrictions(Entitlement ent) {

        List<PortalDTO.EntitlementRestriction> restrictions = new ArrayList<PortalDTO.EntitlementRestriction>();

        if (ent.getRestrictions() != null) {
            for (EntitlementRestriction er : ent.getRestrictions()) {
                restrictions.add(new PortalDTO.EntitlementRestriction(er.getCode(), er.getCategoryCode(), er.getValidTo()));
            }
        }

        return restrictions;
    }

    private List<PortalDTO.Disqualification> getDisqualifications(Driver driver) {
        List<PortalDTO.Disqualification> disqualifications = new ArrayList<PortalDTO.Disqualification>();

        if (driver.getDisqualifications() == null) {
            return disqualifications;
        }

        for (Disqualification disqualification : driver.getDisqualifications()) {
            PortalDTO.Disqualification portalDisqualification = new PortalDTO.Disqualification();
            portalDisqualification.setEndorsementID(disqualification.getEndorsementID());
            portalDisqualification.setDisqFromDate(disqualification.getDisqFromDate());
            portalDisqualification.setDisqToDate(disqualification.getDisqToDate());
            portalDisqualification.setType(disqualification.getType());
            disqualifications.add(portalDisqualification);
        }
        return disqualifications;
    }

    private List<PortalDTO.TestPass> getTestPasses(Driver driver) {
        List<PortalDTO.TestPass> testPasses = new ArrayList<PortalDTO.TestPass>();

        if (driver.getTestPasses() == null) {
            return testPasses;
        }

        for (TestPass testPass : driver.getTestPasses()) {
            PortalDTO.TestPass portalTestPasses = new PortalDTO.TestPass();
            portalTestPasses.setEntitlementType(testPass.getEntitlementType());
            portalTestPasses.setStatusType(testPass.getStatusType());
            portalTestPasses.setTestPassDate(testPass.getTestPassDate());
            testPasses.add(portalTestPasses);
        }
        return testPasses;
    }
}


package uk.gov.dvla.services.transform;

import uk.gov.dvla.domain.*;
import uk.gov.dvla.domain.mib.EntitlementType;
import uk.gov.dvla.domain.mib.MibDTO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MibDriverTransformService implements TransformService<ServiceResult<Driver>, ServiceResult<MibDTO>> {

    @Override
    public ServiceResult<MibDTO> transform(ServiceResult<Driver> objectToTransform) {
        MibDTO mibDTO = new MibDTO();
        MibDTO.Driver mibDriver = new MibDTO.Driver();
        mibDTO.setDriver(mibDriver);

        Driver driver = objectToTransform.getResult();
        Licence licence = driver.getLicence().get(0);

        mibDriver.setLicence(getLicence(licence));
        MibDTO.Licence mibLicence = mibDriver.getLicence();
        mibLicence.setEntitlements(getEntitlements(licence));
        mibLicence.setEndorsements(getEndorsements(licence));

        return new ServiceResult<MibDTO>(objectToTransform.getEnquiryId(), mibDTO, objectToTransform.getMessages());
    }

    private MibDTO.Licence getLicence(Licence licence) {

        MibDTO.Licence mibLicence = new MibDTO.Licence();
        mibLicence.setValidFrom(licence.getValidFrom());
        mibLicence.setValidTo(licence.getValidTo());
        mibLicence.setDirectiveStatus(licence.getDirectiveStatus());

        return mibLicence;
    }

    private List<MibDTO.Entitlement> getEntitlements(Licence licence) {
        List<MibDTO.Entitlement> entitlements = new ArrayList<MibDTO.Entitlement>();
        if (licence.getEntitlements() == null) return entitlements;

        for (Entitlement ent : licence.getEntitlements()) {
            MibDTO.Entitlement mibEntitlement = new MibDTO.Entitlement();
            mibEntitlement.setCode(ent.getCode());
            mibEntitlement.setValidFrom(getValidFrom(ent));
            mibEntitlement.setValidTo(getValidTo(ent));
            mibEntitlement.setType(getEntitlementType(ent));

            entitlements.add(mibEntitlement);
        }

        return entitlements;
    }

    private List<MibDTO.Endorsement> getEndorsements(Licence licence) {
        List<MibDTO.Endorsement> endorsements = new ArrayList<MibDTO.Endorsement>();
        if (licence.getEndorsements() == null) return endorsements;

        for (Endorsement end : licence.getEndorsements()) {
            MibDTO.Endorsement mibEndorsement = new MibDTO.Endorsement();
            mibEndorsement.setCode(end.getOffenceCode());
            mibEndorsement.setOffenceDate(end.getOffenceDate());
            mibEndorsement.setConvictionDate(end.getConvictionDate());
            mibEndorsement.setSentencingDate(end.getSentencingDate());
            mibEndorsement.setFine(end.getFine());
            mibEndorsement.setNoOfPoints(end.getNumberOfPoints());
            mibEndorsement.setIsDisqual(end.getDisqualification());
            mibEndorsement.setDisqualPeriod(end.getPeriod());

            endorsements.add(mibEndorsement);
        }

        return endorsements;
    }

    private EntitlementType getEntitlementType(Entitlement ent) {
        EntitlementType entitlementType = EntitlementType.Full;

        if (ent.getIsProvisional()) {
            if (ent.isUnclaimedTestPass()) {
                entitlementType = EntitlementType.UnclaimedTestPass;
            }else {
                entitlementType = EntitlementType.Provisional;
            }
        }

        return entitlementType;
    }

    private Date getValidFrom(Entitlement entitlement) {
        Date validFrom = entitlement.getValidFrom();

        if (entitlement.getIsProvisional() && entitlement.isUnclaimedTestPass()) {
            validFrom = entitlement.getDatePassed();
        }

        return validFrom;
    }

    private Date getValidTo(Entitlement entitlement) {
        Date validTo = entitlement.getValidTo();
        Date expiryDate = entitlement.getUnclaimedTestPassExpiryDate();

        return (expiryDate == null) ? validTo : expiryDate;
    }
}

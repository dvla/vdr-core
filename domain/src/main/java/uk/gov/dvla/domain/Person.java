package uk.gov.dvla.domain;

import java.lang.Boolean;
import java.lang.String;
import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;
import com.google.code.morphia.annotations.Property;

@Entity
public class Person {
	
	private @Id String partyID;
	private String nino = null;
	private Passport passport = null;
	private BirthDetails birthDetails;
    private DeathDetails deathDetails;

    private Address address;

	private Name name;
	private int gender;
	
	private Date validFrom;
	private Date validTo;
	
	private Boolean adi;
	private Boolean military;
	private Boolean foreignLicenceOffender;

    private @Property("agyNotEmigCountry") String agencyNotifiedEmigrationCountry;
    private List<ElectronicAddress> electronicAddresses = null;
    private List<Image> images;
    private Boolean highRiskOffender;
    private Boolean organDonor;
    private Country nationality;
    private @Property("perNotEmigCountry") String personNotifiedEmigrationCountry;
    private List<Telephone> telephones;
    private String preferredLanguage;
    private @Property("vlIdentityCode") String verificationLevelIdentityCode;
    private @Property("vlIdentityName") String verificationLevelIdentityName;

    public String getPartyID() {
        return partyID;
    }

    public void setPartyID(String partyID) {
        this.partyID = partyID;
    }

    public String getNino() {
        return nino;
    }

    public void setNino(String nino) {
        this.nino = nino;
    }

    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }

    public BirthDetails getBirthDetails() {
        return birthDetails;
    }

    public void setBirthDetails(BirthDetails birthDetails) {
        this.birthDetails = birthDetails;
    }

    public DeathDetails getDeathDetails() {
        return deathDetails;
    }

    public void setDeathDetails(DeathDetails deathDetails) {
        this.deathDetails = deathDetails;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public Date getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(Date validFrom) {
        this.validFrom = validFrom;
    }

    public Date getValidTo() {
        return validTo;
    }

    public void setValidTo(Date validTo) {
        this.validTo = validTo;
    }

    public Boolean getAdi() {
        return adi;
    }

    public void setAdi(Boolean adi) {
        this.adi = adi;
    }

    public Boolean getMilitary() {
        return military;
    }

    public void setMilitary(Boolean military) {
        this.military = military;
    }

    public Boolean getForeignLicenceOffender() {
        return foreignLicenceOffender;
    }

    public void setForeignLicenceOffender(Boolean foreignLicenceOffender) {
        this.foreignLicenceOffender = foreignLicenceOffender;
    }

    public String getAgencyNotifiedEmigrationCountry() {
        return agencyNotifiedEmigrationCountry;
    }

    public void setAgencyNotifiedEmigrationCountry(String agencyNotifiedEmigrationCountry) {
        this.agencyNotifiedEmigrationCountry = agencyNotifiedEmigrationCountry;
    }

    public List<ElectronicAddress> getElectronicAddresses() {
        return electronicAddresses;
    }

    public void setElectronicAddresses(List<ElectronicAddress> electronicAddresses) {
        this.electronicAddresses = electronicAddresses;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public Boolean getHighRiskOffender() {
        return highRiskOffender;
    }

    public void setHighRiskOffender(Boolean highRiskOffender) {
        this.highRiskOffender = highRiskOffender;
    }

    public Boolean getOrganDonor() {
        return organDonor;
    }

    public void setOrganDonor(Boolean organDonor) {
        this.organDonor = organDonor;
    }

    public Country getNationality() {
        return nationality;
    }

    public void setNationality(Country nationality) {
        this.nationality = nationality;
    }

    public String getPersonNotifiedEmigrationCountry() {
        return personNotifiedEmigrationCountry;
    }

    public void setPersonNotifiedEmigrationCountry(String personNotifiedEmigrationCountry) {
        this.personNotifiedEmigrationCountry = personNotifiedEmigrationCountry;
    }

    public String getPreferredLanguage() {
        return preferredLanguage;
    }

    public void setPreferredLanguage(String preferredLanguage) {
        this.preferredLanguage = preferredLanguage;
    }

    public List<Telephone> getTelephones() {
        return telephones;
    }

    public void setTelephones(List<Telephone> telephones) {
        this.telephones = telephones;
    }

    public String getVerificationLevelIdentityCode() {
        return verificationLevelIdentityCode;
    }

    public void setVerificationLevelIdentityCode(String verificationLevelIdentityCode) {
        this.verificationLevelIdentityCode = verificationLevelIdentityCode;
    }

    public String getVerificationLevelIdentityName() {
        return verificationLevelIdentityName;
    }

    public void setVerificationLevelIdentityName(String verificationLevelIdentityName) {
        this.verificationLevelIdentityName = verificationLevelIdentityName;
    }
}

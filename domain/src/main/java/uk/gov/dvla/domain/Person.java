package uk.gov.dvla.domain;

import java.util.Date;

import org.bson.types.ObjectId;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;
import com.google.code.morphia.annotations.Property;

@Entity
public class Person {
	
	private @Id ObjectId id;
	private @Property("nino") String nationalInsuranceNumber = null;
	private @Property("pass_no") String passportNumber = null;
	private Date dob;
	private Country countryOfBirth;

	private Name name;
	private int gender;
	
	private Date validFrom;
	private Date validTo;
	
	private Boolean adi;
	private Boolean military;
	private Boolean foreignLicenceOffender;
	public ObjectId getId() {
		return id;
	}
	public void setId(ObjectId id) {
		this.id = id;
	}
	public String getNationalInsuranceNumber() {
		return nationalInsuranceNumber;
	}
	public void setNationalInsuranceNumber(String nationalInsuranceNumber) {
		this.nationalInsuranceNumber = nationalInsuranceNumber;
	}
	public String getPassportNumber() {
		return passportNumber;
	}
	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public Country getCountryOfBirth() {
		return countryOfBirth;
	}
	public void setCountryOfBirth(Country countryOfBirth) {
		this.countryOfBirth = countryOfBirth;
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
}

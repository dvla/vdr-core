package uk.gov.dvla.domain;

import java.util.Date;

import org.bson.types.ObjectId;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;

@Entity
public class Person {
	
	private @Id ObjectId id;
	private String nino = null;
	private String passNo = null;
	private Date dob;
	private Country countryOfBirth;

    private Address address;

	private Name name;
	private int gender;
	
	private Date validFrom;
	private Date validTo;
	
	private Boolean adi;
	private Boolean military;
	private Boolean foreignLicenceOffender;

    public void setAddress(Address address1){
        this.address = address1;
    }
    public Address getAddress(){
        return address;
    }
	public ObjectId getId() {
		return id;
	}
	public void setId(ObjectId id) {
		this.id = id;
	}
	public String getNino() {
		return nino;
	}
	public void setNino(String nino) {
		this.nino = nino;
	}
	public String getPassNo() {
		return passNo;
	}
	public void setPassNo(String passNo) {
		this.passNo = passNo;
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

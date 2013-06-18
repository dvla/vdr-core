package uk.gov.dvla.domain;

import java.util.Date;

import com.google.code.morphia.annotations.Embedded;

@Embedded
public class DriverNumber {

	private String id;
	private Name name;
	private Date validFrom;
	private Date validTo;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Name getName() {
		return name;
	}
	public void setName(Name name) {
		this.name = name;
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
}

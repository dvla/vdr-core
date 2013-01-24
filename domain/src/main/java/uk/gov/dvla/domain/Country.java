package uk.gov.dvla.domain;

import com.google.code.morphia.annotations.Embedded;

@Embedded
public class Country {

	private String name;
	private String code;
	private String internalCode;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getInternalCode() {
		return internalCode;
	}
	public void setInternalCode(String internalCode) {
		this.internalCode = internalCode;
	}	
}

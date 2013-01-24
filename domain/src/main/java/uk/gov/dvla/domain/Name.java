package uk.gov.dvla.domain;

import java.util.ArrayList;
import java.util.List;

import com.google.code.morphia.annotations.Embedded;

@Embedded
public class Name {
	
	private String title = null;
	private List<String> givenName = null;
	private String familyName = null;
	private String requestedName = null;
	private String initials = null;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<String> getGivenName() {
		return givenName;
	}
	public void setGivenName(List<String> givenName) {
		this.givenName = givenName;
	}
	public String getFamilyName() {
		return familyName;
	}
	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}
	public String getRequestedName() {
		return requestedName;
	}
	public void setRequestedName(String requestedName) {
		this.requestedName = requestedName;
	}
	public String getInitials() {
		return initials;
	}
	public void setInitials(String initials) {
		this.initials = initials;
	}
	
	public void addGivenName(String gn){
		if ( null == givenName ){
			givenName = new ArrayList<String>();
		}
		givenName.add(gn);
	}
}

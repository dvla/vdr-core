package uk.gov.dvla.domain;

import java.lang.Boolean;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;

import org.mongodb.morphia.annotations.Embedded;

@Embedded
public class Name {
	
	private String title = null;
	private List<String> givenName = null;
	private String familyName = null;
    private Boolean isTitleAddress = false;
    private String initials = null;

    public void addGivenName(String gn){
		if ( null == givenName ){
			givenName = new ArrayList<String>();
		}
		givenName.add(gn);
	}

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

    public Boolean getTitleAddress() {
        return isTitleAddress;
    }

    public void setTitleAddress(Boolean titleAddress) {
        isTitleAddress = titleAddress;
    }

    public String getInitials() {
        return initials;
    }

    public void setInitials(String initials) {
        this.initials = initials;
    }
}

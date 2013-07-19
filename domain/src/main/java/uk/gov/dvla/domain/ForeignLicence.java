package uk.gov.dvla.domain;

import java.lang.String;

public class ForeignLicence extends Licence {
	
	private Country country;
	private String number;

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}

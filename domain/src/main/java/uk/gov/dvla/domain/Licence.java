package uk.gov.dvla.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.code.morphia.annotations.Embedded;

@Embedded
public class Licence {
	
	public Date validFrom;
	public Date validTo;
	
	private List<Entitlement> entitlements;
	
	public void addEntitlement(String code){
		if (null == entitlements){
			entitlements = new ArrayList<Entitlement>();
		}
		Entitlement ent = new Entitlement();
		ent.setCode(code);
		ent.setValidFrom(new Date());
		ent.setValidTo(new Date());
		entitlements.add(ent);
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

	public List<Entitlement> getEntitlements() {
		return entitlements;
	}

	public void setEntitlements(List<Entitlement> entitlements) {
		this.entitlements = entitlements;
	}

}

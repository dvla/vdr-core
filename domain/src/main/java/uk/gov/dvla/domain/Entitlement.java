package uk.gov.dvla.domain;

import java.util.Date;
import java.util.List;

import com.google.code.morphia.annotations.Embedded;

@Embedded
public class Entitlement {
	
	private String code;
	private Date validFrom;
	private Date validTo;
	private Boolean provisional = null;
	private Boolean priorTo = null;
	private Boolean stated = null;
    private List<String> infoCodes;
    private Boolean unclaimedTestPass = false;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
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
	public Boolean getProvisional() {
		return provisional;
	}
	public void setProvisional(Boolean provisional) {
		this.provisional = provisional;
	}
	public Boolean getPriorTo() {
		return priorTo;
	}
	public void setPriorTo(Boolean priorTo) {
		this.priorTo = priorTo;
	}
	public Boolean getStated() {
		return stated;
	}
	public void setStated(Boolean stated) {
		this.stated = stated;
	}
    public List<String> getInfoCodes() {
        return infoCodes;
    }
    public void setInfoCodes(List<String> codes) {
        this.infoCodes = codes;
    }
    public Boolean getUnclaimedTestPass() {
        return unclaimedTestPass;
    }
    public void setUnclaimedTestPass(Boolean unclaimedTestPass) {
        this.unclaimedTestPass = unclaimedTestPass;
    }
}

package uk.gov.dvla.domain;

import java.util.List;

import com.google.code.morphia.annotations.Embedded;

@Embedded
public class Address {

	private boolean insecure;
	private Country country;
	private String langCode;
	private String pafKey;
	private String orgName;
	private String buildingName;
	private String subBuildingName;
	private String tfare;
	private String dtfare;
	private String ddtfare;
	private String dLocality;
	private String ddLocality;
	private String postTown;
	private String county;
	private String postCode;
	private String poBox;
	
	private List<String> uLine;
	private String uPostCode;
	public boolean isInsecure() {
		return insecure;
	}
	public void setInsecure(boolean insecure) {
		this.insecure = insecure;
	}
	public Country getCountry() {
		return country;
	}
	public void setCountry(Country country) {
		this.country = country;
	}
	public String getLangCode() {
		return langCode;
	}
	public void setLangCode(String langCode) {
		this.langCode = langCode;
	}
	public String getPafKey() {
		return pafKey;
	}
	public void setPafKey(String pafKey) {
		this.pafKey = pafKey;
	}
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	public String getBuildingName() {
		return buildingName;
	}
	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}
	public String getSubBuildingName() {
		return subBuildingName;
	}
	public void setSubBuildingName(String subBuildingName) {
		this.subBuildingName = subBuildingName;
	}
	public String getTfare() {
		return tfare;
	}
	public void setTfare(String tfare) {
		this.tfare = tfare;
	}
	public String getDtfare() {
		return dtfare;
	}
	public void setDtfare(String dtfare) {
		this.dtfare = dtfare;
	}
	public String getDdtfare() {
		return ddtfare;
	}
	public void setDdtfare(String ddtfare) {
		this.ddtfare = ddtfare;
	}
	public String getdLocality() {
		return dLocality;
	}
	public void setdLocality(String dLocality) {
		this.dLocality = dLocality;
	}
	public String getDdLocality() {
		return ddLocality;
	}
	public void setDdLocality(String ddLocality) {
		this.ddLocality = ddLocality;
	}
	public String getPostTown() {
		return postTown;
	}
	public void setPostTown(String postTown) {
		this.postTown = postTown;
	}
	public String getCounty() {
		return county;
	}
	public void setCounty(String county) {
		this.county = county;
	}
	public String getPostCode() {
		return postCode;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	public String getPoBox() {
		return poBox;
	}
	public void setPoBox(String poBox) {
		this.poBox = poBox;
	}
	public List<String> getuLine() {
		return uLine;
	}
	public void setuLine(List<String> uLine) {
		this.uLine = uLine;
	}
	public String getuPostCode() {
		return uPostCode;
	}
	public void setuPostCode(String uPostCode) {
		this.uPostCode = uPostCode;
	}
}

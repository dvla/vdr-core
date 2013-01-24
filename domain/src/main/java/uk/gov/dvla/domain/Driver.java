package uk.gov.dvla.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.code.morphia.annotations.Entity;

@Entity(value="drivers", noClassnameStored=true)
public class Driver extends Person {
	
	private List<DriverNumber> driverNumber;
	private List<DriverFlag> flag;
	private List<Licence> licence;
	
	private Boolean carHireEnqPmt = null;
	private String statusCode = null;
	private Boolean lifeFeePaid = null;
	private Boolean higerFeePaid = null;
	private Date photoExpiryDate;
	
	public void addLicence(Licence lic){
		if (null == licence){
			licence = new ArrayList<Licence>();
		}
		licence.add(lic);
	}
	
	public void setLicence(List<Licence> lics)
	{
		licence = lics;
	}
	
	public void addDriverNumber(){
		if ( null == driverNumber ){
			driverNumber = new ArrayList<DriverNumber>();			
		}
		DriverNumber dn = new DriverNumber();
		dn.setDriverNumber("SMITH00000000000");
		dn.setValidFrom(new Date());
		dn.setValidTo(new Date());
		driverNumber.add(dn);
	}
	public List<DriverNumber> getDriverNumber() {
		return driverNumber;
	}
	public void setDriverNumber(List<DriverNumber> driverNumber) {
		this.driverNumber = driverNumber;
	}
	public List<DriverFlag> getFlag() {
		return flag;
	}
	public void setFlag(List<DriverFlag> flag) {
		this.flag = flag;
	}
	public Boolean getCarHireEnqPmt() {
		return carHireEnqPmt;
	}
	public void setCarHireEnqPmt(Boolean carHireEnqPmt) {
		this.carHireEnqPmt = carHireEnqPmt;
	}
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	public Boolean getLifeFeePaid() {
		return lifeFeePaid;
	}
	public void setLifeFeePaid(Boolean lifeFeePaid) {
		this.lifeFeePaid = lifeFeePaid;
	}
	public Boolean getHigerFeePaid() {
		return higerFeePaid;
	}
	public void setHigerFeePaid(Boolean higerFeePaid) {
		this.higerFeePaid = higerFeePaid;
	}
	public Date getPhotoExpiryDate() {
		return photoExpiryDate;
	}
	public void setPhotoExpiryDate(Date photoExpiryDate) {
		this.photoExpiryDate = photoExpiryDate;
	}	
}

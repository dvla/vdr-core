package uk.gov.dvla.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Indexed;
import com.google.code.morphia.annotations.Property;

@Entity(value="drivers", noClassnameStored=true)
public class Driver extends Person {

    private List<DriverNumber> dlnHistory;
	private List<DriverFlag> flag;
	private List<Licence> licence;
    private List<Integer> stopMarker;
    private List<Integer> restrictionKey;
	
	private Boolean carHireEnqPmt = null;
	private String statusCode = null;
	private Date photoExpiryDate;

    @Property("dln") @Indexed(unique = true)
    private String currentDriverNumber = null;
	
	public void addLicence(Licence lic){
		if (null == licence){
			licence = new ArrayList<Licence>();
		}
		licence.add(lic);
	}

    public void addStopMarker(Integer marker){
        if (null == stopMarker){
            stopMarker = new ArrayList<Integer>();
        }
        stopMarker.add(marker);
    }

    public void addRestrictionKey(Integer key){
        if (null == restrictionKey){
            restrictionKey = new ArrayList<Integer>();
        }
        restrictionKey.add(key);
    }
	
	public void setLicence(List<Licence> lics)
	{
		licence = lics;
	}

    public List<Integer> getStopMarker(){
        return stopMarker;
    }
    public void setStopMarker(List<Integer> markers){
        this.stopMarker = markers;
    }
    public List<Integer> getRestrictionKey(){
        return restrictionKey;
    }
    public void setRestrictionKey(List<Integer> keys){
        this.restrictionKey = keys;
    }

    public void setCurrentDriverNumber(String dln){
        this.currentDriverNumber = dln;
    }

    public String getCurrentDriverNumber(){
        return this.currentDriverNumber;
    }

	public List<DriverNumber> getDriverNumberHistory() {
		return dlnHistory;
	}
	public void setDriverNumberHistory(List<DriverNumber> driverNumber) {
		this.dlnHistory = driverNumber;
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
	public Date getPhotoExpiryDate() {
		return photoExpiryDate;
	}
	public void setPhotoExpiryDate(Date photoExpiryDate) {
		this.photoExpiryDate = photoExpiryDate;
	}	
}

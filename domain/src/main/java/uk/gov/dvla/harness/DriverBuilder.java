package uk.gov.dvla.harness;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import uk.gov.dvla.domain.Country;
import uk.gov.dvla.domain.Driver;
import uk.gov.dvla.domain.DriverNumber;
import uk.gov.dvla.domain.Entitlement;
import uk.gov.dvla.domain.Licence;
import uk.gov.dvla.domain.Name;

public class DriverBuilder {

		
	private int gender;
	
	private String nino = null;
	private String pno = null;
	
	private Date dob = null; 
	private Date photoExpiry = null;
	
	private Country cob = null;
	
	private Name name = new Name();
	private List<DriverNumber> dlns = new ArrayList<DriverNumber>();
	private List<Licence> lics = new ArrayList<Licence>();
	
	public Driver build()
	{	
		Random rnd = new Random();
		
		Driver driver = new Driver();
		driver.setDob(dob);
		driver.setGender(gender);
		driver.setName(name);
		driver.setNationalInsuranceNumber(nino);
		driver.setPassportNumber(pno);		
		driver.setDriverNumber(dlns);
		driver.setLicence(lics);
		driver.setPhotoExpiryDate(photoExpiry);
		driver.setCountryOfBirth(cob);
		driver.setAdi(rnd.nextBoolean());
		driver.setCarHireEnqPmt(rnd.nextBoolean());
		driver.setForeignLicenceOffender(rnd.nextBoolean());
		driver.setHigerFeePaid(rnd.nextBoolean());
		driver.setLifeFeePaid(rnd.nextBoolean());
		driver.setMilitary(rnd.nextBoolean());

		return driver;
	}
	
	public DriverBuilder title(String title_p)
	{
		name.setTitle(title_p);
		return this;
	}
	
	public DriverBuilder forename(String fname)
	{
		name.addGivenName(fname);		
		defineInitials();
		return this;
	}	
	
	public DriverBuilder cob(Country cOfB)
	{
		cob = cOfB;
		return this;
	}
	
	public DriverBuilder licence()
	{
		Licence lic = new Licence();
		Date from = ago(5);
		Date to = future(5);
		lic.setValidFrom(from);
		lic.setValidTo(to);
		
		List<Entitlement> ents = new ArrayList<Entitlement>();
		Random rnd = new Random();
		int noEntitlements = rnd.nextInt(DriverRandomiser.entitlements.length-1)+1;
		for (int i=0; i<noEntitlements; i++)
		{
			Entitlement ent = new Entitlement();
			ent.setCode(DriverRandomiser.entitlements[i]);
			ent.setPriorTo(rnd.nextBoolean());
			ent.setProvisional(rnd.nextBoolean());
			ent.setStated(rnd.nextBoolean());
			ent.setValidFrom(from);
			ent.setValidTo(to);
			ents.add(ent);
		}
		lic.setEntitlements(ents);
		lics.add(lic);
		return this;
	}
	
	public DriverBuilder driverNumber()
	{
		DriverNumber dn = new DriverNumber();
		dn.setDriverNumber(DriverRandomiser.dln(name, dob, gender));
		Random rnd = new Random(50);
		int ago = rnd.nextInt();
		dn.setValidFrom(ago(ago));
		dn.setValidTo(ago(ago-10));
		
		dlns.add(dn);
		return this;
	}	
	
	private void defineInitials()
	{
		StringBuilder initials = new StringBuilder();
		for(String gname : name.getGivenName()){
			initials.append(gname.substring(0,1));
		}
		name.setInitials(initials.toString());
	}
	
	public DriverBuilder surname(String sname)
	{
		name.setFamilyName(sname);
		return this;
	}
	
	public DriverBuilder nino(String nino_p)
	{
		nino = nino_p;
		return this;
	}
	
	public DriverBuilder passport(String pp)
	{
		pno = pp;
		return this;
	}
	
	public DriverBuilder age(int age)
	{
		dob = ago(age);
		return this;
	}
	
	public DriverBuilder photoExpiry()
	{
		Random rnd = new Random();
		photoExpiry = future(rnd.nextInt(10));
		return this;		
	}
	
	public DriverBuilder gender(int g)
	{
		gender = g;
		return this;
	}
	
	private Date future(int years)
	{
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.YEAR, years);
		return cal.getTime();
	}
	
	private Date ago(int years)
	{
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.YEAR, (years * -1));
		return cal.getTime();
	}
}

package uk.gov.dvla.harness;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import uk.gov.dvla.domain.Country;
import uk.gov.dvla.domain.Driver;
import uk.gov.dvla.domain.Name;

public class DriverRandomiser {

	public static final int MALE = 0;
	public static final int FEMALE = 1;
	public static final int UNKN = 2;
	public static final int UNCT = 3;
	
	public static String[] mtitles = {"MR", "MR", "MR",  "SIR", "LORD", "EARL"};
	public static String[] ftitles = {"MRS", "MS", "MRS", "MRS", "LADY", "DAME"};
	
	public static String[] snames = {"ADAMS", 
			"BOOTH", "CARR", "DUNCAN", "EVERYMAN", "FORD", "GORDON", "HAIG", "ISMAY", "JONES",
			"KEARNS", "LEMON", "MALONE", "NOLAN", "OSBOURNE", "PETERSON", "QUIGLEY", "ROBINSON",
			"STERNS", "THORNTON", "UNDERWOOD", "VALINTINE", "WEST", "XAVI", "YOUNG", "ZED" };
	
	public static String[] mfnames = {"ANDREW", "BASIL", "CONOR", "DENIS", "EGBERT", "FREDERICK",
			"GEORGE", "HENRY", "IAN", "KEVIN", "JULIAN", "LIAM", "MICHAEL", "NORMAN",
			"OSCAR", "PAUL", "QUINCY", "ROBERT", "SHANE", "TERENCE", "ULRICK",
			"VINCENT", "WALTER", "XAVIER", "YHYS", "ZEB"
	};
	
	public static String[] ffnames = {"ANGELA", "BERTHA", "CANDICE", "DENISE", "ERMINTRUDE", "FIONA",
			"GEORGINA", "HARRIET", "ISABELLA", "JULIE", "KATHLEEN", "LEONORA", "MARGARET",
			"NIGELLA", "OSCARINA", "PENELOPE", "QUEENIE", "ROSANNE", "SARAH", "TONYA",
			"URSULA", "VIOLET", "WINIFRED", "XENA", "YVONNE", "ZERONNE"			
	};
	
	public static String[][] countries = {{"AT", "AUSTRIA"}, {"BE", "BELGIUM"}, {"DE", "GERMANY"}, {"IE", "IRELAND"}};
	public static String[] gb = {"GB", "UNITED KINGDOM"};
	
	public static boolean[] moreTrue = {true, true, true, true, true, false};
	
	public static String[] ninol2 = {"A","B","C","E","G","H","J","K","L","M","N","O","P",
			"R", "S", "T", "W", "X", "Y", "Z"};
	
	private String[] ninol1 = {"D"};
	
	public static String[] ninos = {"A", "B", "C", "D"};
	
	public static String[] entitlements = {"A", "A1", "B", "B1", "C1", "C", "C+E", "D1", "D1+E", "D", "D+E", "f", "g", "h", "k"};
	
	public Driver randomise(){
		
		Random rnd = new Random();
		if (rnd.nextBoolean()){
			return buildDriver(MALE);
		}
		else{
			return buildDriver(FEMALE);
		}
	}
	
	public Driver buildDriver(int gender)
	{
		DriverBuilder db = new DriverBuilder();
		db.title(gender == MALE ? maleTitle() : femaleTitle())
		  .forename(gender == MALE ? maleName() : femaleName())
		  .surname(surname())
		  .age(age())
		  .gender(gender)
		  .nino(nino())
		  .passport(passport())
		  .driverNumber()
		  .photoExpiry()
		  .licence()
		  .cob(country());
		  
		if (!moreTrueThanFalse()) {
			db.forename(gender == MALE ? maleName() : femaleName());
		}
		if (!moreTrueThanFalse()) {
			db.forename(gender == MALE ? maleName() : femaleName());
		}		
		
		Driver driver = db.build();		
		return driver;
	}
	
	public static String nino()
	{
		StringBuilder nino = new StringBuilder();
		NumberFormat nf = new DecimalFormat("000000");
		Random rnd = new Random();
		
		nino.append( ninol2[rnd.nextInt(ninol2.length)] );
		nino.append( ninol2[rnd.nextInt(ninol2.length)] );
		nino.append( nf.format( rnd.nextInt(999999) ));
		nino.append( ninos[rnd.nextInt(ninos.length)] );
		
		return nino.toString();
	}
	
	public static String passport()
	{
		Random rnd = new Random();
		NumberFormat nf = new DecimalFormat("#00000000");
		return nf.format(rnd.nextInt(999999999));
	}
	
	public static String maleName()
	{
		return randomise(mfnames);
	}
	
	public static String femaleName()
	{
		return randomise(ffnames);
	}
	
	public static String maleTitle()
	{
		return randomise(mtitles);		
	}

	public static String femaleTitle()
	{
		return randomise(ftitles);
	}
	
	public static String surname()
	{
		return randomise(snames);
	}
	
	public static int age()
	{
		// makes all drivers 17  or over and less than 80
		Random rnd = new Random();
		int age = rnd.nextInt(80-17) + 17;
		return age;
	}
	
	public static boolean moreTrueThanFalse()
	{
		Random rnd = new Random();
		return moreTrue[rnd.nextInt(moreTrue.length)];
	}
	
	public static Country country()
	{
		Random rnd = new Random();
		Country cty = new Country();
		String[] ctry = null;
		if ( moreTrueThanFalse() )
		{
			ctry = gb;
			cty.setInternalCode( String.valueOf(rnd.nextInt(4-1)+1));
		}
		else
		{
			ctry = countries[rnd.nextInt(countries.length)];
		}		
		
		cty.setCode(ctry[0]);
		cty.setName(ctry[1]);
		
		return cty;
		
	}
	
	private static String randomise(String[] list)
	{
		Random rnd = new Random();
		return list[rnd.nextInt(list.length)];
	}
	
	private static String substr(String string, int len)
	{
		String result = null;
		if ( string.length() >= len )
		{
			result = string.substring(0, len);
		}
		else
		{
			result = string;
			while (result.length() < len)
			{
				result = result + "9";
			}
		}
		return result;
	}
	
	public static String dln(Name name, Date dob, int gender)
	{
		StringBuilder dln = new StringBuilder();
		String surname = name.getFamilyName();
		
		// first 5 chars from surname
		dln.append( substr(surname, 5));
		
		// make DLN long enough
		while ( dln.length() < 5 )
		{
			dln.append("9");
		}
		
		// char 6 - decade of year of birthdate
		Calendar cal = Calendar.getInstance();
		cal.setTime(dob);		
		int dobYear = cal.get(Calendar.YEAR);
		if ( dobYear > 2000 ){
			dobYear= dobYear - 2000;
		}
		else {
			dobYear = dobYear - 1900;
		}
		// divide by 10 for decade
		dln.append( dobYear / 10 );
		
		
		// char 7-8 - month of birth, + 50 if female
		int dobMonth = cal.get(Calendar.MONTH) + 1;
		if ( gender == DriverRandomiser.FEMALE ){
			dobMonth = dobMonth + 50;
		}
		NumberFormat nf = new DecimalFormat("00");
		dln.append( nf.format(dobMonth) );
		
		// char 9-10 - date of birth
		int dobDate = cal.get(Calendar.DATE);
		dln.append( nf.format(dobDate));
		
		// char 11 - year from dob
		dln.append( dobYear % 10 );
		
		// char 12,13 - initials
		dln.append(substr(name.getInitials(),2));
		while (dln.length() < 13 ){
			dln.append("9");
		}
		
		// char 14 - default as 9
		dln.append("9");
		
		// char 15-18 - default as random 4 digit no
		Random rnd = new Random();
		nf = new DecimalFormat("0000");				
		dln.append( nf.format(rnd.nextInt(9999)) );
		
		return dln.toString();		
	}			
}

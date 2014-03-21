package uk.gov.dvla.services.builder;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import uk.gov.dvla.domain.*;
import uk.gov.dvla.services.randomise.DriverRandomiser;

public class DriverBuilder {

    private int gender;
    private String nino = null;
    private String pno = null;
    private Date dob = null;
    private Country cob = null;
    private String status = null;
    private String currentDriverNumber = null;
    private Name name = new Name();
    private List<DriverNumber> dlns = new ArrayList<DriverNumber>();
    private Licence licence = null;
    private List<Integer> markers = new ArrayList<Integer>();
    private List<String> caseTypes = new ArrayList<String>();
    private List<String> errorCodes = new ArrayList<String>();

    public Driver build() {
        Random rnd = new Random();

        Driver driver = new Driver();
        BirthDetails bd = new BirthDetails();
        bd.setDate(dob);
        bd.setCountry(cob);
        driver.setBirthDetails(bd);
        driver.setGender(gender);
        driver.setName(name);
        Passport pass = new Passport();
        pass.setNumber(pno);
        driver.setPassport(pass);
        driver.setDriverNumberHistory(dlns);
        driver.setCurrentDriverNumber(currentDriverNumber);
        for (Integer stopMarker : markers) {
            DriverFlag flag = new DriverFlag();
            flag.setFlag(stopMarker.toString());
            flag.setCaseType(false);
            flag.setManual(false);
            driver.addDriverFlag(flag);
        }
        driver.setLicence(licence);
        DriverStatus ds = new DriverStatus();
        ds.setCode(status);
        driver.setStatus(ds);
        driver.setAdi(rnd.nextBoolean());
        driver.setForeignLicenceOffender(rnd.nextBoolean());
        driver.setMilitary(rnd.nextBoolean());
        for (String caseType : caseTypes) {
            DriverFlag flag = new DriverFlag();
            flag.setFlag(caseType);
            flag.setCaseType(true);
            flag.setManual(false);
            driver.addDriverFlag(flag);
        }
        driver.setErrorCodes(errorCodes);

        return driver;
    }

    public DriverBuilder statusCode(String code) {
        status = code;
        return this;
    }

    public DriverBuilder stopMarker(Integer marker) {
        markers.add(marker);
        return this;
    }

    public DriverBuilder caseType(String type) {
        caseTypes.add(type);
        return this;
    }

    public DriverBuilder errorCodes(String code) {
        errorCodes.add(code);
        return this;
    }

    public DriverBuilder title(String title_p) {
        name.setTitle(title_p);
        return this;
    }

    public DriverBuilder forename(List<String> fname) {
        name.setGivenName(fname);
        defineInitials();
        return this;
    }

    public DriverBuilder cob(Country cOfB) {
        cob = cOfB;
        return this;
    }

    public DriverBuilder licence(List<Endorsement> endorsements) {
        Licence lic = new Licence();
        Date from = ago(5);
        Date to = future(5);
        lic.setValidFrom(from);
        lic.setValidTo(to);

        List<Entitlement> ents = new ArrayList<Entitlement>();
        Random rnd = new Random();
        lic.setPhotoExpiryDate(future(rnd.nextInt(10)));
        int noEntitlements = rnd.nextInt(DriverRandomiser.entitlements.length - 1) + 1;
        for (int i = 0; i < noEntitlements; i++) {
            Entitlement ent = new Entitlement();
            List<String> infoCodes = new ArrayList<String>();
            if (rnd.nextBoolean()) { //Don't always add info codes
                for (int x = 0; x < rnd.nextInt(5); x++) {
                    int rndInfoCode = rnd.nextInt(DriverRandomiser.informationCodes.length - 1) + 1;
                    infoCodes.add(DriverRandomiser.informationCodes[rndInfoCode]);
                }
            }
            ent.setCode(DriverRandomiser.entitlements[i]);
            ent.setPriorTo(rnd.nextBoolean());
            ent.setProvisional(rnd.nextBoolean());
            ent.setValidFrom(from);
            ent.setValidTo(to);
            List<EntitlementRestriction> infoCodesObjects = getEntitlementRestrictions(infoCodes);
            ent.setRestrictions(infoCodesObjects);
            ents.add(ent);
        }
        lic.setEntitlements(ents);
        lic.setEndorsements(endorsements);
        lic.setDirectiveStatus(rnd.nextInt(4));
        licence = lic;

        return this;
    }

    public DriverBuilder sequentialDriverNumber(Name name_p, Date dob_p, Integer gender_p, long nextSequence) {

        DriverNumber dn = new DriverNumber();
        String dln = DriverRandomiser.sequentialDln(name_p, dob_p, gender_p, nextSequence);
        dn.setId(dln);
        Random rnd = new Random();
        int ago = rnd.nextInt(20 - 1) + 1;
        Date from = ago(ago);
        Date to = future(ago);
        dn.setValidFrom(from);
        dn.setValidTo(to);

        currentDriverNumber = dln;
        dlns.add(dn);
        return this;
    }

    public DriverBuilder driverNumber(Name name_p, Date dob_p, Integer gender_p) {
        DriverNumber dn = new DriverNumber();
        String dln = DriverRandomiser.dln(name_p, dob_p, gender_p);
        dn.setId(dln);
        Random rnd = new Random();
        int ago = rnd.nextInt(20 - 1) + 1;
        Date from = ago(ago);
        Date to = future(ago);
        dn.setValidFrom(from);
        dn.setValidTo(to);

        currentDriverNumber = dln;
        dlns.add(dn);
        return this;
    }

    public DriverBuilder driverNumber() {
        return driverNumber(name, dob, gender);
    }

    public DriverBuilder sequentialDriverNumber(long nextSequence) {
        return sequentialDriverNumber(name, dob, gender, nextSequence);
    }


    private void defineInitials() {
        StringBuilder initials = new StringBuilder();
        for (String gname : name.getGivenName()) {
            initials.append(gname.substring(0, 1));
        }
        name.setInitials(initials.toString());
    }

    public DriverBuilder surname(String sname) {
        name.setFamilyName(sname);
        return this;
    }

    public DriverBuilder nino(String nino_p) {
        nino = nino_p;
        return this;
    }

    public DriverBuilder passport(String pp) {
        pno = pp;
        return this;
    }

    public DriverBuilder age(int age) {
        dob = ago(age);
        return this;
    }

    public DriverBuilder gender(int g) {
        gender = g;
        return this;
    }

    private Date future(int years) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.YEAR, years);
        return cal.getTime();
    }

    private Date ago(int years) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.YEAR, (years * -1));
        return cal.getTime();
    }

    private List<EntitlementRestriction> getEntitlementRestrictions(List<String> restrictionCodes) {
        List<EntitlementRestriction> infoCodesObjects = new ArrayList<EntitlementRestriction>();
        for (String code : restrictionCodes) {
            infoCodesObjects.add(new EntitlementRestriction(code, null));
        }
        return infoCodesObjects;
    }
}
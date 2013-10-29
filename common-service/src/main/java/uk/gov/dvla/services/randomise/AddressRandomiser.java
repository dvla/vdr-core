package uk.gov.dvla.services.randomise;

import uk.gov.dvla.services.builder.AddressBuilder;
import uk.gov.dvla.domain.Address;

import java.util.Random;

public class AddressRandomiser {

    public static String[] tfareTypes = {"ABBEY", "COPSE", "DRIVE", "ESTATE", "FARM", "GROVE", "HEIGHTS", "LANE", "PARADE", "POINT", "QUARRY", "RISE", "STREET",
            "TERRACE", "AVENUE", "DRIVE", "MEWS", "PARADE", "VIEW", "WAY"
    };

    public static String[] tfareNames = {"APPLE", "BEECH", "CORONATION", "DAIRY", "EAST", "FAR", "GREAT", "HIGH",
            "IODINE", "JUBLIEE", "KING'S", "LAWN", "MAIN", "NORTH", "ORCHARD", "PERCY", "QUEEN'S",
            "ROYAL", "STONE", "TREE", "UNIFORM", "VIOLET", "WEST", "YOUNGER"
    };

    public static String[] town = {"AVONABBEY", "BURNBURY", "CARRICKTON", "DURFORD", "ENDVILLE", "FORKTON", "GATESBURY", "HIGHTOWN",
        "IPSFORD", "JEDBURY", "KNIGHTSFORD", "LONGTOWN", "MAINTON", "NEARSBURY", "OPVILLE", "QUEENSFORD", "RAILTOWN", "SEABURY",
        "TEWSBURY", "UNDERFORD", "WINTERBURY", "YOUNGTON"
    };

    public static String [] postCodeAreas = {
            "AB","AL","B","BA","BB","BD","BH","BL","BN","BR","BS", //"BT", -- removed BT for Northern Ireland
            "CA","CB","CF","CH","CM","CO","CR","CT","CV","CW",
            "DA","DD","DE","DG","DH","DL","DN","DT","DY","E","EC","EH","EN","EX","FK","FY","G","GL","GU",
            "HA","HD","HG","HP","HR","HS","HU","HX","IG","IP","IV","KA","KT","KW","KY","L","LA","LD","LE","LL","LN","LS","LU",
            "M","ME","MK","ML","N","NE","NG","NN","NP","NR","NW","OL","OX","PA","PE","PH","PL","PO","PR","RG","RH","RM",
            "S","SA","SE","SG","SK","SL","SM","SN","SO","SP","SR","SS","ST","SW","SY","TA","TD","TF","TN","TQ","TR","TS","TW",
            "UB","W","WA","WC","WD","WF","WN","WR","WS","WV","YO","ZE"
    };

    public static String[] postCodeZones = {"A", "B", "D", "E", "F", "G", "H", "J", "L", "N", "P", "Q", "R", "S", "T", "U", "W", "X", "Y", "Z"};

    public Address randomise(){

        AddressBuilder ab = new AddressBuilder();

       Address address =
        ab.houseNumber(houseNumber())
            .thoroughfare(tfareName(), tfareType())
            .postTown(posttown())
            .postcode(postcode())
        .build();

        return address;
    }

    public int houseNumber(){
        Random rnd = new Random();
        return rnd.nextInt(200-1)+1; // between 1-200
    }

    public String tfareName(){
        Random rnd = new Random();
        return tfareNames[rnd.nextInt(tfareNames.length)];
    }

    public String tfareType(){
        Random rnd = new Random();
        return tfareTypes[rnd.nextInt(tfareTypes.length)];
    }

    public String posttown(){
        Random rnd = new Random();
        return town[rnd.nextInt(town.length)];
    }

    public String postcode(){
        Random rnd = new Random();

        StringBuffer pcode = new StringBuffer(postCodeAreas[rnd.nextInt(postCodeAreas.length)]);
        pcode.append(rnd.nextInt(99-1)+1); // pick digits between 1 and 99
        pcode.append(rnd.nextInt(9)); // pick digit between 0 and 9
        pcode.append(postCodeZones[rnd.nextInt(postCodeZones.length)]);
        pcode.append(postCodeZones[rnd.nextInt(postCodeZones.length)]);
        return pcode.toString();
    }
}


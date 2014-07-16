package uk.gov.dvla.services.randomise;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.*;
import java.util.Random;

import uk.gov.dvla.services.builder.DriverBuilder;
import uk.gov.dvla.domain.*;

public class DriverRandomiser {

    public static final int MALE = 1;
    public static final int FEMALE = 2;
    public static final int UNKN = 0;
    public static final int UNCT = 9;

    public static String[] mtitles = {"MR", "MR", "MR", "MR"};//, "SIR", "LORD", "EARL"};
    public static String[] ftitles = {"MRS", "MS", "MRS", "MRS"};//, "MS", "LADY", "DAME"};

    public static String[] snames = {"ADAMS",
            "BOOTH", "CARR", "DUNCAN", "EVERYMAN", "FORD", "GORDON", "HAIG", "ISMAY", "JONES",
            "KEARNS", "LEMON", "MALONE", "NOLAN", "OSBOURNE", "PETERSON", "QUIGLEY", "ROBINSON",
            "STERNS", "THORNTON", "UNDERWOOD", "VALINTINE", "WEST", "YOUNG", "ZED"};

    public static String[] mfnames = {"ANDREW", "BASIL", "CONOR", "DENIS", "EDWARD", "FREDERICK",
            "GEORGE", "HENRY", "IAN", "KEVIN", "JULIAN", "LIAM", "MICHAEL", "NORMAN",
            "OSCAR", "PAUL", "QUENTIN", "ROBERT", "SHANE", "TERENCE", "ULYSSES",
            "VINCENT", "WALTER", "XAVIER", "YURI"
    };

    public static String[] ffnames = {"ANGELA", "BERTHA", "CANDICE", "DENISE", "EIRWEN", "FIONA",
            "GEORGINA", "HARRIET", "ISABELLA", "JULIE", "KATHLEEN", "LEONORA", "MARGARET",
            "NIGELLA", "OLIVIA", "PENELOPE", "ROSANNE", "SARAH", "TONYA",
            "URSULA", "VIOLET", "WENDY", "YVONNE", "ZOE"
    };

    public static String[][] countries = {{"AT", "AUSTRIA"}, {"BE", "BELGIUM"}, {"DE", "GERMANY"}, {"IE", "IRELAND"}};
    public static String[] gb = {"GB", "UNITED KINGDOM"};

    public static boolean[] moreTrue = {true, true, true, true, true, false};

    public static String[] ninol2 = {"A", "B", "C", "E", "G", "H", "J", "K", "L", "M", "N", "O", "P",
            "R", "S", "T", "W", "X", "Y", "Z"};

    private String[] ninol1 = {"D"};

    public static String[] ninos = {"A", "B", "C", "D"};

    public static String[] entitlements = {"A", "A1", "B", "B1", "C1", "C", "C+E", "D1", "D1+E", "D", "D+E", "f", "g", "h", "k"};

    public static String[] informationCodes = {"02", "10", "15", "20", "25", "30", "35", "40", "42", "43", "44",
            "45", "78", "79", "123", "124", "101", "102", "103", "105", "106",
            "107", "108", "110", "111", "113", "114", "118", "119", "122"};


    public static String[] statusCodes = {"A", "F"};

    public static Integer[] stopMarkers = {1, 64, 2, 26, 40, 56, 57};

    public static Integer[] restrictionKeys = {0, 7, 11, 12, 14, 16};

    public static String[] penaltyPointOffenceCodes = {"AC10", "AC20", "AC30",
            "BA10", "BA30",
            "CD10", "CD20", "CD30",
            "CU10", "CU20", "CU30",
            "SP10", "SP20", "SP30", "SP40", "SP50"};

    public static String[] disqualificationOffenceCodes = {"DD40", "DD60", "DD80", "DD90",
            "DR10", "DR20", "DR30"};

    public static String[] convictingCourtCodes = {"1493", "1695", "1021", "1023", "1051"};

    public static String[] otherSentenceCodes = {"A", "B", "C", "D", "E", "F", "G",
            "H", "I", "J", "@", "/", "#"};

    public static String[] durationTypes = {"Y", "M", "D"};

    public static String[] releaseErrorCodes = {"4005", "4069", "4206", "0101", "0201", "0301", "0601", "0602", "0701", "0702", "0703", "0704", "0705", "0708", "0738", "0740", "0743", "0744", "0745", "0752", "0757", "0761", "0762", "0773", "0778", "0793", "0794", "0802", "0803", "0806", "0807", "0808", "0811", "0814", "0824", "0827", "0829", "0838", "1001", "1101", "1103", "1104", "1106", "1108", "1110", "1201", "1301", "1302", "1303", "1304", "1305", "1306", "1307", "1310", "1311", "1313", "1314", "1315", "1316", "1317", "1805", "3001", "3002", "3004", "3005", "3006", "3007", "3009", "3013", "3016", "3019", "3026", "3033", "3035", "3036", "3038", "3039", "3054", "3064", "3112", "3113", "3124", "3137", "3139", "3140", "3141", "3143", "3144", "3154", "3159", "3160", "3172", "3173", "3174", "3176", "3177", "3181", "3182", "3183", "3184", "3187", "3191", "4001", "4002", "4003", "4004", "4010", "4011", "4012", "4017", "4018", "4019", "4024", "4028", "4029", "4041", "4042", "4044", "4047", "4048", "4050", "4055", "4057", "4064", "4068", "4071", "4076", "4077", "4078", "4079", "4081", "4082", "4083", "4086", "4087", "4096", "4098", "4198", "4199", "4201", "4203", "4204", "4205", "4207", "4208", "4209", "4210", "5021", "5024", "5025", "5026", "5027", "5028", "5032", "5033", "5042", "5044", "5046", "5052", "5053", "5054", "5056", "5057", "5062", "5064", "5065", "5067", "5072", "5075", "5084", "5086", "5087", "5088", "5092", "5093", "5102", "5105", "5106", "5107", "5108", "5122", "5123", "5132", "5133", "5144", "5145", "5162", "5178", "5204", "5212", "5216", "5333", "5522", "5523", "5532", "5602", "5603", "5614", "5615", "5632", "5633", "5638", "5642", "5644", "5645", "5647", "5672", "5692", "5702", "5703", "5722", "5723", "5732", "5745", "5755", "5763", "5802", "6042", "6043", "6052", "6503", "6504", "6532", "6534", "6542", "6543", "7001", "7002", "7011", "9005", "9011", "9015", "9034", "9056", "9058", "9062", "9098", "9126", "9133", "9303", "9305", "9307", "9449", "9501", "9503", "9507", "9509", "9516", "9522", "9523", "9527", "9531", "9532", "9534", "9567", "9568", "9573", "9576", "9577", "9584", "9585", "9586", "9589", "9592", "9594", "9808", "9950", "9999", "0401", "0503", "0504", "0716", "0720", "0726", "0749", "0751", "0753", "0754", "0760", "0763", "0764", "0765", "0766", "0769", "0777", "0782", "0790", "0791", "0795", "1312", "1318", "1319", "1320", "1321", "1322", "1323", "1601", "1602", "1603", "1605", "1606", "1607", "1608", "1609", "1610", "1611", "1617", "1618", "1700", "1701", "1702", "1703", "1704", "1705", "1801", "1802", "1808", "1812", "1813", "1814", "1826", "1828", "1829", "1830", "1831", "1833", "1834", "1835", "1836", "1837", "1838", "1839", "1840", "1842", "1843", "1844", "1845", "1846", "1847", "1848", "1901", "1904", "1905", "1912", "1917", "2004", "2008", "2014", "2018", "2101", "2102", "2103", "2104", "2105", "2106", "2107", "2108", "2109", "2206", "2207", "2208", "2209", "2210", "2211", "2212", "2213", "2214", "2215", "2216", "2308", "2316", "2317", "2319", "2320", "2321", "2322", "2329", "2330", "2331", "2333", "2334", "2339", "2340", "2342", "2345", "2346", "2348", "2349", "2352", "2353", "2358", "2359", "2360", "2361", "2362", "2363", "2364", "2365", "2366", "2367", "2368", "2370", "2382", "2383", "2601", "2602", "2603", "2604", "2605", "2606", "2607", "2608", "2609", "3000", "3003", "3008", "3010", "3011", "3012", "3014", "3015", "3017", "3018", "3020", "3021", "3022", "3023", "3024", "3025", "3027", "3028", "3029", "3030", "3031", "3032", "3034", "3037", "3040", "3041", "3042", "3043", "3044", "3045", "3046", "3047", "3048", "3049", "3050", "3051", "3052", "3053", "3055", "3056", "3057", "3058", "3059", "3060", "3061", "3062", "3063", "3065", "3066", "3067", "3068", "3069", "3070", "3071", "3072", "3073", "3074", "3075", "3076", "3077", "3078", "3079", "3080", "3081", "3082", "3083", "3084", "3085", "3086", "3087", "3088", "3089", "3090", "3091", "3092", "3093", "3094", "3095", "3096", "3097", "3098", "3099", "3100", "3101", "3102", "3103", "3104", "3105", "3106", "3107", "3108", "3109", "3110", "3111", "3114", "3115", "3116", "3117", "3118", "3119", "3120", "3121", "3122", "3123", "3125", "3126", "3127", "3128", "3129", "3130", "3131", "3132", "3133", "3134", "3135", "3136", "3138", "3142", "3145", "3146", "3147", "3148", "3149", "3150", "3151", "3152", "3153", "3155", "3156", "3157", "3158", "3161", "3162", "3163", "3164", "3165", "3166", "3167", "3168", "3169", "3170", "3171", "3175", "3178", "3179", "3180", "3185", "3186", "3188", "3189", "3190", "3192", "3193", "3194", "3195", "4007", "4013", "4014", "4015", "4020", "4033", "4034", "4035", "4036", "4037", "4039", "4043", "4045", "4049", "4051", "4053", "4054", "4056", "4058", "4061", "4065", "4066", "4067", "4070", "4072", "4073", "4074", "4097", "4202", "4701", "4702", "4703", "4704", "4705", "4706", "4707", "4708", "4709", "4710", "4711", "4712", "4713", "4714", "4715", "4716", "4717", "4718", "4719", "4720", "4721", "4722", "4723", "4724", "4725", "4726", "4727", "4728", "4729", "4730", "4731", "4732", "4733", "4734", "4735", "4736", "4737", "4738", "4739", "4740", "4741", "4742", "4743", "4744", "4745", "4746", "4747", "4748", "5011", "5012", "5013", "5022", "5023", "5029", "5034", "5043", "5045", "5047", "5086", "5055", "5058", "5059", "5063", "5066", "5068", "5073", "5074", "5082", "5083", "5091", "5094", "5103", "5104", "5109", "5112", "5113", "5124", "5125", "5126", "5127", "5134", "5142", "5143", "5148", "5163", "5164", "5165", "5167", "5168", "5175", "5176", "5177", "5192", "5217", "5218", "5222", "5232", "5233", "5253", "5324", "5325", "5332", "5342", "5343", "5344", "5346", "5382", "5412", "5492", "5493", "5502", "5533", "5552", "5613", "5616", "5634", "5635", "5637", "5646", "5652", "5662", "5663", "5664", "5665", "5682", "5683", "5712", "5744", "5746", "5752", "5754", "5756", "5764", "5765", "5766", "5767", "5773", "5774", "5775", "5776", "5782", "5783", "5792", "5793", "5794", "5803", "5812", "5822", "5834", "5842", "5884", "5906", "5952", "5962", "6013", "6022", "6032", "6092", "6224", "6252", "6262", "6332", "6403", "6533", "6535", "6544", "6574", "6652", "7012", "7152", "7181", "8111", "8113", "8131", "8142", "8193", "8201", "8511", "8911", "8912", "8913", "9001", "9002", "9004", "9006", "9007", "9008", "9009", "9010", "9012", "9013", "9014", "9016", "9017", "9018", "9019", "9020", "9021", "9022", "9023", "9024", "9025", "9026", "9027", "9028", "9029", "9030", "9032", "9033", "9035", "9036", "9037", "9038", "9039", "9040", "9041", "9042", "9043", "9044", "9045", "9046", "9047", "9048", "9049", "9050", "9051", "9052", "9053", "9054", "9055", "9059", "9060", "9061", "9063", "9064", "9065", "9066", "9067", "9068", "9069", "9070", "9071", "9072", "9073", "9074", "9076", "9077", "9078", "9079", "9080", "9081", "9082", "9083", "9084", "9085", "9086", "9087", "9088", "9089", "9090", "9091", "9092", "9093", "9094", "9095", "9096", "9097", "9099", "9100", "9102", "9103", "9104", "9105", "9106", "9107", "9108", "9109", "9110", "9111", "9112", "9113", "9114", "9115", "9116", "9117", "9118", "9119", "9120", "9121", "9122", "9123", "9124", "9125", "9127", "9128", "9129", "9130", "9131", "9132", "9134", "9135", "9136", "9137", "9138", "9139", "9140", "9141", "9142", "9143", "9144", "9145", "9146", "9147", "9148", "9149", "9150", "9151", "9153", "9154", "9155", "9156", "9157", "9158", "9159", "9160", "9161", "9162", "9164", "9165", "9166", "9167", "9168", "9169", "9170", "9171", "9172", "9173", "9174", "9175", "9176", "9177", "9178", "9179", "9180", "9181", "9182", "9183", "9184", "9185", "9186", "9187", "9188", "9189", "9190", "9191", "9192", "9193", "9194", "9195", "9196", "9197", "9198", "9199", "9200", "9201", "9202", "9203", "9204", "9205", "9206", "9207", "9208", "9209", "9210", "9211", "9212", "9213", "9214", "9215", "9216", "9217", "9218", "9219", "9220", "9221", "9222", "9223", "9224", "9225", "9226", "9227", "9228", "9229", "9230", "9231", "9232", "9233", "9234", "9235", "9236", "9237", "9238", "9239", "9240", "9241", "9242", "9243", "9244", "9245", "9246", "9247", "9248", "9249", "9250", "9251", "9252", "9253", "9254", "9255", "9256", "9257", "9258", "9259", "9260", "9261", "9262", "9263", "9264", "9265", "9266", "9267", "9268", "9269", "9270", "9271", "9272", "9273", "9274", "9275", "9276", "9277", "9278", "9279", "9280", "9281", "9282", "9283", "9284", "9285", "9286", "9287", "9288", "9289", "9290", "9291", "9292", "9293", "9294", "9295", "9296", "9297", "9298", "9299", "9300", "9301", "9302", "9304", "9306", "9308", "9309", "9310", "9311", "9312", "9313", "9314", "9315", "9316", "9318", "9319", "9320", "9321", "9322", "9323", "9324", "9325", "9326", "9327", "9421", "9422", "9423", "9424", "9425", "9431", "9432", "9433", "9434", "9435", "9436", "9437", "9438", "9439", "9440", "9441", "9442", "9443", "9444", "9445", "9446", "9450", "9451", "9452", "9453", "9454", "9455", "9456", "9457", "9458", "9459", "9460", "9461", "9462", "9463", "9464", "9465", "9466", "9467", "9468", "9469", "9470", "9471", "9472", "9473", "9474", "9475", "9476", "9477", "9478", "9479", "9480", "9481", "9482", "9483", "9484", "9485", "9487", "9488", "9489", "9490", "9500", "9502", "9504", "9505", "9506", "9508", "9511", "9512", "9514", "9515", "9517", "9518", "9519", "9520", "9521", "9524", "9525", "9526", "9528", "9529", "9530", "9533", "9535", "9536", "9537", "9538", "9539", "9540", "9541", "9542", "9543", "9544", "9545", "9546", "9547", "9548", "9549", "9550", "9551", "9552", "9553", "9554", "9555", "9556", "9566", "9569", "9570", "9571", "9572", "9574", "9575", "9578", "9579", "9580", "9582", "9583", "9587", "9588", "9590", "9591", "9593", "9595", "9801", "9802", "9803", "9804", "9805", "9806", "9807", "9809", "9810", "9811", "9812", "9813", "9814", "9815", "9816", "9817", "9818", "9819", "9820", "9821", "9822", "9823", "9824", "9825", "9826", "9827", "9828", "9829", "9830", "9831", "9832", "9833", "9834", "9835", "9836", "9837", "9838", "9839", "9840", "9841", "9842", "9843", "9844", "9845", "9846", "9847", "9848", "9849", "9850", "9851", "9852", "9853", "9854", "9855", "9856", "9857", "9858", "9859", "9860", "9861", "9862", "9863", "9864", "9865", "9866", "9867", "9868", "9869", "9870", "9871", "9872", "9873", "9874", "9875", "9876", "9877", "9878", "9879", "9880", "9881", "9882", "9883", "9884", "9885", "9886", "9887", "9888", "9889", "9890", "9891", "9892", "9893", "9894", "9895", "9896", "9897", "9898", "9899", "9900", "9901", "9902", "9903", "9904", "9905", "9906", "9907", "9908", "9909", "9910", "9911", "9912", "9913", "9914", "9915", "9916", "9917", "9918", "9919", "9920", "9921", "9922", "9923", "9924", "9925", "9926", "9927", "9928", "9929", "9930", "9931", "9932", "9933", "9934", "9935", "9936", "9937", "9938", "9939", "9940", "9941", "9942", "9943", "9944", "9945", "9946", "9947", "9948", "9949", "9951", "9952", "9953", "9954", "9955", "9956", "9957", "9958", "9959", "9960", "9961", "9962", "9963", "9964", "9965", "9966", "9967", "9968", "9969", "9970", "9971", "9972", "9973", "9974", "9975", "9976", "9977", "9978", "9979", "9980", "9981", "9982", "9983", "9984", "9985", "9986", "9987", "9988", "9989", "9990", "9991", "9998", "1677", "507I", "5078", "5077", "5076", "2703", "2700", "5038", "2705", "2701"};

    public static String[] suppressErrorCodes = {"0728", "0730", "0750", "0756", "0775", "0788", "0796", "0822", "1102", "1105", "1107", "4021", "4022", "4060", "4084", "4085", "5315", "9057", "0729", "0741", "0768", "0809", "0832", "0839", "1308", "4008", "4046", "9328", "9329", "9486", "9510", "9513", "1604", "1832", "4023", "4040", "4059", "4062", "4063", "5252", "8951", "8952"};


    public Driver randomise() {

        Random rnd = new Random();
        if (rnd.nextBoolean()) {
            return buildDriver(MALE);
        } else {
            return buildDriver(FEMALE);
        }
    }

    public Driver randomiseSequential(long nextSequence) {

        Random rnd = new Random();
        if (rnd.nextBoolean()) {
            return buildDriver(MALE, nextSequence);
        } else {
            return buildDriver(FEMALE, nextSequence);
        }
    }

    public Driver randomiseWithErrorCodes(int recordNumber, boolean suppressErrorCodes) {

        Random rnd = new Random();
        Driver driver = null;

        if (rnd.nextBoolean()) {
            driver = createErrorCodes(recordNumber, suppressErrorCodes);
        } else {
            driver = createErrorCodes(recordNumber, suppressErrorCodes);
        }
        return driver;
    }

    public Driver buildDriver(int gender) {

        Random rnd = new Random();
        DriverBuilder db = new DriverBuilder();
        db.title(gender == MALE ? maleTitle() : femaleTitle())
                .forename(fname(gender))
                .surname(surname())
                .age(age())
                .gender(gender)
                .nino(nino())
                .passport(passport())
                .driverNumber()
                .licence(endorsements())
                .cob(country());

        /**
         * Add a driver status code
         */
        db.statusCode(statusCodes[rnd.nextInt(statusCodes.length)]);

        /**
         * Perhaps add stop markers
         */
        if (!moreTrueThanFalse()) {
            int noStops = rnd.nextInt(stopMarkers.length);
            for (int i = 0; i < noStops; i++) {
                db.stopMarker(stopMarkers[i]);
            }
        }

		Driver driver = db.build();		
		return driver;
	}

    public Driver buildDriver(int gender, long nextSequence) {
        Random rnd = new Random();
        DriverBuilder db = new DriverBuilder();
        db.title(gender == MALE ? maleTitle() : femaleTitle())
                .forename(fname(gender))
                .surname(surname())
                .age(age())
                .gender(gender)
                .nino(nino())
                .passport(passport())
                .sequentialDriverNumber(nextSequence)
                .licence(endorsements())
                .cob(country());

        /**
         * Add a driver status code
         */
        db.statusCode(statusCodes[rnd.nextInt(statusCodes.length)]);

        /**
         * Perhaps add stop markers
         */
        if (!moreTrueThanFalse()) {
            int noStops = rnd.nextInt(stopMarkers.length);
            for (int i = 0; i < noStops; i++) {
                db.stopMarker(stopMarkers[i]);
            }
        }

        Driver driver = db.build();
        return driver;
    }

    public Driver createErrorCodes(int recordNumber, boolean suppressCodes) {
        Driver driver = buildDriver(MALE);
        // Set CaseType 1
        DriverFlag df = new DriverFlag();
        df.setFlag("1");
        df.setCaseType(true);
        df.setManual(false);
        driver.addDriverFlag(df);
        if (suppressCodes) {
            Random rnd = new Random();
            int noCodes = rnd.nextInt(11) + 1;
            for (int i = 0; i < noCodes; i++) {
                int code = rnd.nextInt(suppressErrorCodes.length);
                driver.addErrorCode(suppressErrorCodes[code]);
            }
        } else {
            // All records will have 5 error codes
            int startNumber = recordNumber * 5;
            int noCodes = (recordNumber + 1) * 5;
            for (int i = startNumber; i < noCodes; i++) {
                if (i < releaseErrorCodes.length) {
                    driver.addErrorCode(releaseErrorCodes[i]);
                }
            }
        }

        // And the status should be valid i.e. F
        DriverStatus ds = new DriverStatus();
        ds.setCode("F");
        driver.setStatus(ds);
        return driver;
    }

    public static String nino() {
        StringBuilder nino = new StringBuilder();
        NumberFormat nf = new DecimalFormat("000000");
        Random rnd = new Random();

        nino.append(ninol2[rnd.nextInt(ninol2.length)]);
        nino.append(ninol2[rnd.nextInt(ninol2.length)]);
        nino.append(nf.format(rnd.nextInt(999999)));
        nino.append(ninos[rnd.nextInt(ninos.length)]);

        return nino.toString();
    }

    public static String passport() {
        Random rnd = new Random();
        NumberFormat nf = new DecimalFormat("#00000000");
        return nf.format(rnd.nextInt(999999999));
    }

    public static List<String> fname(Integer gender) {
        List<String> names = new ArrayList<String>();
        String[] fnames = gender == MALE ? mfnames : ffnames;
        String name = randomise(fnames);
        names.add(name);

        /**
         * Perhaps add a 2nd forename
         */
        if (!moreTrueThanFalse()) {
            name = randomise(fnames);
            names.add(name);
        }
        /**
         * Perhaps add a 3rd forename
         */
        if (!moreTrueThanFalse()) {
            name = randomise(fnames);
            names.add(name);
        }
        return names;

    }

    public static String maleTitle() {
        return randomise(mtitles);
    }

    public static String femaleTitle() {
        return randomise(ftitles);
    }

    public static String surname() {
        return randomise(snames);
    }

    public static int age() {
        // makes all drivers 17  or over and less than 80
        Random rnd = new Random();
        int age = rnd.nextInt(80 - 17) + 17;
        return age;
    }

    public static boolean moreTrueThanFalse() {
        Random rnd = new Random();
        return moreTrue[rnd.nextInt(moreTrue.length)];
    }

    public static Country country() {
        Random rnd = new Random();
        Country cty = new Country();
        String[] ctry = null;
        if (moreTrueThanFalse()) {
            ctry = gb;
            cty.setInternalCode(String.valueOf(rnd.nextInt(4 - 1) + 1));
        } else {
            ctry = countries[rnd.nextInt(countries.length)];
        }

        cty.setCode(ctry[0]);
        cty.setName(ctry[1]);

        return cty;

    }

    private static String randomise(String[] list) {
        Random rnd = new Random();
        return list[rnd.nextInt(list.length)];
    }

    private static String substr(String string, int len) {
        String result = null;
        if (string.length() >= len) {
            result = string.substring(0, len);
        } else {
            result = string;
            while (result.length() < len) {
                result = result + "9";
            }
        }
        return result;
    }

    public static String dln(Name name, Date dob, int gender) {
        StringBuilder dln = new StringBuilder();
        String surname = name.getFamilyName();

        // first 5 chars from surname
        dln.append(substr(surname, 5));

        // make DLN long enough
        while (dln.length() < 5) {
            dln.append("9");
        }

        // char 6 - decade of year of birthdate
        Calendar cal = Calendar.getInstance();
        cal.setTime(dob);
        int dobYear = cal.get(Calendar.YEAR);
        if (dobYear > 2000) {
            dobYear = dobYear - 2000;
        } else {
            dobYear = dobYear - 1900;
        }
        // divide by 10 for decade
        dln.append(dobYear / 10);


        // char 7-8 - month of birth, + 50 if female
        int dobMonth = cal.get(Calendar.MONTH) + 1;
        if (gender == DriverRandomiser.FEMALE) {
            dobMonth = dobMonth + 50;
        }
        NumberFormat nf = new DecimalFormat("00");
        dln.append(nf.format(dobMonth));

        // char 9-10 - date of birth
        int dobDate = cal.get(Calendar.DATE);
        dln.append(nf.format(dobDate));

        // char 11 - year from dob
        dln.append(dobYear % 10);

        // char 12,13 - initials
        dln.append(substr(name.getInitials(), 2));
        while (dln.length() < 13) {
            dln.append("9");
        }

        // char 14 - default as 9
        dln.append("9");

        // char 15-16 - Check Digits default as random 2 characters
        Random random = new Random();
        while (dln.length() < 16) {
            int digit = random.nextInt(ninol2.length - 1);
            dln.append(ninol2[digit]);
        }

        return dln.toString();
    }

    private static String padLeft(String str, char padWith) {

        StringBuilder sb = new StringBuilder();

        for (int toPrepend = 8 - str.length(); toPrepend > 0; toPrepend--) {
            sb.append(padWith);
        }

        sb.append(str);
        return sb.toString();
    }

    public static String sequentialDln(Name name, Date dob, int gender, Long nextSequence) {

        StringBuilder dln = new StringBuilder();
        String surname = name.getFamilyName();

        // first 5 chars from surname
        dln.append(substr(surname, 3));

        String sequence = Long.toString(nextSequence).replaceAll("-", "0");

        dln.append("99999999".substring(sequence.length()) + sequence.toString());

        // char 12,13 - initials
        dln.append(substr(name.getInitials(), 2));
        while (dln.length() < 13) {
            dln.append("9");
        }

        // char 14 - default as 9
        dln.append("9");

        // char 15-16 - Check Digits default as random 2 characters
        Random random = new Random();
        while (dln.length() < 16) {
            int digit = random.nextInt(ninol2.length - 1);
            dln.append(ninol2[digit]);
        }

        return dln.toString();
    }

    public static List<Endorsement> endorsements() {
        ArrayList<Endorsement> endorsements = new ArrayList<Endorsement>();
        Random random = new Random();

        if (!moreTrueThanFalse()) {
            //Assume penalty points remain on licence for 4 years, active for 3
            int noPenaltyPointOffenceCodes = random.nextInt(penaltyPointOffenceCodes.length - 1) + 1;
            for (int i = 0; i < noPenaltyPointOffenceCodes; i++) {
                int daysUntilRemovedFromLicence = 365 * 3;
                Calendar cal = Calendar.getInstance();
                cal.setTime(new Date());
                cal.add(Calendar.DATE, random.nextInt(daysUntilRemovedFromLicence));
                Date dateRemovedFromLicence = cal.getTime();

                cal.add(Calendar.YEAR, -1);
                Date dateExpires = cal.getTime();

                cal.add(Calendar.YEAR, -3);
                Date dateOffence = cal.getTime();

                Endorsement e = new Endorsement();
                Random rnd = new Random();
                e.setDisqual(false);
                e.setCode(randomise(penaltyPointOffenceCodes));
                e.setNoPoints(random.nextInt(3) + 3);
                e.setConvictingCourt(randomise(convictingCourtCodes));
                e.setOffence(dateOffence);
                e.setExpires(dateExpires);
                if (!moreTrueThanFalse()) {
                    OtherSentence os = new OtherSentence();
                    os.setCode(randomise((otherSentenceCodes)));
                    os.setDuration("P" + Integer.toString(random.nextInt(3) + 3) + randomise(durationTypes));

                    e.setOtherSentence(os);
                }
                e.setRemoved(dateRemovedFromLicence);
                endorsements.add(e);
            }

            //Assume disqualifications remain on licence for 11 years, active for 10
            int noDisqualificationOffenceCodes = random.nextInt(disqualificationOffenceCodes.length - 1) + 1;
            for (int i = 0; i < noDisqualificationOffenceCodes; i++) {
                int daysUntilRemovedFromLicence = 365 * 10;
                Calendar cal = Calendar.getInstance();
                cal.setTime(new Date());
                cal.add(Calendar.DATE, random.nextInt(daysUntilRemovedFromLicence));
                Date dateRemovedFromLicence = cal.getTime();

                cal.add(Calendar.YEAR, -1);
                Date dateExpires = cal.getTime();

                cal.add(Calendar.YEAR, -10);
                Date dateConviction = cal.getTime();

                cal.add(Calendar.DATE, random.nextInt(20));
                Date dateSentencing = cal.getTime();

                cal.setTime(dateConviction);
                cal.add(Calendar.DATE, -(random.nextInt(20)));
                Date dateOffence = cal.getTime();

                Endorsement e = new Endorsement();
                e.setDisqual(true);
                e.setCode(randomise(disqualificationOffenceCodes));
                e.setConvictingCourt(randomise(convictingCourtCodes));
                e.setConviction(dateConviction);
                e.setOffence(dateOffence);
                e.setSentencing(dateSentencing);
                e.setExpires(dateExpires);
                e.setRemoved(dateRemovedFromLicence);
                e.setDuration("P12M");
                e.setFine(60.00 * (random.nextInt(3)));
                endorsements.add(e);
            }
        }
        return endorsements;
    }
}

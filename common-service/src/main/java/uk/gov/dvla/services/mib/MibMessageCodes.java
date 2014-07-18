package uk.gov.dvla.services.mib;

public interface MibMessageCodes {
    public static final String MESSAGE_POSTCODE_MISMATCH = "100";
    public static final String MESSAGE_LICENCE_EXPIRED = "101";

    public static final String BATCH_ERROR_INVALID_CHECKSUM = "200";
    public static final String BATCH_ERROR_MAX_LINES_EXCEEDED = "201";
    public static final String BATCH_ERROR_NO_GROUP_ID = "202";
    public static final String BATCH_ERROR_NO_UNIQUE_ID = "203";
    public static final String BATCH_ERROR_DIRECTORY_FOUND = "204";
    public static final String BATCH_ERROR_UNEXPECTED_FILE = "205";
    public static final String BATCH_ERROR_MULTIPLE_FILES = "206";
    public static final String BATCH_ERROR_INVALID_ZIPFILE = "207";

    public static final String VALIDATION_ERROR_MISSING_GUID = "300";
    public static final String VALIDATION_ERROR_MISSING_DLN = "301";
    public static final String VALIDATION_ERROR_MISSING_PROPOSER = "311";
    public static final String VALIDATION_ERROR_INVALID_GUID = "320";
    public static final String VALIDATION_ERROR_INVALID_DLN = "321";
    public static final String VALIDATION_ERROR_INVALID_PC = "323";
    public static final String VALIDATION_ERROR_INVALID_VRM = "324";
    public static final String VALIDATION_ERROR_INVALID_PROPOSER = "330";

    public static final String RECORD_UNAVAILABLE_DLN_NOT_FOUND = "400";
    public static final String RECORD_UNAVAILABLE_DLN_SUPPRESSED = "401";

    public static final String SERVER_ERROR = "500";
}

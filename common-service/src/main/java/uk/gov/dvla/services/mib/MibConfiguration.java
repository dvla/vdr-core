package uk.gov.dvla.services.mib;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public class MibConfiguration {
    private static MibConfiguration instance;
    private static Config config;

    private static final String MESSAGE_KEY = "message.";
    private static final String BATCH_ERROR_KEY = "batch.error.";
    private static final String VALIDATION_ERROR_KEY = "validation.error.";
    private static final String RECORD_UNAVAILABLE_KEY = "record.unavailable.";
    private static final String SERVER_ERROR_KEY = "server.error";

    private MibConfiguration() {
        // Name the config rather than going with default as there are conflicts if we have more than one application.conf on our class path
        // For more info, see: http://blog.ometer.com/2011/12/09/configuring-the-typesafe-stack/
        config = ConfigFactory.load("mib/MibMessageCodes");
    }

    public static synchronized MibConfiguration getInstance() {
        if (instance == null) {
            instance = new MibConfiguration();
        }
        return instance;
    }

    public String getMessage(String key) {
        return config.getString(MESSAGE_KEY + key);
    }

    public String getBatchError(String key) {
        return config.getString(BATCH_ERROR_KEY + key);
    }

    public String getValidationError(String key) {
        return config.getString(VALIDATION_ERROR_KEY + key);
    }

    public String getRecordUnavailable(String key) {
        return config.getString(RECORD_UNAVAILABLE_KEY + key);
    }

    public String getServerErrorKey() {
        return config.getString(SERVER_ERROR_KEY);
    }
}

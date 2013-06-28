package uk.gov.dvla.domain;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public class DomainConfiguration {

    private static DomainConfiguration instance;
    private static Config config;

    private DomainConfiguration() {
        // Name the config rather than going with default as there are conflicts if we have more than one application.conf on our class path
        // For more info, see: http://blog.ometer.com/2011/12/09/configuring-the-typesafe-stack/
        config = ConfigFactory.load("domain");
    }

    public static synchronized DomainConfiguration getInstance() {
        if (instance == null) {
            instance = new DomainConfiguration();
        }
        return instance;
    }

    public Integer getUnclaimedTestPassValidity() {
        return config.getInt("unclaimedTestPassValidity");
    }
}

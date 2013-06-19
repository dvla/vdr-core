package uk.gov.dvla.domain;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public class DomainConfiguration {

    private static DomainConfiguration instance;
    private static Config config;

    private DomainConfiguration() {
        // Loads application.conf, application.json, application.properties and reference.conf by default from class path
        // http://blog.ometer.com/2011/12/09/configuring-the-typesafe-stack/
        config = ConfigFactory.load();
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

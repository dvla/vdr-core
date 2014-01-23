package uk.gov.dvla.core;


import javax.validation.constraints.NotNull;

import java.util.*;

/**
 * Base mongo configuration that DVLA-IEP services use.
 * Does contain a list of servers, list of credentials, the database name and mongo collection
 */
public class MongoConfiguration {

    @NotNull
    private List<String> servers = Arrays.asList("localhost:27017");

    public List<String> getServers() {
        return servers;
    }

    private List<String> credentials = new ArrayList<>();

    /**
     * Returns a list of credentials in login:pass format which is used to connect with the replica sets
     */
    public List<String> getCredentials() {
        return credentials;
    }


    @NotNull
    private String database = "dvla";

    /**
     * Returns the database name, if not specified in the YAML file, it defaults to 'dvla'
     */
    public final String getDatabase() {
        return database;
    }

    @NotNull
    private String collection = "drivers";

    /**
     * Returns the mongo collection name, if not specified in the YAML file, it defaults to 'drivers'
     */
    public final String getCollection() {
        return collection;
    }
}

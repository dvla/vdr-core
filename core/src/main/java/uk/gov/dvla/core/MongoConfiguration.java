package uk.gov.dvla.core;


import com.mongodb.Mongo;
;

import javax.validation.constraints.NotNull;

import java.util.*;

/**
 * Base mongo configuration that DVLA-IEP services use.
 * Does contain a list of servers, list of credentials, the database name and mongo collection
 */
public class MongoConfiguration {

    public enum ReadPreference {
        PRIMARY, PRIMARY_PREFERRED, SECONDARY, SECONDARY_PREFERRED, NEAREST
    }

    private ReadPreference readPreference = ReadPreference.NEAREST;

    private boolean ensureIndexes = false;


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
     * @return Returns the database name, if not specified in the YAML file, it defaults to 'dvla'
     */
    public final String getDatabase() {
        return database;
    }

    @NotNull
    private String collection = "drivers";

    /**
     * @return Returns the mongo collection name, if not specified in the YAML file, it defaults to 'drivers'
     */
    public final String getCollection() {
        return collection;
    }

    /**
     * @return returns a read preference which will be used by morphia.
     */
    public com.mongodb.ReadPreference getReadPreference() {
        switch (readPreference) {
            case PRIMARY:
                return com.mongodb.ReadPreference.primary();

            case PRIMARY_PREFERRED:
                return com.mongodb.ReadPreference.primaryPreferred();

            case SECONDARY:
                return com.mongodb.ReadPreference.secondary();

            case SECONDARY_PREFERRED:
                return com.mongodb.ReadPreference.secondaryPreferred();

            case NEAREST:
                return com.mongodb.ReadPreference.nearest();

            default:
                return com.mongodb.ReadPreference.nearest();
        }
    }

    /**
     * @return returns flag if the database indexes should be ensured. Set true only for services writing to the database, defaults to 'false'
     */
    public boolean isEnsureIndexes() {
        return ensureIndexes;
    }


}

package uk.gov.dvla.core;

import com.mongodb.*;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uk.gov.dvla.services.ManagedService;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractMongoDatastore implements ManagedService {
    private static final Logger logger = LoggerFactory.getLogger(AbstractMongoDatastore.class.getName());

    private MongoClient mongoClient_i;
    private DBCollection collection_i;
    protected Datastore dataStore_i;
    private final boolean ensureIndexes;

    private AbstractMongoDatastore(List<String> servers, String database, String collection, List<String> credentials, ReadPreference readPreference, boolean ensureIndexes) {
        MongoClientOptions mongoClientOptions = MongoClientOptions.builder().readPreference(readPreference).build();
        this.ensureIndexes = ensureIndexes;
        if (credentials == null || credentials.isEmpty()) {
            mongoClient_i = new MongoClient(parseServerAddresses(servers), mongoClientOptions);
        } else {
            mongoClient_i = new MongoClient(parseServerAddresses(servers), parseCredentials(credentials, database), mongoClientOptions);
        }
    }

    public AbstractMongoDatastore(List<String> servers, String database, String collection, List<String> credentials, String packageToMap, ReadPreference readPreference, boolean ensureIndexes) throws UnknownHostException {
        this(servers, database, collection, credentials, readPreference, ensureIndexes);
        dataStore_i = prepareMorphia(mongoClient_i, database, packageToMap);
    }

    public AbstractMongoDatastore(List<String> servers, String database, String collection, List<String> credentials, Class classToMap, ReadPreference readPreference, boolean ensureIndexes) throws UnknownHostException {
        this(servers, database, collection, credentials, readPreference, ensureIndexes);
        dataStore_i = prepareMorphia(mongoClient_i, database, classToMap);
    }

    public boolean isAlive() {
        /**
         * A very arbritary check that the mongo connection is alive
         * Throws an exception if not able to do this simple check
         */
        return mongoClient_i.getDatabaseNames().size() >= 0;
    }

    @Override
    public void start() {
        // Do nothing
    }

    @Override
    public void stop() {
        mongoClient_i.close();
    }

    protected Datastore getDatastore() {
        return this.dataStore_i;
    }

    protected DBCollection getCollection() {
        return this.collection_i;
    }

    protected MongoClient getClient() {
        return this.mongoClient_i;
    }

    private Datastore prepareMorphia(MongoClient client, String database, String packageToMap) {
        logger.debug("Preparing morphia mapper for {}", packageToMap);
        Morphia morphia = new Morphia();
        Datastore datastore = null;
        morphia.mapPackage(packageToMap);

        datastore = morphia.createDatastore(client, database);
        if (ensureIndexes)
            datastore.ensureIndexes();
        return datastore;
    }

    private Datastore prepareMorphia(MongoClient client, String database, Class classToMap) {
        logger.debug("Preparing morphia mapper for {}", classToMap.getName());

        Morphia morphia = new Morphia();
        Datastore datastore = null;
        morphia.map(classToMap);

        datastore = morphia.createDatastore(client, database);

        datastore.ensureIndexes();
        return datastore;
    }

    private List<ServerAddress> parseServerAddresses(List<String> servers) {
        ArrayList<ServerAddress> addresses = new ArrayList<>();

        for (String server : servers) {
            ServerAddress serverAddress;
            try {
                String[] splitted = server.split(":");
                if (splitted.length == 2) {
                    int port = Integer.parseInt(splitted[1]);
                    serverAddress = new ServerAddress(splitted[0], port);
                } else if (splitted.length == 1) {
                    serverAddress = new ServerAddress(splitted[0]);
                } else {
                    throw new IllegalArgumentException(String.format("The string %s is not a valid server address. Ignoring", server));
                }
                addresses.add(serverAddress);
            } catch (UnknownHostException | IllegalArgumentException e) {
                logger.error(e.getMessage());
                logger.debug(e.getMessage(), e);
            }
        }
        if (addresses.isEmpty()) {
            throw new IllegalArgumentException("No valid mongo server address was provided");
        }
        return addresses;
    }

    private List<MongoCredential> parseCredentials(List<String> credentials, String database) {
        ArrayList<MongoCredential> mongoCredentials = new ArrayList<>();
        for (int i = 0; i < credentials.size(); i++) {
            String credential = credentials.get(i);
            MongoCredential mongoCredential;
            try {
                String[] splitted = credential.split(":");
                if (splitted.length == 2) {
                    mongoCredential = MongoCredential.createMongoCRCredential(splitted[0], database, splitted[1].toCharArray());
                } else {
                    throw new IllegalArgumentException(String.format("Invalid credential spotted at position %d of config list", i));
                }
                mongoCredentials.add(mongoCredential);
            } catch (IllegalArgumentException e) {
                logger.error(e.getMessage());
                logger.debug(e.getMessage(), e);
            }
        }
        if (mongoCredentials.isEmpty()) {
            throw new IllegalArgumentException("No valid mongo credentials where provided");
        }
        return mongoCredentials;

    }
}
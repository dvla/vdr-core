package uk.gov.dvla.core;

import com.mongodb.*;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uk.gov.dvla.services.ManagedService;

import java.net.UnknownHostException;

public abstract class AbstractMongoDatastore implements ManagedService
{
    private static final Logger logger = LoggerFactory.getLogger(AbstractMongoDatastore.class.getName());

    private MongoClient mongoClient_i;
    private DBCollection collection_i;
    protected Datastore dataStore_i;

    public AbstractMongoDatastore(String server, int port, String database, String collection, String username, String password) throws UnknownHostException
    {
        mongoClient_i = new MongoClient(server, port);
        dataStore_i = prepareMorphia(mongoClient_i, database, username, password);
    }

    public boolean isAlive()
    {
        /**
         * A very arbritary check that the mongo connection is alive
         * Throws an exception if not able to do this simple check
         */
        return mongoClient_i.getDatabaseNames().size() >= 0;
    }

    @Override
    public void start()
    {
        // Do nothing
    }

    @Override
    public void stop()
    {
        mongoClient_i.close();
    }

    protected Datastore getDatastore()
    {
        return this.dataStore_i;
    }

    protected DBCollection getCollection()
    {
        return this.collection_i;
    }

    protected MongoClient getClient()
    {
        return this.mongoClient_i;
    }

    private Datastore prepareMorphia(MongoClient client, String database, String username, String password) {
        logger.debug("Preparing morphia mapper");
        Morphia morphia = new Morphia();
        Datastore datastore = null;
        morphia.mapPackage("uk.gov.dvla.domain");

        if (null != username) {
            datastore = morphia.createDatastore(client,
                    database, username, password.toCharArray());
        } else {
            datastore = morphia.createDatastore(client, database);
        }
        datastore.ensureIndexes();
        return datastore;
    }
}
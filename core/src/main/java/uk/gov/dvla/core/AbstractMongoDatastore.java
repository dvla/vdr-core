package uk.gov.dvla.core;

import com.mongodb.*;
import uk.gov.dvla.services.ManagedService;

import java.net.UnknownHostException;

public abstract class AbstractMongoDatastore implements ManagedService
{
    private MongoClient mongoClient_i;
    private DBCollection collection_i;

    public AbstractMongoDatastore(String server, int port, String database, String collection, String username, String password) throws UnknownHostException
    {
        mongoClient_i = new MongoClient(server, port);
        //collection_i = prepareDatabase(mongoClient_i, database, collection, username, password);
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

    protected DBCollection getCollection()
    {
        return this.collection_i;
    }

    protected MongoClient getClient()
    {
        return this.mongoClient_i;
    }
}

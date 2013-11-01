package uk.gov.dvla.core;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class MongoConfiguration {
    @NotNull
    private String database = "dvla";

    @NotNull
    private String server = "localhost";

    @Min(1)

    @Max(65535)
    private int port = 27017;

    @NotNull
    private String collection = "drivers";

    private String username;

    private String password;

    public final String getDatabase() {
        return database;
    }

    public final void setDatabase(String database) {
        this.database = database;
    }

    public final String getServer() {
        return server;
    }

    public final void setServer(String server) {
        this.server = server;
    }

    public final int getPort() {
        return port;
    }

    public final void setPort(int port) {
        this.port = port;
    }

    public final String getUsername() {
        return username;
    }

    public final void setUsername(String username) {
        this.username = username;
    }

    public final String getPassword() {
        return password;
    }

    public final void setPassword(String password) {
        this.password = password;
    }

    public final String getCollection() {
        return collection;
    }

    public final void setCollection(String collection) {
        this.collection = collection;
    }

    @Override
    public String toString() {
        return String.format("MongoConfiguration: Server %s  Port: %s DB: %s Collection: %s", server, port, database, collection);
    }
}

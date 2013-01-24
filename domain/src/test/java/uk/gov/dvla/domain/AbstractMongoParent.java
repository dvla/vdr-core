package uk.gov.dvla.domain;

import java.net.UnknownHostException;

import org.junit.After;
import org.junit.Before;

import com.google.code.morphia.Datastore;
import com.google.code.morphia.Morphia;
import com.mongodb.Mongo;
import com.mongodb.MongoException;

public abstract class AbstractMongoParent {
	
	private Mongo mongo_i;
	private Datastore ds_i = null;

	@Before
	public void setup() throws UnknownHostException, MongoException {

		mongo_i = new Mongo("localhost");
		Morphia m = new Morphia();
		m.map(Address.class).map(Country.class).map(Driver.class)
				.map(DriverFlag.class).map(DriverNumber.class).map(Name.class)
				.map(Person.class);
		ds_i = m.createDatastore(mongo_i, "demos2");
	}

	@After
	public void teardown() {

		mongo_i.close();
	}
	
	protected Datastore getDs(){
		return ds_i;
	}

}

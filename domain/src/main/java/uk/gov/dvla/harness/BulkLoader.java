package uk.gov.dvla.harness;

import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import uk.gov.dvla.domain.Address;
import uk.gov.dvla.domain.Country;
import uk.gov.dvla.domain.Driver;
import uk.gov.dvla.domain.DriverFlag;
import uk.gov.dvla.domain.DriverNumber;
import uk.gov.dvla.domain.Name;
import uk.gov.dvla.domain.Person;

import com.google.code.morphia.Datastore;
import com.google.code.morphia.Morphia;
import com.mongodb.Mongo;
import com.mongodb.MongoException;

public class BulkLoader {

	private static final String FMT = "dd/MM/yyyy HH:mm:ss.SSS";

	private static final int DEFAULT_BATCH_SIZE = 10;
	private static final int DEFAULT_IT_SIZE = 10;
	private static final long FINAL_INSERT = 45000000;
	
	private static final String CONN_STR = "Connecting to %s:%d database '%s'";
	private static final String LOAD_START = "About to load %,d documents";

	private static final String BATCH_CONFIRM = "Added batch %3d in %,4dms";
	private static final String LOAD_CONFIRM = "\nAdded %,d documents in %,4dms";
	private static final String TIME = "Time taken %dms";
	// private static final String EST =
	// "Estimated time for %,d documents: %d hours %d mins";

	private static final String EST = "\n\t%10s %10s %10s %8s %8s\n"
			+ "Sample\t%,10d %,12d %10.2f %8.2f %8.2f\n"
			+ "Est.\t%,10d %,12d %10.2f %8.2f %8.2f";


	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		System.out.println("Starting BulkLoader..");
		
		String server = "localhost";
		int port = 27017;
		String db = "test";

		long start = System.currentTimeMillis();
		int batchSize = DEFAULT_BATCH_SIZE;
		int iterations = DEFAULT_IT_SIZE;
		int threads = 1;
		long docTotal = 0;

		if (null == args || args.length == 0) 
		{
			System.out.println("Expected usage:  java -jar <name>.jar <server> <port> <database> <batchSize> <iterations> <threads>");
			System.out.println("          e.g.:  java -jar BulkLoader.jar localhost 27017 test 10 10 2");
		} 
		else 
		{
			server = args[0];
			port = Integer.parseInt(args[1]);
			db = args[2];
			batchSize = Integer.parseInt(args[3]);
			iterations = Integer.parseInt(args[4]);
			threads = Integer.parseInt(args[5]);

			System.out.println(String.format(CONN_STR, server, port, db));
			System.out.println(String.format(LOAD_START, batchSize*iterations*threads));
			
			ExecutorService exe = Executors.newFixedThreadPool(threads);
			List<Future<LoadResult>> futures = new ArrayList<Future<LoadResult>>();
			for (int i=1; i<threads+1; i++)
			{
				Callable<LoadResult> loader = new BulkLoadThread(server, port, db, batchSize, iterations, i);
				Future<LoadResult> future = exe.submit(loader);
				futures.add(future);
			}			
			
			exe.shutdown();
			
			for (Future<LoadResult> result : futures)
			{
				docTotal += result.get().getDocs();				
			}

			long end = System.currentTimeMillis();
			long duration = end-start;
			
			long fullBatch = FINAL_INSERT / docTotal * duration;

			System.out.println(String.format(LOAD_CONFIRM, docTotal, duration));
			
			System.out.println(String.format(EST, 
					"Number", "(ms)", "(sec)", "(mins)", "(hrs)", 
					docTotal, duration,	duration / 1000f, duration / 1000 / 60f, duration / 1000 / 60 / 60f, 
					FINAL_INSERT, fullBatch, fullBatch / 1000f, fullBatch / 1000 / 60f,	fullBatch / 1000 / 60 / 60f));
					
		}
	}
	
	public static class LoadResult
	{
		private long docs_i;
		private long duration_i;
		
		public LoadResult(long docs, long duration)
		{
			docs_i = docs;
			duration_i = duration;
		}
		
		public long getDocs()
		{
			return docs_i;
		}
		
		public long getDuration()
		{
			return duration_i;
		}
	}

	public static class BulkLoadThread implements Callable<LoadResult> 
	{
		private Mongo mongo_i;
		private Datastore ds_i = null;
		
		private int batchSize_i;
		private int iterations_i;
		private int total_i;
		private int threadId_i;
		
		public BulkLoadThread(String server, int port, String db, int batchSize, int iterations, int threadId)
				throws UnknownHostException, MongoException 
		{
			batchSize_i = batchSize;
			iterations_i = iterations;
			threadId_i = threadId;
			total_i = batchSize * iterations;
			mongo_i = new Mongo(server, port);
			
			Morphia m = new Morphia();
			m.map(Address.class).map(Country.class).map(Driver.class)
					.map(DriverFlag.class).map(DriverNumber.class)
					.map(Name.class).map(Person.class);
			ds_i = m.createDatastore(mongo_i, db);
		}

		public LoadResult call() {
			long startTime = System.currentTimeMillis();
			DriverRandomiser random = new DriverRandomiser();

			for (int i = 1; i < iterations_i + 1; i++) {
				long bStart = System.currentTimeMillis();
				List<Driver> drivers = new ArrayList<Driver>();
				for (int b = 0; b < batchSize_i; b++) {
					drivers.add(random.randomise());
				}

				ds_i.save(drivers);
				long bEnd = System.currentTimeMillis();

				log(String.format(BATCH_CONFIRM, i, bEnd - bStart));

			}
			long endTime = System.currentTimeMillis();
			long duration = endTime - startTime;
			log("Finished!");

			return new LoadResult(total_i, duration);
		}

		private void log(String log) {
			SimpleDateFormat sdf = new SimpleDateFormat(FMT);
			System.out.println(sdf.format(new Date()) + " [Thread #" + threadId_i + "]: " + log);
		}
	}

}
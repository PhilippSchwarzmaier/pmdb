package work.schwarzmaier.dataGenerator.db;

import java.util.Arrays;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoDatabase;

import work.schwarzmaier.dataGenerator.utils.Config;

@ApplicationScoped
public class DBConnector {

	public DBConnector() {
	}

	@Produces
	public MongoClient createMongo() {
		String mongoDb_User = System.getenv("DB_MONGODB_USER");
		String mongoDb_Password = System.getenv("DB_MONGODB_PASSWORD");
		Config config = new Config();

		MongoCredential creds = MongoCredential.createCredential(mongoDb_User, config.getDbName(),
				mongoDb_Password.toCharArray());
		ServerAddress serverAddress = new ServerAddress(config.getDbUrl(), Integer.valueOf(config.getDbPort()));
		return new MongoClient(serverAddress, Arrays.asList(creds), new MongoClientOptions.Builder().build());
	}

	@Produces
	public MongoDatabase createDB(MongoClient client) {
		return client.getDatabase("test");
	}

	public void close(@Disposes MongoClient toClose) {
		toClose.close();
	}
}

package work.schwarzmaier.db;

import java.util.Arrays;
import java.util.function.Consumer;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoDatabase;

import com.mongodb.client.MongoIterable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import work.schwarzmaier.utils.Config;

@ApplicationScoped
public class MongoDBConnectionProducer {

    private static final Logger LOGGER = LogManager.getLogger(MongoDBConnectionProducer.class.getName());

    @Produces
    public MongoClient createMongo() {
        String mongoDb_User = System.getenv("DB_MONGODB_USER");
        String mongoDb_Password = System.getenv("DB_MONGODB_PASSWORD");
        Config config = new Config();

        MongoCredential creds = MongoCredential.createCredential(mongoDb_User, config.getDbName(), mongoDb_Password.toCharArray());
        LOGGER.info("mongo cred {}", creds.toString());
        ServerAddress serverAddress = new ServerAddress(config.getDbUrl(), Integer.valueOf(config.getDbPort()));
        LOGGER.info("mongo address {}", serverAddress.toString());
        return new MongoClient(serverAddress, creds, new MongoClientOptions.Builder().build());
    }

	@Produces
    public MongoDatabase createDB(MongoClient client) {
        Config config = new Config();
        return client.getDatabase(config.getDbName());
    }

    public void close(@Disposes MongoClient toClose) {
        toClose.close();
    }
}

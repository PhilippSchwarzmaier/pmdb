package work.schwarzmaier.db;

import java.util.Arrays;
import java.util.function.Consumer;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.*;

import com.mongodb.connection.ServerSettings;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import work.schwarzmaier.model.Movie;
import work.schwarzmaier.utils.Config;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

@ApplicationScoped
public class MongoDBConnectionProducer {

    private static final Logger LOGGER = LogManager.getLogger(MongoDBConnectionProducer.class.getName());

//    @Produces
//    public MongoClient createMongo() {
//        String mongoDb_User = System.getenv("DB_MONGODB_USER");
//        String mongoDb_Password = System.getenv("DB_MONGODB_PASSWORD");
//        Config config = new Config();
//
//        MongoCredential creds = MongoCredential.createCredential(mongoDb_User, config.getDbName(), mongoDb_Password.toCharArray());
//        LOGGER.info("mongo cred {}", creds.toString());
//        ServerAddress serverAddress = new ServerAddress(config.getDbUrl(), Integer.valueOf(config.getDbPort()));
//        LOGGER.info("mongo address {}", serverAddress.toString());
//        return new MongoClient(serverAddress, creds, new MongoClientOptions.Builder().build());
//    }

    @Produces
    public MongoDatabase createDB(MongoClient client) {
        Config config = new Config();
        return client.getDatabase(config.getDbName());
    }

    @Produces
    public MongoClient createDB() {
        Config config = new Config();

        CodecRegistry pojoCodecRegistry = fromProviders(PojoCodecProvider.builder().automatic(true).build());
        CodecRegistry codecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(), pojoCodecRegistry);

        String mongoDb_User = System.getenv("DB_MONGODB_USER");
        String mongoDb_Password = System.getenv("DB_MONGODB_PASSWORD");
        final String uriString = "mongodb://" + mongoDb_User + ":" + mongoDb_Password + "@" + config.getDbUrl() + ":" + config.getDbPort() + "/" + config.getDbName();

        ConnectionString connectionString = new ConnectionString(uriString);
        MongoCredential creds = MongoCredential.createCredential(mongoDb_User, config.getDbName(), mongoDb_Password.toCharArray());

        MongoClientSettings clientSettings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .codecRegistry(codecRegistry)
                .build();
        try {
            return MongoClients.create(clientSettings);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public void close(@Disposes MongoClient toClose) {
        toClose.close();
    }
}

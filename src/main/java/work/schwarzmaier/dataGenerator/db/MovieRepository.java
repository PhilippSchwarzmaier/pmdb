package work.schwarzmaier.dataGenerator.db;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MovieRepository {

	@Inject
	private MongoDatabase db;

	public MovieRepository() {
	}

	public void test() {
		DBConnector dbConnector = new DBConnector();
		MongoClient client = dbConnector.createMongo();
		MongoDatabase db1 = dbConnector.createDB(client);
		MongoCollection<Document> dbCollection = db1.getCollection("movie");
		FindIterable<Document> dbObject = dbCollection.find();
		String na = (String) dbObject.first().get("_id");
		System.out.println(na);
	}

	public void fillWithTestData() {
		Map<String, Object> map = new HashMap<>();
		map.put("_id", "123");
		Document document = new Document(map);
		db.createCollection("movie");
		MongoCollection<Document> dbCollection = db.getCollection("movie");
		dbCollection.insertOne(document);

	}

	public void save(List<Document> map) {
		DBConnector dbConnector = new DBConnector();
		MongoClient client = dbConnector.createMongo();
		MongoDatabase db1 = dbConnector.createDB(client);
		db1.createCollection("movies");
		MongoCollection<Document> dbCollection = db1.getCollection("movies");
		dbCollection.insertMany(map);
	}

	public long getCount() {
		return db.getCollection("movies").count();
	}
}

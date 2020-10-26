package work.schwarzmaier.db.repo;

import com.mongodb.client.MongoCollection;
import org.bson.Document;

import java.util.List;

public interface MovieRepository {

    void save(List<Document> map);

    Iterable<Document> getAllTitle();

    Document getFirst();
}

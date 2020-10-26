package work.schwarzmaier.db.repo;

import java.util.*;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Projections;
import org.bson.Document;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.conversions.Bson;

@ApplicationScoped
public class MovieRepositoryImpl implements MovieRepository  {

    @Inject
    private MongoDatabase db;

    private static final String COLLECTIONNAME = "movies";

    public MovieRepositoryImpl() {
    }

    private MongoCollection<Document> getMovieCollection() {
        return db.getCollection(COLLECTIONNAME);
    }
    public void save(List<Document> map) {
        getMovieCollection().insertMany(map);
    }
    public Iterable<Document> getAllTitle() {
        Bson limit = Aggregates.limit(10);
        Bson project = Aggregates.project(Projections.fields(Projections.include("Title")));
        return getMovieCollection().aggregate(Arrays.asList(project, limit));
    }

    public long getCount() {
        return getMovieCollection().count();
    }

    public Document getFirst() {
        return getMovieCollection().find().first();
    }
}

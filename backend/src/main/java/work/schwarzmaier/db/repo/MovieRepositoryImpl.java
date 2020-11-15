package work.schwarzmaier.db.repo;

import java.io.Serializable;
import java.util.*;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Projections;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.conversions.Bson;
import work.schwarzmaier.model.Movie;

@ApplicationScoped
public class MovieRepositoryImpl implements MovieRepository, Serializable {

    @Inject
    private MongoDatabase db;

    private static final String COLLECTIONNAME = "movies";

    private MongoCollection<Movie> getMovieCollection() {

       return db.getCollection(COLLECTIONNAME, Movie.class);
    }

    public List<Movie> getAllTitle() {
        Bson limit = Aggregates.limit(10);
        Bson project = Aggregates.project(Projections.fields(Projections.include("Title")));
        return getMovieCollection().aggregate(Arrays.asList(project, limit), Movie.class).into(new ArrayList<>());
    }

    public Movie getFirst() {
        return getMovieCollection().find().first();
    }

}

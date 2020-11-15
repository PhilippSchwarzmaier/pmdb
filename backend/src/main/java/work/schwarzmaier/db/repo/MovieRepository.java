package work.schwarzmaier.db.repo;

import org.bson.Document;
import work.schwarzmaier.model.Movie;

import java.util.List;

public interface MovieRepository {

    List<Movie> getAllTitle();

    Movie getFirst();

}

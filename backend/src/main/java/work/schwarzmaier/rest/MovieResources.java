package work.schwarzmaier.rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bson.Document;
import work.schwarzmaier.db.repo.MovieRepository;
import work.schwarzmaier.model.Movie;

import java.util.List;

@Path("movies")
public class MovieResources {

	private static final Logger LOGGER = LogManager.getLogger(MovieResources.class.getName());

	@Inject
	private MovieRepository movieRepository;
	
	@GET

	@Produces(MediaType.APPLICATION_JSON)
	public List<Movie> getMovies() {
		return movieRepository.getAllTitle();
	}

	@GET
	@Path("one")
	@Produces(MediaType.APPLICATION_JSON)
	public Movie getMovie1() {
		 return movieRepository.getFirst();
	}

}

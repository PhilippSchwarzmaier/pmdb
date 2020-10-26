package work.schwarzmaier.rest;

import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.bson.Document;
import work.schwarzmaier.db.repo.MovieRepository;

@Path("movies")
public class MovieResources {

	@Inject
	private MovieRepository movieRepository;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public JsonArray getMovies() {

		JsonArrayBuilder jsonArrayBuilder = Json.createArrayBuilder();
		Iterable<Document> listOfAllTitle = movieRepository.getAllTitle();
		for (Document document : listOfAllTitle) {
			jsonArrayBuilder.add(document.toJson());

		}
		return jsonArrayBuilder.build();
	}

	@GET
	@Path("one")
	@Produces(MediaType.APPLICATION_JSON)
	public Document getMovie(){
		return movieRepository.getFirst();
	}

}

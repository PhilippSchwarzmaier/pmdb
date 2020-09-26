package work.schwarzmaier.rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import com.mongodb.client.MongoDatabase;

@Path("movies")
public class MovieResoures {
	
	
	@Inject
	private MongoDatabase db;
	
	@GET
	public String getMovies() {
		
		String count = ""+db.getCollection("movies").find().first().toString();
		return "test "+count;
	}

}

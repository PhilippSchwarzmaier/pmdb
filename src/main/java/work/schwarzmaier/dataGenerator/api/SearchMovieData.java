package work.schwarzmaier.dataGenerator.api;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

public class SearchMovieData {

	public MovieData fetch(String movieName) {
		String apiKey = System.getenv("APIKEY");
		Client client = ClientBuilder.newClient();
		StringBuilder url = new StringBuilder("http://www.omdbapi.com/?apikey=");
		url.append(apiKey);
		url.append("&t=");
		url.append(movieName);
		MovieData result = client.target(url.toString()).request(MediaType.APPLICATION_JSON_TYPE).get(MovieData.class);

		return result;
	}
}

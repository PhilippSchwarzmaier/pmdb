package work.schwarzmaier.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bson.codecs.pojo.annotations.BsonCreator;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Movie implements Serializable {

	private static final long serialVersionUID = 1234L;

	private ObjectId id;
   @BsonProperty(value="Title")
    private String title;
	 @BsonProperty(value="Year")
    private String year;
	 @BsonProperty(value="Runtime")
    private String runtime;
	 @BsonProperty(value="Genre")
    private String genre;
	 @BsonProperty(value="Director")
    private String director;
	 @BsonProperty(value="Actors")
    private String ctors;
	 @BsonProperty(value="Poster")
    private String poster;
	 @BsonProperty(value="Plot")
    private String plot;
	@BsonProperty(value="imdbRating")
    private String imdbRating;
	@BsonProperty(value="Metascore")
    private String metascore;
//    @JsonIgnore
//    private String path;


	public Movie() {
	}

//	@BsonCreator
//	public Movie(@BsonProperty(value = "Title") String title,
//				 @BsonProperty(value = "Year")String year,
//				 @BsonProperty(value = "Runtime")String runtime,
//				 @BsonProperty(value = "Genre")String genre,
//				 @BsonProperty(value = "Director")String director,
//				 @BsonProperty(value = "Ctors")String ctors,
//				 @BsonProperty(value = "Poster") String poster,
//				 @BsonProperty(value = "Plot")String plot,
//				 @BsonProperty(value = "imdbRating")String imdbRating,
//				 @BsonProperty(value = "Metascore")String metascore) {
//		this.title = title;
//		this.year = year;
//		this.runtime = runtime;
//		this.genre = genre;
//		this.director = director;
//		this.ctors = ctors;
//		this.poster = poster;
//		this.plot = plot;
//		this.imdbRating = imdbRating;
//		this.metascore = metascore;
//	}

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getRuntime() {
		return runtime;
	}

	public void setRuntime(String runtime) {
		this.runtime = runtime;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getCtors() {
		return ctors;
	}

	public void setCtors(String ctors) {
		this.ctors = ctors;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public String getPlot() {
		return plot;
	}

	public void setPlot(String plot) {
		this.plot = plot;
	}

	public String getImdbRating() {
		return imdbRating;
	}

	public void setImdbRating(String imdbRating) {
		this.imdbRating = imdbRating;
	}

	public String getMetascore() {
		return metascore;
	}

	public void setMetascore(String metascore) {
		this.metascore = metascore;
	}

//	public String getPath() {
//		return path;
//	}
//
//	public void setPath(String path) {
//		this.path = path;
//	}


	

}

package work.schwarzmaier.dataGenerator;

import java.net.UnknownHostException;
import java.util.List;
import java.util.Set;

import org.bson.Document;

import work.schwarzmaier.dataGenerator.api.SearchMovieData;
import work.schwarzmaier.dataGenerator.db.MovieRepository;
import work.schwarzmaier.dataGenerator.extractFileNames.CSVReader;
import work.schwarzmaier.dataGenerator.extractFileNames.ReadFolderContent;
import work.schwarzmaier.dataGenerator.utils.Config;


public class App {

	public static void main(String[] args) throws UnknownHostException {
//		fetchMovieData();
		dbConnection();
//		searchMovies();
	}

	public static void dbConnection() throws UnknownHostException {

		MovieRepository movieRepository = new MovieRepository();
//		movieRepository.fillWithTestData();
		movieRepository.test();

	}

	public static void fetchMovieData() {
		SearchMovieData searchMovieData = new SearchMovieData();
		searchMovieData.fetch(null);
	}

	public static void fetchMovies() {
		Config config = new Config();
		String movieFolderPathsCSV = config.getMovieFolderPathsCSV();
		String movieListFile = config.getMovieListFile();

		String[] paths = CSVReader.readMovieFolderPathFile(movieFolderPathsCSV);
		Set<MoviePathData> movies = ReadFolderContent.read(paths);
		
	}

	public static void searchMovies() {
		Config config = new Config();
		String movieListFile = config.getMovieListFile();
		List<Document> renderMovieDataList = CSVReader.readMovieListFile(movieListFile);
		MovieRepository movieRepository = new MovieRepository();
		movieRepository.save(renderMovieDataList);
	}
}

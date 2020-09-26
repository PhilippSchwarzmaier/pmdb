package work.schwarzmaier.dataGenerator.extractFileNames;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.bson.Document;

import com.fasterxml.jackson.databind.ObjectMapper;

import work.schwarzmaier.dataGenerator.api.MovieData;
import work.schwarzmaier.dataGenerator.api.SearchMovieData;


public class CSVReader {

	public static String[] readMovieFolderPathFile(String csvFile) {

		List<String> paths = new ArrayList<String>();

		String path = CSVReader.class.getClassLoader().getResource(csvFile).getPath();

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			String line = "";

			while ((line = br.readLine()) != null) {
				paths.add(line);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		String[] result = new String[paths.size()];
		return paths.toArray(result);
	}

	public static List<Document> readMovieListFile(String csvFile) {

		String path = csvFile;

		List<Document> renderedMovieDataList = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			String line = "";

			for (int i = 0; i < 10; ++i) {
//			while ((line = br.readLine()) != null) {
				line = br.readLine();

				renderedMovieDataList.add(renderMovieData(line));
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return renderedMovieDataList;

	}

	private static Document renderMovieData(String line) {

		String cvsSplitBy = ";";
		String[] rawMovieData = line.split(cvsSplitBy);
		String movieName = rawMovieData[1].replace(" ", "_");
		String moviePath = rawMovieData[2];

		SearchMovieData searchMovieData = new SearchMovieData();
		MovieData result = searchMovieData.fetch(movieName);

		if (result.getTitle() == null) {
			result.setTitle(movieName);
		} else {
			result.setPath(moviePath);
		}

		ObjectMapper objectMapper = new ObjectMapper();

		return new Document(objectMapper.convertValue(result, Map.class));
	}
}

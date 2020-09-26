package work.schwarzmaier.dataGenerator.extractFileNames;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Set;
import java.util.StringJoiner;

import work.schwarzmaier.dataGenerator.MoviePathData;

public class CSVWriter {

	public static void write(String csvFile, Set<MoviePathData> movies) {
		File csvOutputFile = new File(csvFile);
		try (PrintWriter pw = new PrintWriter(csvOutputFile)) {
			movies.stream().map(movie -> convertToCSV(movie)).forEach(pw::println);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	private static String convertToCSV(MoviePathData movie) {
		StringJoiner result = new StringJoiner(";");
		result.add(movie.getFileName());
		result.add(movie.getName());
		result.add(movie.getPath());
		return result.toString();
	}
}

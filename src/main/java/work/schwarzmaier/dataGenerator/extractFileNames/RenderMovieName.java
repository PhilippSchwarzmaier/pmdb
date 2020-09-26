package work.schwarzmaier.dataGenerator.extractFileNames;

import java.util.Set;
import java.util.StringJoiner;

import work.schwarzmaier.dataGenerator.MoviePathData;

public class RenderMovieName {

	public static void render(Set<MoviePathData> movies) {
		for (MoviePathData movie : movies) {
			render(movie);
		}
	}

	public static void render(MoviePathData movie) {

		String movieName = "";
		try {
			String[] splitMovieName = movie.getFileName().split("_");
			if (splitMovieName.length == 1) {

				if (movie.getFileName().indexOf("vom") == -1) {
					movieName = movie.getFileName().replace(".avi", "");
				} else {
					String[] splitSpace = movie.getFileName().split(" ");
					for (int i = 0; i < splitSpace.length; i++) {
						if (splitSpace[i].equals("vom")) {
							movieName = mergeName(splitSpace, i);
							break;
						}
					}
				}

			} else {
				for (int i = 0; i < splitMovieName.length; i++) {
					char[] check = splitMovieName[i].toCharArray();
					if ((check.length > 0 && Character.isDigit(check[0]))
							&& (check.length > 1 && Character.isDigit(check[1]))
							&& (check.length > 2 && check[2] == '.')) {
						movieName = mergeName(splitMovieName, i);
						break;
					}
				}
			}

			if (movieName != "" || movieName.length() != 0) {
				movie.setName(movieName.trim().replace("  ", " "));
			}

		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Error:" + movie.getFileName());
		}
	}

	private static String mergeName(String[] names, int count) {
		StringJoiner result = new StringJoiner(" ");
		for (int i = 0; i < count; i++) {
			result.add(names[i]);
		}
		return result.toString();
	}
}

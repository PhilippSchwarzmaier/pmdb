package work.schwarzmaier.dataGenerator.utils;

public class Config extends PropertiesReader {

	private final static String CONFIG_PROPERTIES = "config.properties";

	private static String MOVIE_FOLDER_PATHS_CSV = "movieFolderPathsCSV";
	private static String MOVIE_LIST_FILE = "movieListFile";
	private static String DB_NAME = "dbName";
	private static String DB_PORT = "dbPort";
	private static String DB_URL = "dbUrl";

	public Config() {
		super(CONFIG_PROPERTIES);
	}

	public String getMovieFolderPathsCSV() {
		return super.get(MOVIE_FOLDER_PATHS_CSV);
	}

	public String getMovieListFile() {
		return super.get(MOVIE_LIST_FILE);
	}

	public String getDbName() {
		return super.get(DB_NAME);
	}

	public String getDbPort() {
		return super.get(DB_PORT);
	}

	public String getDbUrl() {
		return super.get(DB_URL);
	}
}

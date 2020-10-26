package work.schwarzmaier.utils;

import work.schwarzmaier.utils.PropertiesReader;

public class Config extends PropertiesReader {

	private final static String CONFIG_PROPERTIES = "config.properties";
	private static String DB_NAME = "dbName";
	private static String DB_PORT = "dbPort";
	private static String DB_URL = "dbUrl";

	public Config() {
		super(CONFIG_PROPERTIES);
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

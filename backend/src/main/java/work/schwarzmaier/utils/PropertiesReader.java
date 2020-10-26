package work.schwarzmaier.utils;

import java.io.IOException;
import java.util.Properties;

public abstract class PropertiesReader {

	private Properties properties;

	public PropertiesReader(String path) {
		properties = new Properties();
		load(path);
	}

	private void load(String path) {
		try {
			properties.load(getClass().getClassLoader().getResourceAsStream(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	protected String get(String property) {
		return properties.getProperty(property);
	}
}

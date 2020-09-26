package work.schwarzmaier.dataGenerator;

public class MoviePathData {

	private String fileName;
	private String path;
	private String name;

	public MoviePathData(String fileName, String path, String name) {
		this.fileName = fileName;
		this.path = path;
		this.name = name;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}

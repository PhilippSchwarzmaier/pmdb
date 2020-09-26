package work.schwarzmaier.dataGenerator.extractFileNames;

import java.net.MalformedURLException;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.lang3.ArrayUtils;

import jcifs.smb.SmbException;
import jcifs.smb.SmbFile;
import work.schwarzmaier.dataGenerator.MoviePathData;

public class ReadFolderContent {

	public static Set<MoviePathData> read(String[] paths) {
		SmbFile[] smbFiles = new SmbFile[0];
		for (String path : paths) {
			SmbFile dir = null;
			try {
				dir = new SmbFile(path);
				smbFiles = ArrayUtils.addAll(smbFiles, dir.listFiles());
			} catch (SmbException | MalformedURLException e) {
				e.printStackTrace();
			}
		}
		return Arrays.stream(smbFiles).map(smbFile -> new MoviePathData(smbFile.getName(), smbFile.getPath(), null))
				.collect(Collectors.toSet());
	}
}

package algorithm;

import java.io.File;

public class fileNum {

	public void fileNum(String path) {
		File[] list = new File(path).listFiles();
		int fileCount = 0;
		int folderCount = 0;
		long length = 0;
		for (File file : list) {
			if (file.isFile()) {
				fileCount++;
				length += file.length();
			} else {
				folderCount++;
			}
		}
	}

}

package michael.ye.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyFile {
	private static Logger LOGGER = LoggerFactory.getLogger(MyFile.class);

	/**
	 * Read content from file
	 * 
	 * @param filePathAndName
	 * @return
	 */
	public static String read(String filePathAndName) {
		LOGGER.debug("Reading from " + filePathAndName);
		StringBuffer sb = new StringBuffer();
		try {
			String encoding = "GBK";
			File file = new File(filePathAndName);
			if (file.isFile() && file.exists()) { // check file existed or not
				InputStreamReader read = new InputStreamReader(new FileInputStream(file), encoding);// 考虑到编码格式
				BufferedReader bufferedReader = new BufferedReader(read);
				String lineTxt = null;
				while ((lineTxt = bufferedReader.readLine()) != null) {
					sb.append(lineTxt +System.getProperty("line.separator"));
				}
				read.close();
			} else {
				LOGGER.error("File " + filePathAndName + " is not found!");
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sb.deleteCharAt(sb.length()-1).toString();
	}

	/**
	 * Write content to file NOTE: delete the file if the file already existed
	 * and create a new one
	 * 
	 * @param filePathAndName
	 * @param StringBuffer
	 */
	public static void WriteTxtFile(String filePathAndName, StringBuffer stringBuffer) {
		WriteTxtFile(filePathAndName, stringBuffer.toString());
	}

	/**
	 * Write content to file NOTE: delete the file if the file already existed
	 * and create a new one
	 * 
	 * @param filePathAndName
	 * @param str
	 */
	public static void WriteTxtFile(String filePathAndName, String str) {
		LOGGER.debug("Writing " + str + " to " + filePathAndName);

		// deletFileIfExist(filePathAndName);
		FileWriter fw = null;
		try {
			fw = new FileWriter(filePathAndName, true);
			fw.write(str);

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}

	/**
	 * Delete the file
	 * 
	 * @param filePath
	 */
	public static void deletFileIfExist(String filePath) {
		LOGGER.debug("Deleting " + filePath);

		File file = new File(filePath);
		if (!file.getParentFile().exists()) {
			file.getParentFile().mkdirs();
			return;
		}
		if (file.exists()) {
			file.delete();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}
	}

	/**
	 * Create folder if not existed
	 * 
	 * @param folderPath
	 */
	public static void createFolderIfNotExist(String folderPath) {
		LOGGER.debug("Create folders if " + folderPath + " not existed");

		File file = new File(folderPath);
		if (!file.exists()) {
			file.mkdirs();
		}
	}

	/**
	 * Get all file name in the {path}
	 * 
	 * @param path
	 * @return
	 */
	public static List<String> getFileNameList(String path) {
		LOGGER.debug("Get all file name in the " + path);

		List<String> fileList = new ArrayList<String>();
		File file = new File(path);
		if (!file.exists()) {
			return null;
		} else {
			// get the folder list
			File[] array = file.listFiles();

			for (int i = 0; i < array.length; i++) {
				if (array[i].isFile()) {

					// only add file name
					fileList.add(array[i].getName());

					// add file path and file name
					// fileList.add(array[i]);

					// add file path
					// fileList.add(array[i].getPath());
				}
			}
		}
		return fileList;
	}
}

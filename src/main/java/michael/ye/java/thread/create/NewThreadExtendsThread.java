package michael.ye.java.thread.create;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import michael.ye.util.MyFile;

public class NewThreadExtendsThread extends Thread {
	private static Logger LOGGER = LoggerFactory.getLogger(NewThreadExtendsThread.class);

	String outputFileName;

	public NewThreadExtendsThread(String fileName) {
		this.outputFileName = fileName;
		MyFile.deletFileIfExist(outputFileName);
	}

	public void run() {
		for (int i = 0; i < 30; i++) {
			String str = "this is new thread extends Thread:" + i;
			LOGGER.info(str);
			MyFile.WriteTxtFile(outputFileName, str+System.getProperty("line.separator"));
			
			int random = (int) (Math.random() * 200);
			try {
				Thread.sleep(random);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

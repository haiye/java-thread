package michael.ye.java.thread.create;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import michael.ye.util.MyFile;

public class NewThreadImplementsRunnable implements Runnable {
	private static Logger LOGGER = LoggerFactory.getLogger(NewThreadExtendsThread.class);

	String outputFileName;

	public NewThreadImplementsRunnable(String fileName) {
		this.outputFileName = fileName;
	}

	public void run() {
		for (int i = 0; i < 30; i++) {
			String str = "this is new thread implements Runnable:" + i;
			LOGGER.info(str);
			MyFile.WriteTxtFile(outputFileName, str);

			int random = (int) (Math.random() * 200);
			try {
				Thread.sleep(random);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}

package michael.ye.java.thread.create;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import michael.ye.util.MyFile;

public class NewThreadTest {
	private static Logger LOGGER = LoggerFactory.getLogger(NewThreadTest.class);

	/*
	 * 通过start方法开启线程
	 */
	@Test
	public static void extendsTestByStart() {
		String fileName="test-result-600/extendsTestByStart.txt";
		MyFile.deletFileIfExist(fileName);
		MyFile.WriteTxtFile(fileName, "extendsTestByStart begin");
		NewThreadExtendsThread threadTest = new NewThreadExtendsThread(fileName);
		threadTest.start();
		MyFile.WriteTxtFile(fileName, "extendsTestByStart end");
		String strRead=MyFile.read(fileName);
		System.out.println(strRead);
	}

	/*
	 * 通过run方法开启线程
	 */
//	@Test
	public static void extendsTestByRun() {
		System.out.println("extendsTestByRun function begin");
		NewThreadExtendsThread threadTest = new NewThreadExtendsThread("src/test-result/extendsTestByRun.txt");
		threadTest.run();
		System.out.println("extendsTestByRun function end");
	}

//	@Test
	public static void implementsTestByStart() {
		System.out.println("implementsTest function begin");
		NewThreadImplementsRunnable threadTest = new NewThreadImplementsRunnable(
				"src/test-result/implementsTestByStart.txt");
		Thread newThread = new Thread(threadTest);
		newThread.start();
		System.out.println("implementsTest function end");
	}
}

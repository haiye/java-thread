package michael.ye.java.thread.create;

public class NewThread {

	public static void main(String[] args) {
	System.out.println("aa:"+System.getProperty("line.separator","null")+"end");
		
		extendsTestByStart();
//		extendsTestByRun();
	}
	
	/*
	 * 通过start方法开启线程
	 */
	public static void extendsTestByStart(){
		System.out.println("extendsTestByStart function begin");
		NewThreadExtendsThread threadTest = new NewThreadExtendsThread("test-result-600/extendsTestByStart.txt");
		threadTest.start();
		System.out.println("extendsTestByStart function end");
	}
	/*
	 * 通过run方法开启线程
	 */
	public static void extendsTestByRun(){
		System.out.println("extendsTestByRun function begin");
		NewThreadExtendsThread threadTest = new NewThreadExtendsThread("src/test-result/extendsTestByRun.txt");
		threadTest.run();
		System.out.println("extendsTestByRun function end");
	}
	public static void implementsTestByStart(){
		System.out.println("implementsTest function begin");
		NewThreadImplementsRunnable threadTest = new NewThreadImplementsRunnable("src/test-result/implementsTestByStart.txt");
		Thread newThread = new Thread(threadTest);
		newThread.start();
		System.out.println("implementsTest function end");
	}
}

package thread;

public class TestClass extends Thread {

	public static void main(String[] args) {

		Thread thread = new Thread();
		VisibilityTest v = new VisibilityTest();
		v.run();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		v.stopIt();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("finish main");
		System.out.println(v.getStop());

	}

}

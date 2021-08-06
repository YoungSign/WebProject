package thread;

public class Run {

	public void run() {
		while (true) {
			if (Thread.currentThread().isInterrupted()) {
				System.out.println("Interrupted!");
				break;
			}

			//基本不会使用，会在调试中使用
			Thread.yield();

		}
	}

}
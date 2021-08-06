package thread;

public class BapSuspend {

	public static Object u = new Object();
	static ChangeObjectThread t1 = new ChangeObjectThread("t1");
	static ChangeObjectThread t2 = new ChangeObjectThread("t2");

	public static class ChangeObjectThread extends Thread {

		public ChangeObjectThread(String name) {
			setName(name);
		}

		@SuppressWarnings("deprecation")
		@Override
		public void run() {
			synchronized (u) {
				System.out.println("in " + getName());
				Thread.currentThread().suspend();
			}
		}

	}

	/**
	 * suspend():挂起线程
	 * resume():重新开始挂起的进程
	 * suspend()和resume()一起使用，但现在不推荐使用，因为可能造成死锁进程。
	 * join():等待该线程终止。
	 * isAlive():测试线程是否处于活动状态
	 * @param args
	 * @throws InterruptedException
	 */
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		t1.start();
		Thread.sleep(100);
		t2.start();
		t1.resume();
		t2.resume();
		t1.join();
		t2.join();
	}

}

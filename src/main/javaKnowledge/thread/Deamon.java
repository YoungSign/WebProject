package thread;

public class Deamon {

	public static class DeamonT extends Thread {
		@Override
		public void run() {
			while (true) {
				System.out.println("I am alive");
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * setDaemon(boolean):守护线程必须在start()方法前使用，否则会报错
	 * isDaemon():测试是否为守护线程
	 * checkAccess():判定当前运行的线程是否有权修改该线程
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		Thread thread = new Thread();
		thread.setDaemon(true);
		thread.start();
		Thread.sleep(2000);
	}

}

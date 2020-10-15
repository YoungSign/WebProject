package thread;

public class WaitNotify {

	final static Object Object = new Object();

	public static class wait extends Thread {
		@Override
		public void run() {
			synchronized (Object) {
				System.out.println(System.currentTimeMillis() + " wait is start!");
				System.out.println(System.currentTimeMillis() + " wait is wait for object ");
				try {
					//注：wait()和notify()必须在synchronized代码块中调用。
					Object.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(System.currentTimeMillis() + " wait is end!");
			}
		}
	}

	public static class notify extends Thread {
		@Override
		public void run() {
			synchronized (Object) {
				System.out.println(System.currentTimeMillis() + " notify is start! notify one thread!");
				//注：notify()作用是随机唤醒一个wait()状态中的进程。
				Object.notify();
				System.out.println(System.currentTimeMillis() + " notify is end!");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) {
		Thread wait = new wait();
		Thread notify = new notify();
		wait.start();
		notify.start();
	}

}

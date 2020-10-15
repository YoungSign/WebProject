package thread;

public class WaitNotifyAll {
	
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
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(System.currentTimeMillis() + " wait is end!");
			}
		}
	}

	public static class notifyAll extends Thread {
		@Override
		public void run() {
			synchronized (Object) {
				System.out.println(System.currentTimeMillis() + " notify all is start! notify all thread!");
				//注：notifyAll()作用是唤醒所有wait()状态中的进程。
				Object.notifyAll();
				System.out.println(System.currentTimeMillis() + " notify all is end!");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Thread wait1 = new wait();
		Thread wait2 = new wait();
		wait1.start();
		wait2.start();
		Thread.sleep(1000);
		Thread notifyAll = new notifyAll();
		notifyAll.start();
	}

}

package synchronizedExample;

public class synchronizedCode extends Thread {

	static synchronizedCode instance = new synchronizedCode();
	static int i = 0;

	@Override
	public void run() {
		for (int j = 0; j < 1000000; j++) {
			//保证每次循环都有一把锁，若没有则会发生冲突。
			//注：所有线程使用的同一个对象实例，才可能发生互斥现象。当线程运行到该代码块内，就会拥有obj对象的对象锁，如果多个线程共享同一个Object对象，那么此时就会形成互斥！当obj == this时，表示当前调用该方法的实例对象
			synchronized (instance) {
				i++;
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(instance);
		Thread t2 = new Thread(instance);
		
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		
		System.out.println(i);

	}

}

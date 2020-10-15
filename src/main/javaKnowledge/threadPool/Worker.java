package threadPool;

public class Worker extends Thread {

	// 线程池
	private ThreadPool pool;
	// 任务
	private Runnable target;
	private boolean isShutDown = false;
	private boolean isIdle = false;

	public Worker(ThreadPool pool, Runnable target, String name) {
		super(name);
		this.pool = pool;
		this.target = target;
	}

	public ThreadPool getPool() {
		return pool;
	}

	public void setPool(ThreadPool pool) {
		this.pool = pool;
	}

	public boolean isShutDown() {
		return isShutDown;
	}

	public void setShutDown(boolean isShutDown) {
		this.isShutDown = isShutDown;
	}

	public boolean isIdle() {
		return isIdle;
	}

	public void setIdle(boolean isIdle) {
		this.isIdle = isIdle;
	}

	public Runnable getTarget() {
		return target;
	}

	public synchronized void shutDown() {
		isShutDown = true;
		notifyAll();
	}

	public synchronized void setTarget(Runnable newTarget) {
		target = newTarget;
		// 设置任务后，通知run()，开始执行这个任务
		notifyAll();
	}

	@Override
	public void run() {
		while (!isShutDown) {
			isIdle = false;
			if (target != null) {
				// 运行任务
				target.run();
			}

			// 任务结束
			isIdle = true;
			// 该任务结束后，不关闭线程，而是放入线程池空闲队列
			try {
				pool.repool(this);
				synchronized (this) {
					// 线程空闲，等待新任务到来。
					wait();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}

package threadPool;

import java.util.List;
import java.util.Vector;

public class ThreadPool {

	private static ThreadPool instance = null;

	// 空闲的线程队列
	private List<Worker> idleThreads;

	// 已有的线程总数
	private int threadCounter;
	private boolean isShoutDown = false;

	private ThreadPool() {
		this.idleThreads = new Vector(5);
		threadCounter = 0;
	}

	public int getCreatedThreadsCount() {
		return threadCounter;
	}

	// 取得线程池的实例
	public synchronized static ThreadPool getInstance() {
		if (instance == null) {
			instance = new ThreadPool();
		}
		return instance;
	}

	// 将线程放入池中
	public synchronized void repool(Worker repoolingThread) {
		if (!isShoutDown) {
			idleThreads.add(repoolingThread);
		} else {
			// 关闭线程
			repoolingThread.shutDown();
		}
	}

	// 关闭线程
	public synchronized void shutDown() {
		isShoutDown = true;
		for (int threadIndex = 0; threadIndex < idleThreads.size(); threadIndex++) {
			Worker idleThread = idleThreads.get(threadIndex);
			idleThread.shutDown();
		}
	}

	// 开始线程
	public synchronized void start(Runnable target) {
		Worker thread = null;
		// 有空闲线程，则直接使用
		if (idleThreads.size() > 0) {
			int lastIndex = idleThreads.size() - 1;
			thread = idleThreads.get(lastIndex);
			idleThreads.remove(lastIndex);
			// 立即执行这个任务
			thread.setTarget(target);
		}

		// 没有空闲线程，则创建新线程
		else {
			threadCounter++;
			// 创建新线程
			thread = new Worker(this, target, "PThread #" + threadCounter);
			// 启动这个线程
			thread.start();
		}
	}

}

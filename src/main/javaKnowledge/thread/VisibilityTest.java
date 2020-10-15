package thread;

public class VisibilityTest {

	private boolean stop;
	Thread thread = new Thread();

	public void run() {
		int i = 0;
		while (!stop) {
			i++;
		}
		System.out.println("finish loop,i=" + i);
	}

	public void stopIt() {
		stop = true;
	}

	public boolean getStop() {
		return stop;
	}

}

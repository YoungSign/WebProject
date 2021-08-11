package synchronizedexample;

/**
 * @author admin
 */
public class synchronizedClass extends Thread {

    private static Integer i = 0;

    public static synchronized void increase() {
        i++;
    }

    @Override
    public void run() {
        int time = 1000000;
        for (int j = 0; j < time; j++) {
            increase();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new synchronizedClass());
        Thread t2 = new Thread(new synchronizedClass());
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println(i);
    }

}

package jvmOptimization;

/**
 * @author jihaoyang
 * @date 2021年08月11日 10:40
 * ‐XX:+PrintGC
 * ‐XX:+PrintGCDetails
 * -XX:PretenureSizeThreshold
 * -XX:+UseSerialGC
 * -XX:+ParNewGC
 * <p>
 * -XX:+UseG1GC
 * -XX:+UnlockExperimentalVMOptions
 * -XX:+PrintGCDetails
 * -Xlog:gc*
 */
public class GCTest {
    public static void main(String[] args) throws InterruptedException {
        byte[] allocation1;
        byte[] allocation2;
        //byte[] allocation3;
        //byte[] allocation4;
        //byte[] allocation5;
        //byte[] allocation6;
        allocation1 = new byte[60000 * 1024];
        allocation2 = new byte[8000 * 1024];
        //allocation3 = new byte[1000 * 1024];
        //allocation4 = new byte[1000 * 1024];
        //allocation5 = new byte[1000 * 1024];
        //allocation6 = new byte[1000 * 1024];
    }
}
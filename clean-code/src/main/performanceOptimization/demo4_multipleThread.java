package main.performanceOptimization;


import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class demo4_multipleThread {

    static long max = 0;
    static long start = 0;

    public static void main(String[] args) throws InterruptedException, IOException {
        long before = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            sendPingRequest();
        }
        long after = System.currentTimeMillis();
        System.out.println("Time spent by 1 thread: " + (after - before) + "ms");

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 20, 30,
                TimeUnit.MINUTES, new ArrayBlockingQueue<>(10));
        start = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            threadPoolExecutor.execute(new MyThread());
        }
        while (threadPoolExecutor.getCompletedTaskCount() != 10) {}
        threadPoolExecutor.shutdown();
        System.out.println("Time spent by 10 threads: " + max + "ms");
    }


    private static class MyThread extends Thread {
        @Override
        public void run() {

            for (int i = 0; i < 100; i++) {
                try {
                    sendPingRequest();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            long end = System.currentTimeMillis();
            if (end - start > max) {
                max = end - start;
            }
        }
    }

    public static void sendPingRequest()
            throws UnknownHostException, IOException {
        String ipAddress = "localhost";
        InetAddress.getByName(ipAddress);
    }

}

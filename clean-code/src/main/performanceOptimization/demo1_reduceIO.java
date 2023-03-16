package main.performanceOptimization;


public class demo1_reduceIO {

    public static void main(String[] args) {

        long before = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            add1(1, 1);
        }
        long after = System.currentTimeMillis();
        System.out.println("Time spent by add1: " + (after - before) + "ms");

        long before2 = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            add2(1, 1);
        }
        long after2 = System.currentTimeMillis();
        System.out.println("Time spent by add2: " + (after2 - before2) + "ms");
    }

    private static int add1(int a, int b) {
        //读a、读b、写a、读a、读b、写a
        a = a + b;
        a = a + b;
        return a;
    }

    private static int add2(int a, int b) {
        //读a、读b、写a
        a = a + 2 * b;
        return a;
    }
}

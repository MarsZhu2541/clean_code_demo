package main.performanceOptimization;

import java.util.Arrays;
import java.util.List;

public class demo2_reduceInvoke {


    public static void main(String[] args) {
        long before = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            sum1();
        }
        long after = System.currentTimeMillis();
        System.out.println("Time spent by add1: " + (after - before) + "ms");

        long before2 = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            sum2();
        }
        long after2 = System.currentTimeMillis();
        System.out.println("Time spent by add2: " + (after2 - before2) + "ms");
    }

    private static int sum1() {
        int res = 0;
        for (int i = 0; i < 10; i++) {
            res += MyData.getElement(i);
        }
        return res;
    }

    private static int sum2() {
        List list = MyData.getList();
        int res = 0;
        for (int i = 0; i < 10; i++) {
            res += (int) list.get(i);
        }
        return res;
    }

    private static class MyData {
        private static List list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        public static List getList() {
            return list;
        }

        public static int getElement(int i) {
            return (int) list.get(i);
        }
    }
}

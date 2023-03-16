package main.performanceOptimization;

import java.util.Arrays;
import java.util.List;

public class demo3_loopUnrolling {
    private static List list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    public static void main(String[] args) {
        long before = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            sumByLoop(1);
        }
        long after = System.currentTimeMillis();
        System.out.println("Time spent by sum 1 element in one loop: " + (after - before) + "ms");

        long before2 = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            sumByLoop(3);
        }
        long after2 = System.currentTimeMillis();
        System.out.println("Time spent by sum 3 element in one loop: " + (after2 - before2) + "ms");

        long before3 = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            sumByLoop(10);
        }
        long after3 = System.currentTimeMillis();
        System.out.println("Time spent by sum 10 element in one loop: " + (after3 - before3) + "ms");
    }

    private static int sumByLoop(int eleNumOneTime) {
        int res = 0;
        int i = 0;
        for (i = 0; i < 10; ) {
            if (i + eleNumOneTime > 10) break;
            int end = i + eleNumOneTime;
            while (i < end) {
                res += (int) list.get(i++);
            }
        }
        while (i < 10) {
            res += (int) list.get(i++);
        }
        return res;
    }
}

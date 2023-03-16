package main.performanceOptimization;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class addToTarget {
    public static void main(String[] args) {
        int[] arr = {1, 4, 9, 76, 4, 3};
        System.out.println(findTarget(arr, 5));

    }

    static boolean findTarget(int[] nums, int target) {

        int[] arr = Arrays.stream(nums).sorted().toArray();
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] > target) continue;
            int current = arr[i];
            int rest = target - current;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] > rest) continue;
                if (current + arr[j] == target) return true;
            }
        }
        return false;
    }
}

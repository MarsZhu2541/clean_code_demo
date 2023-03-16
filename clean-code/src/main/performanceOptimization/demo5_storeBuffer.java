package main.performanceOptimization;

import java.util.*;

public class demo5_storeBuffer {

    static List indexList = new ArrayList();
    static int length = 10000;
    static int times = 100000;

    public static void main(String[] args) {

        for (int i = 0; i < length; i++) {
            indexList.add(i);
        }

        natual2();
        natual22();
//        reverse2();
//        mass2();

    }

    private static void natual(){
        long before = System.currentTimeMillis();
        for (int i = 0; i < times; i++) {
            loadListByIndexList();
        }
        long after = System.currentTimeMillis();
        System.out.println("Time spent by loading in natual order: " + (after - before) + "ms");
    }

    private static void reverse(){
        //倒序
        Collections.reverse(indexList);
        long before1 = System.currentTimeMillis();
        for (int i = 0; i < times; i++) {
            loadListByIndexList();
        }
        long after1 = System.currentTimeMillis();
        System.out.println("Time spent by loading in reverse order: " + (after1 - before1) + "ms");
    }

    private static void mass(){
        //乱序
        Collections.shuffle(indexList);
        long before2 = System.currentTimeMillis();
        for (int i = 0; i < times; i++) {
            loadListByIndexList();
        }
        long after2 = System.currentTimeMillis();
        System.out.println("Time spent by loading in mass order: " + (after2 - before2) + "ms");
    }

    private static double[] getList() {
        double[] list = new double[length];
        for (int i = 0; i < length; i++) {
            list[i] = Math.random();
//            list[length-i-1] = Math.random();
        }
        return list;
    }

    private static void loadListByIndexList() {
        double[] list = getList();
        double x;
        for (Object i : indexList) {
            x = list[(int) i];
        }
    }

    private static void natual2(){

        long before = System.currentTimeMillis();
        for (int i = 0; i < times; i++) {
            int[] arr = new int[3];
            arr[0]=0;
            int a= arr[0];
            arr[1]=1;
            a = arr[1];
            arr[2]=2;
            a= arr[2];

        }
        long after = System.currentTimeMillis();
        System.out.println("Time spent by loading in natual2 order: " + (after - before) + "ms");

    }

    private static void natual22(){

        long before = System.currentTimeMillis();
        for (int i = 0; i < times; i++) {
            int[] arr = new int[3];
            arr[0]=0;
            arr[1]=1;
            arr[2]=2;

            int a= arr[0];
            a = arr[1];
            a= arr[2];
        }
        long after = System.currentTimeMillis();
        System.out.println("Time spent by loading in natual22 order: " + (after - before) + "ms");

    }

    private static void reverse2(){

        long before = System.currentTimeMillis();
        for (int i = 0; i < times; i++) {
            int[] arr = new int[3];
            arr[0]=0;
            arr[1]=1;
            arr[2]=2;

            int a= arr[2];
            a = arr[1];
            a= arr[0];
        }
        long after = System.currentTimeMillis();
        System.out.println("Time spent by loading in reverse2 order: " + (after - before) + "ms");

    }

    private static void mass2(){
        long before = System.currentTimeMillis();
        for (int i = 0; i < times; i++) {
            int[] arr = new int[3];
            arr[0]=0;
            arr[1]=1;
            arr[2]=2;

            int a= arr[1];
            a = arr[2];
            a= arr[0];
        }
        long after = System.currentTimeMillis();
        System.out.println("Time spent by loading in mass2 order: " + (after - before) + "ms");
    }

}

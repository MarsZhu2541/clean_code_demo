package main.errorHandling;

public class BaseClass {
    public static void doSomething() {
        System.out.println("BaseClass");
    }

    public static class MiddleClass {
        public static void doSomething() {
            BaseClass.doSomething();
        }
    }

    public static class TopClass {
        public static void doSomething(){
            MiddleClass.doSomething();
        }
    }

}

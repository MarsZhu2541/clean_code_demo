package main.errorHandling;

import jdk.nashorn.internal.runtime.ECMAException;

public class Demo7_5 {

    public void tryToShutDown() throws IndexOutOfBoundsException, ECMAException, ClassNotFoundException {
        throw new ClassNotFoundException("Error happened!");
    }

    public static void main(String[] args) {
//
//        try {
//            new Demo7_5().tryToShutDown();
//        } catch (IndexOutOfBoundsException e) {
//            System.out.println("IndexOutOfBoundsException");
//        } catch (ECMAException e) {
//            System.out.println("ECMAException");
//        } catch (ClassNotFoundException e) {
//            System.out.println("ClassNotFoundException");
//        }

        try {
            new ShutDownHelper().tryToShutDown();
        } catch (ShutDownFailure shutDownFailure) {
            shutDownFailure.printStackTrace();
        }
    }

    public static class ShutDownHelper {

        public void tryToShutDown() throws ShutDownFailure {
            try {
                new Demo7_5().tryToShutDown();
            } catch (IndexOutOfBoundsException | ClassNotFoundException | ECMAException e) {
                throw new ShutDownFailure(e);
            }

        }
    }

    private static class ShutDownFailure extends Exception {
        public ShutDownFailure(Exception exception) {
            super(exception);
        }
    }
}

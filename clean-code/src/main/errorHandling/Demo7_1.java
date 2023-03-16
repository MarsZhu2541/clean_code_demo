package main.errorHandling;

public class Demo7_1{

    public ErrorType errorType;

    public void tryToShutDown(){
        this.errorType=ErrorType.DEVICE_SUSPENDED;
//       this.errorType=ErrorType.INVALID;
    }

    public static void main(String[] args) {

        Demo7_1 process=new Demo7_1();

        process.tryToShutDown();

//        No error will be reported , so it is easy to forget,You don't know if something went wrong
        if(process.errorType==ErrorType.DEVICE_SUSPENDED){
            System.out.println("The error is "+ ErrorType.DEVICE_SUSPENDED);
        }

    }
}

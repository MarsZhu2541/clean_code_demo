package main.errorHandling;

public class Demo7_2{

    public void tryToShutDown() throws Exception{
        throw new Exception("Error happened!");
    }

    public static void main(String[] args) {

        Demo7_2 process=new Demo7_2();

//        process.tryToShutDown();
//
        try {
            process.tryToShutDown();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}

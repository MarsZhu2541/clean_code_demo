package main.errorHandling;

import java.util.Collections;
import java.util.List;

public class Demo7_7 {
    public static List<Employee> getEmployees(){
//        return null;
        return Collections.emptyList();
    }

    public static void main(String[] args) {

        List<Employee> employees=getEmployees();
        int totalPay=0;

//        if(employees!=null){
//            for(Employee e:employees){
//                totalPay+=e.getPay();
//            }
//        }

        for(Employee e:employees){
            totalPay+=e.getPay();
        }
//
        System.out.println("Total Pay: "+totalPay);
    }

    public static class Employee{
        private int pay;

        public Employee(int pay) {
            this.pay = pay;
        }

        public int getPay() {
            return pay;
        }
    }
}

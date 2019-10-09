package ca.hamed;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {


    ArrayExample.twoArray();
//    Assignment1.parkingFee("hamed" , -2);
//    Assignment1.parkingFee("sina" , 2.2);
//    Assignment1.parkingFee("jose" , 3.3);
//    Assignment1.parkingFee("daniel" , 23);
//    Assignment1.parkingFee("daniel" , 25);
//
//        System.out.println("-----------");
//
        System.out.println(Assignment1.clock(1,40,30) + " seconds after 12");;
        int dif = Assignment1.clock(2,42,30) - Assignment1.clock(3,40,30);
                if(dif >= 0) {
                    System.out.println(dif + " seconds diference between two times");
                }else{
                    System.out.println(-dif + " seconds diference between two times");
                }

        Assignment1.perfectNumber(6);
        Assignment1.perfectNumber(5);
    }

    }

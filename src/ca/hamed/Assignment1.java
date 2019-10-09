package ca.hamed;

public class Assignment1 {

    static void parkingFee(String name, double hour) {

        System.out.println("hello " + name);
        if (hour <= 0) {
            System.out.println("you do not need to pay");
        } else {
            if (hour <= 3) {
                System.out.println("You need to pay : " + 2 + " CAD");
            }
        }
        if (hour > 3 && hour <= 24) {
            if (2 + (hour - 3) * 0.50 < 10) {
                if (hour == (int) hour) {
                    System.out.println("You need to pay : " + (2 + (hour - 3) * 0.50) + " CAD");
                } else {
                    System.out.println("You need to pay : " + (2 + ((int) hour - 3 + 1) * 0.50) + " CAD");
                }
            } else {
                System.out.println("You need to pay : " + 10 + " CAD");
            }
        }
        if (hour > 24) {
            System.out.println("sorry you can not park more than 24 hours");
        }

    }

    static int clock(int hour, int min, int sec) {
        return (hour * 3600 + min * 60 + sec);
    }


    static void perfectNumber (int number){

        if(number == 1 ){
//            System.out.println("It is not a aperfect number");
        }else {
            int sum = 0;
            for (int i = number-1; i > 0; i -= 1) {
                if(number % i == 0) {
                    sum += i;
                }
            }
            if( sum == number) {
                System.out.println(number + " is a perfect number");
            }else{
//                System.out.println(number + " is not a perfect number");
            }
        }


}


}

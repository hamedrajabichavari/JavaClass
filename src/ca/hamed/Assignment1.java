package ca.hamed;

public class Assignment1 {

    static void parkingFee (String name, double hour) {

        System.out.println("hello " + name);
        if(hour <= 0){
            System.out.println("you do not need to pay");
        }else {
            if (hour <= 3) {
                System.out.println("You need to pay : " + 2 + " CAD");
            }
        }
        if(hour > 3 && hour <= 24){
            if(2 + (hour - 3) * 0.50 < 10) {
                System.out.println("You need to pay : "+ (2 + (hour - 3) * 0.50) + " CAD");
            }else{
                System.out.println("You need to pay : "+ 10 + " CAD");
            }
        }
        if(hour > 24){
            System.out.println("sorry you can not park more than 24 hours");
        }

    }
}

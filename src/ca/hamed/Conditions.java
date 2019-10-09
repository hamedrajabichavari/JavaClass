package ca.hamed;

public class Conditions {

    static void conditions(){

        System.out.println("\n___________________________\n");
        int year = 2019;
        System.out.println("year is initialized to " + year);
        //year = year + 1;
        //pre increment
        System.out.println("++year = " + ++year);// ? 2020
        //post increment
        System.out.println("year++ = " + year++);// ? 2020
        //here the year value is 2021
        System.out.println("year = " +year); // ? 2021
        year %= 2;
        System.out.println("year %= 2 = " + year); // ? 1
        System.out.println("\n___________________________\n");


        System.out.println("\n___________________________\n");
        //conditions
        //if blocks
        int age = 18;
        System.out.println("age is initialized to " + age);
        System.out.println("checking the if conditions");
        if (age >= 120) {
            System.out.println("sorry you are dead :(");
        } else if (age >= 18) {
            System.out.println("you are adult");
        } else {
            System.out.println("you are NOT adult");
        }
        System.out.println("\n___________________________\n");


        System.out.println("\n___________________________\n");
        boolean islightson = true;
        System.out.println("islightson is initialized to " + islightson);
        System.out.println("checking the if conditions");
        if (islightson) {
            System.out.println("can you turn off the light?");
        } else {
            System.out.println("can you turn on the light?");
        }
        System.out.println("\n___________________________\n");



        System.out.println("\n___________________________\n");
        int studentMark = 70;
        double gpa;
        System.out.println("studentMark is initialized to " + studentMark);
        System.out.println("gpa will be calculated in ternary operator");
        gpa = studentMark >= 80 ? 4.0 : 3.0;
        System.out.println("student gpa is " + gpa);
        System.out.println("\n___________________________\n");


        System.out.println("\n___________________________\n");
        age = 17;
        System.out.println("age is changed to " + age);
        boolean parentPermission = false;
        System.out.println("parentPermission initialized to " + parentPermission);
        System.out.println("checking the if conditions");

        if ( age >= 18 || parentPermission  ){
            System.out.println("you are allowed to do stuff");
        } else {
            System.out.println("you need to grow up or you need permission");
        }

        if (age < 18 && parentPermission){
            System.out.println("you need to grow up or you need permission");
        } else {
            System.out.println("you are allowed to do stuff");
        }
        System.out.println("\n___________________________\n");



        System.out.println("\n___________________________\n");
        int dayOfWeek = 3; // 0 .... 6
        System.out.println("dayOfWeek initialized to " + dayOfWeek);
        System.out.println("checking the if conditions");
        if(dayOfWeek == 0){
            System.out.println("its sunday");
        } else if (dayOfWeek == 1){
            System.out.println("its monday");
        } else if (dayOfWeek == 2){
            System.out.println("its tuesday");
        } else if (dayOfWeek == 3){
            System.out.println("its wednesday");
        } else if (dayOfWeek == 4){
            System.out.println("its thursday");
        } else if (dayOfWeek == 5){
            System.out.println("its friday");
        } else if (dayOfWeek == 6){
            System.out.println("its saturday");
        } else {
            System.out.println("ops there is no such a day");
        }
        System.out.println("\n___________________________\n");


        System.out.println("\n___________________________\n");
        System.out.println("checking the switch statement");
        switch (dayOfWeek) {
            case 0:
                System.out.println("its sunday");
                break;
            case 1:
                System.out.println("its monday");
                break;
            case 2:
                System.out.println("its tuesday");
                break;
            case 3:
                System.out.println("its wednesday");
                break;
            case 4:
                System.out.println("its thursday");
                break;
            case 5:
                System.out.println("its friday");
                break;
            case 6:
                System.out.println("its saturday");
                break;
            default:
                System.out.println("ops there is no such a day");
                break;
        }
        System.out.println("\n___________________________\n");
    }

    public static void main(String[] args) {

    }
}

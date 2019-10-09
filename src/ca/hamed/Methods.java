package ca.hamed;

import java.util.Scanner;

public class Methods {

    public static void main(String[] args) {

        getInputFromUser();
        menu();
    }

    static void menu () {

        boolean exit = false;

        Scanner sn = new Scanner(System.in);

        do {
            System.out.println("select one");
            System.out.println("1 - add numbers from 1 to 100");
            System.out.println("2 - project Euler question 1");
            System.out.println("3 - add 2 numbers");
            System.out.println("4 - add 3 numbers");
            System.out.println("5 - multiply calculation");
            System.out.println("6 - is prime?");
            System.out.println("7 - first prime numbers between 1 to 100?");

            int userChoice = sn.nextInt();

            switch (userChoice) {
                case 1:
                case 0: {
                    numbers1To100();
                    break;
                }
                case 2: {
                    projectEulerQuestion1();
                    break;
                }
                case 3: {
                    int num1, num2;
                    System.out.println("number 1? : ");
                    num1 = sn.nextInt();
                    System.out.println("number 2? : ");
                    num2 = sn.nextInt();
                    System.out.println(num1 + " + " + num2 + " = " + add(num1, num2));
                    break;
                }
                case 4: {
                    int num1, num2, num3;
                    System.out.println("number 1? : ");
                    num1 = sn.nextInt();
                    System.out.println("number 2? : ");
                    num2 = sn.nextInt();
                    System.out.println("number 3? : ");
                    num3 = sn.nextInt();
                    System.out.println(num1 + " + " + num2 + " + " + num3 + " = " + add(num1, num2, num3));
                    break;
                }
                case 5: {
                    System.out.println("2 * 5 * 10 = " + multiply(2, 5, 10));
                    ;
                    break;
                }
                case 6: {
                    System.out.println("which number? ");
                    int number = sn.nextInt();
                    System.out.println(isPrime((number)));
                    break;
                }
                case 7: {
                    for (int i = 1; i < 100; i++) {
                        // System.out.println(i + " is prime ? " + isPrime(i) );
                        if (isPrime(i)) {
                            System.out.println(i);
                        }
                    }
                    break;
                }

                default:
                    exit = true;
                    System.out.println("bye");
                    break;
            }

        } while (!exit);

        sn.close();
    }

    static void getInputFromUser () {

        Scanner sn = new Scanner(System.in);

        System.out.println("What is your name");
        String name;
        name = sn.next();

        System.out.println("hey how old are you?");
        int age;
        age = sn.nextInt();

        System.out.println("hi " + name + " nice to meet you");
        System.out.println("you are " + age + " years old");

        String password;
        System.out.println("whats your password");
        password = sn.next();
        System.out.println("your password is");
        for (int i = 0; i < password.length(); i+=1){
            System.out.print("*");
        }
        System.out.println(" - password saved in password variable");


        System.out.println("what is your email address");
        System.out.println("I will reverse whatever you write");
        String email = sn.next();
        //reverse the email address
        for (int i = email.length(); i >0 ; i -= 1) {
            System.out.print(email.charAt(i-1));
        }
        System.out.println("\n\n");
        sn.close();
    }

    static void projectEulerQuestion1 () {

        int n = 1;
        int sum = 0;
        for (int i = 0; i < 1000; i++) {
            if (i % 3 == 0 || i % 5 == 0) sum += i;
        }
        System.out.println("sum value is " + sum);
    }

    //methods must have a return type
    static void numbers1To100 () {
        int n = 1;
        int sum = 0;
        for (int i = n; i <= 100; i += 1) {
            sum += i;
            System.out.println(i + " added to sum new value is " + sum);
        }
        System.out.println("the numbers from 1 to 100 is : " + sum);
    }

    static int add (int number1, int number2) {
        return number1 + number2;
    }

    //overloading add function
    static int add (int number1, int number2, int number3) {
        return number1 + number2 + number3;
    }

    //unlimited parameters
    static int multiply (int... nums) {
        int result = 1;

        for (int i = 0; i < nums.length; i++) {
            result *= nums[i];
        }

        return result;

    }


    static boolean isPrime (int number) {

        if (number < 2) return false;

        if (number == 2) return true;
        if (number == 2) return true;

        for (int i = 2; i * i <= number; i++)
            if (number % i == 0)
                return false;

        return true;

    }

    // if payment is 1 monthly
    // if payment is 2 quarterly
    static void feeCalculation(double fee, int payment) {


        if (payment == 1) {
            //calculation based on month
            System.out.format("you need to pay %.2f %s every month \n", fee/12, "CAD");
        }

        if (payment == 2) {
            //calculation based on quarter
            System.out.format("you need to pay %.2f CAD every quarter\n", fee/4);
        }

    }


    static void calculateSalary (String name, double salary, double workingHours) {

        System.out.println("hello " + name);
        System.out.format("You are making %.2f CAD/hour", salary/52/workingHours);

    }

    static void calculatePaintingServices () {
        Scanner sn = new Scanner(System.in);
        //constant
        final double FEE = 15.0d;

        //FEE = 5.0d; error
        System.out.println("what is the length of wall");
        double length = sn.nextDouble();
        System.out.println("what is the width of wall");
        double width = sn.nextDouble();

        System.out.println("your total is " + length * width * FEE + " CAD" );
        sn.close();
    }


    static int factorial (int number) {

//        if ( number <1) {
//            return -1;
//        }

//        if (number == 1) {
//            return 1;
//       }
//
//        return number * factorial(number-1);

        //ternary operator
        //sometimes not easy to read and undestand
        return (number < 1) ? -1 : (number == 1) ? 1 : number *factorial(number-1);

    }

    static long fibonacci (int number) {

        if ( number < 1 ) return -1;
        if ( number == 1 ) return 0;
        if ( number == 2 ) return 1;
        return fibonacci(number-2) + fibonacci(number-1);

//        return (number < 1) ? -1 : (number == 1)
//                            ? 0 : (number == 2)
//                            ? 1 : (fibonacci(number-2)+ fibonacci(number -1));
    }



}

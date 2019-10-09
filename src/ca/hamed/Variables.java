package ca.hamed;

import java.math.BigDecimal;

class Variables {

    // global static variables are automaticly initialized with value
    // 0 or false
    static int intVal;
    static boolean isSleeping;

    static void variables() {
        System.out.println("global intVal value is " + intVal);

        //different variables
        //byte short int long

        System.out.println("Hello Java!");
        //primitive types
        byte byteNumber = Byte.MAX_VALUE;
        short shortNumber = Short.MIN_VALUE;
        int intNumber = 2_147_483_647 + 1;
        int negativeInt = -2_147_483_648 -1;
        System.out.println("overflow intNumber is : " + intNumber);// overflow
        System.out.println("underflow negativeInt is : " + negativeInt);// overflow

        System.out.println("byte number value is " + byteNumber);
        System.out.println("short number value is " + shortNumber);

        //casting
        byte aByteValue = 60;
        byte anotherByteValue = (byte)(aByteValue/2);

        System.out.println("anotherByteValue 60/2 is : " + anotherByteValue);

        int a = 130;
        //truncated
        byte b = (byte)a;
        System.out.println("truncated byte value is : " + b);//?

        byte x = 127;
        //all good
        int y = x;
        System.out.println("converted byte value is : " + y);

        // for long types use L at the end of value
        long longValue = 9_223_372_036_854_775_807L;//max long number
        System.out.println(longValue);

        double cofeePrice = 2.75d;// d is optional but better to use it
        float teaPrice = 2.99f; // f is a must

        int coffee = (int)cofeePrice;
        System.out.println("the int coffee price : " + coffee); // 2
        System.out.println("the rounded tea price is : " + Math.round(teaPrice)); // 3
        System.out.println("the rounded tea price is : " + Math.floor(teaPrice)); // 2.0

        System.out.println("(double)25 / 2 = " + (double)25 / 2);
        System.out.println("25d / 2 = " + 25d / 2);
        System.out.println("25f / 2 = " + 25f / 2);
        System.out.println("(int)(25f / 2) = " + (int)(25f / 2));

        int test = (int)Math.pow(2,32);
        System.out.println(test);

        double dVal = .012;
        double sum = dVal + dVal + dVal;
        System.out.println("wrong calculation .12 + .12 + 12 = " + sum);

        //big decimal
        BigDecimal bigValue = new BigDecimal(Double.toString(dVal));
        BigDecimal total  = bigValue.add(bigValue).add(bigValue);
        System.out.println("exact result of .12 + .12 + 12 = " + total);

        boolean isLigthsOn = false;
        boolean amINotSleeping = !isLigthsOn;
        System.out.println("is lights on? " + isLigthsOn);
        System.out.println("am i sleeping?  " + amINotSleeping);

        char initial1 = 'S';
        char initial2 = '\u0041';//unicode char

        System.out.println("the initial1 value is " + initial1);
        System.out.println("the initial2 value is " + initial2);

        String name = "I love icecream";
        System.out.print(name + "\n");
    }

    public static void main(String[] args) {
    }

}

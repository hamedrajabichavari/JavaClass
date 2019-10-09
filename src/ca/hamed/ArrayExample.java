package ca.hamed;

import java.util.Arrays;

public class ArrayExample {

    public static void main(String[] args) {
    }
    public static void array() {

        String[] students = new String[6];

        students[0] = "daniel";
        students[1] = "sina";
        students[2] = "hamed";
        students[3] = "satoshi";
        students[4] = "jose";
        students[5] = "mariana";

        System.out.println("students[2] : " + students[2]);

        int[] numbers = {5, 17, 3, 45, 6, 76, 15, 43, 2};
        double[] marks = new double[]{95.0, 94.2, 94.5, 99.6, 93.0};
        for (int i = 0; i < marks.length; i += 1) {
            System.out.println("marks[" + i + "] = " + marks[i]);
        }
        System.out.println("----------------");
        Arrays.sort(marks);
        for (int i = 0; i < marks.length; i += 1) {
            System.out.println("marks[" + i + "] = " + marks[i]);
        }
        int indexForMarks = Arrays.binarySearch(marks, 94.5);
        System.out.println("the index of 94.2 is : " + indexForMarks);

        //
        int number = 98;
        int indexForMarks2 = Arrays.binarySearch(marks, number);
        if (indexForMarks2 < 0) {
            System.out.println(number + " is not found");
        } else {
            System.out.println("the index of " + number + " is : " + indexForMarks2);
        }

        //
        for (String student : students) {
            System.out.println(student);
        }
        //or
        for (Object student : students) {
            System.out.println(student);
        }

        for (Object num : numbers) {
            System.out.println(num);
        }

    }

    public static void twoArray() {
        int[][] num = new int[2][7];

        for (int i = 0; i < 2; i += 1) {
            for (int j = 0; j < 7; j += 1) {
                num[i][j] = (j+1)+ i*7;
                System.out.print(num[i][j]+" ");
            }
            System.out.println(" ");
        }

        System.out.println("-------------------------");

        //with row & col
        int[][] numb = new int[10][10];
        int row = numb.length;
        int col = numb[0].length;

        for (int i = 0; i < row; i += 1) {
            for (int j = 0; j < col; j += 1) {
                numb[i][j] = (j+1)+ i*row;
                if(numb[i][j] < 10 ){
                    System.out.print(" " + numb[i][j]+" ");
                }else {
                    System.out.print(numb[i][j] + " ");
                }

            }
            System.out.println(" ");
        }


        //another way to implement the array
        double[][] twoArray2 = {
                {1.0,2.0,3.0,4.0},
                {1.1,2.1,3.1,4.1},
                {2.1,2.2,2.3,2.4}
        };

        System.out.println(twoArray2[2][2]);

        //4,2,3
        int[][][] threeArray = new int[][][] {
                {
                        {1,2,3},
                        {4,5,6}
                },
                {
                        {7,8,9},
                        {10,11,12}
                },
                {
                        {13,14,15},
                        {16,17,18}
                },
                {
                        {19,20,21},
                        {22,23,24}
                },

        };
//        System.out.println(threeArray[2][1][0]);
        for (int i = 0; i < threeArray.length; i += 1) {
            for (int j = 0; j < threeArray[0].length; j += 1) {
                for (int k = 0; k < threeArray[0][0].length; k += 1) {
                    System.out.println(threeArray[i][j][k] + " ");
                }
            }
        }
        System.out.println("------------------");

        int[] primeNumbers = new int [] {2,3,5,7,11,13,17,19,23};
//        int[] reference = primeNumbers;
//
//        System.out.println(reference[2]);//5
//        reference[2] = 0;
//        System.out.println(primeNumbers[2]);//0


        int[] reverse = new int[primeNumbers.length];
        for (int i = 0; i < primeNumbers.length; i += 1) {
            reverse[i] =primeNumbers[primeNumbers.length-1 - i];
        }
        for (int i = 0; i < primeNumbers.length; i += 1) {
            System.out.print(primeNumbers[i] + " ");
        }
        System.out.println(" ");
        for (int i = 0; i < primeNumbers.length; i += 1) {
            System.out.print(reverse[i] + " ");
        }


    }
}
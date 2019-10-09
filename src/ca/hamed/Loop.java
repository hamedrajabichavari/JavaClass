package ca.hamed;

public class Loop {

    static void loop(){

        System.out.println("\n___________________________\n");
        System.out.println("For loop");
        System.out.println("printing numbers 1 to 10");
        for(int i = 0; i < 10; i += 1){
            int printThis = i+1;
            System.out.print(printThis + " ");
        }
        System.out.println("\n___________________________\n");


        System.out.println("\n___________________________\n");
        System.out.println("for loop");
        System.out.println("calculating power of 2 ");
        for (int i = 10; i > 0; i -= 1) {
            System.out.println("2 ^ " + i + " = " + (int)Math.pow(2,i));
        }
        System.out.println("\n___________________________\n");


        System.out.println("\n___________________________\n");
        System.out.println("for loop");
        System.out.println("printing chars A to Z - version 1");
        for (char i = 'A'; i <= 'Z'; i+=1) {
            System.out.print(i + " ");
        }
        System.out.println("\n___________________________\n");


        System.out.println("\n___________________________\n");
        System.out.println("for loop");
        System.out.println("printing chars A to Z - version 2");
        for (char i = 65; i < 91; i+=1) {
            System.out.print(i + " ");
        }
        System.out.println("\n___________________________\n");


        System.out.println("\n___________________________\n");
        System.out.println("while loop");
        System.out.println("printing numbers 1 to 10");
        int j = 0;
        while (j<=10) {
            System.out.print(j + " ");
            j+=1;
        }
        System.out.println("\n___________________________\n");


        System.out.println("\n___________________________\n");
        System.out.println("do while loop");
        System.out.println("printing numbers 5 to 20");
        j = 5;
        do {
            System.out.print(j + " ");
            j+=1;
        } while(j<21);
        System.out.println("\n___________________________\n");


        System.out.println("\n___________________________\n");
        System.out.println("while loop");
        System.out.println("printing numbers 1 to 10, continue if 5");
        int i = 0;
        while ( i < 10) {
            if (i == 5) {
                i += 1;
                continue;
            }
            System.out.print(i + " ");
            i += 1;
        }


    }

    public static void main(String[] args) {

    }
}

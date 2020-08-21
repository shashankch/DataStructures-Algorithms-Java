package Prep;

import java.util.Scanner;

public class convertTime {


    public static void helper(String time) {


        int h1 = time.charAt(1) - '0';
        int h2 = time.charAt(0) - '0';
        int hh = (h2 * 10 + h1 % 10);

        if (time.charAt(8) == 'A') {


            if (hh == 12) {

                System.out.print("00");
                for (int i = 2; i <= 7; i++) {
                    System.out.print(time.charAt(i));
                }


            }

            else {

                for (int i = 0; i <= 7; i++) {
                    System.out.print(time.charAt(i));
                }


            }



        }

        else if (time.charAt(8) == 'P') {


            if (hh == 12) {

                System.out.print("12");
                for (int i = 2; i <= 7; i++) {
                    System.out.print(time.charAt(i));
                }


            }

            else {
                hh += 12;
                System.out.print(hh);
                for (int i = 2; i <= 7; i++) {
                    System.out.print(time.charAt(i));
                }

            }



        }



    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String input = sc.next();

        helper(input);



    }

}

package Prep;

import java.util.Scanner;

public class AllPossibleSubstring {


    public static void helper(String str, int i, String out) {


        if (i == str.length()) {

            System.out.println(out);
            return;
        }

        for (int j = str.length() - 1; j >= i; j--) {

            String temp = '[' + str.substring(i, j + 1) + ']';

            helper(str, j + 1, out + temp);
        }



    }


    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        int n = input.length();

        System.out.println((int)Math.pow(2, n - 1));

        helper(input, 0, "");



    }

}

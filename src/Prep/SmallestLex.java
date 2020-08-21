package Prep;

import java.util.Arrays;
import java.util.Scanner;

public class SmallestLex {


    public static String helper2(int k, String str) {


        String smallest = str;

        for (int i = 0; i < str.length(); i++) {

            String temp = str.substring(i) + str.substring(0, i);
            if (temp.compareTo(smallest) < 0) {
                smallest = temp;
            }

        }

        return smallest;



    }



    public static String helper(int k, String str) {

        String ans = "";
        while (str.length() != 0) {


            char temp = str.charAt(0);

            for (int i = 1; i < k && i < str.length(); i++) {

                if (str.charAt(i) < temp) {
                    temp = str.charAt(i);
                }

            }


            ans += temp;

            for (int i = 0; i < k; i++) {

                if (str.charAt(i) == temp) {

                    str = str.substring(0, i) + str.substring(i + 1);
                    break;
                }

            }



        }

        return ans;



    }

    // public static void main(String[] args) {

    // Scanner sc = new Scanner(System.in);
    // int t = sc.nextInt();

    // while(t-->0){

    // int k=sc.nextInt();
    // String str = sc.next();
    // System.out.println(helper(k,str));

    // }

    // }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {

            int k = sc.nextInt();
            String str = sc.next();
            if (k == 1) {
                System.out.println(helper2(k, str));
            } else {

                char arr[] = str.toCharArray();
                Arrays.sort(arr);
                System.out.println(arr);
            }



        }

    }

}

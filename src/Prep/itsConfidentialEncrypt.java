package Prep;

import java.util.Scanner;

public class itsConfidentialEncrypt {

    public static String helper(String str) {

        if (str.length() <= 2) {
            return str;
        }
        int mid = str.length() / 2;
        if (str.length() % 2 == 0) {
            mid -= 1;
        }


        return str.charAt(mid) + helper(str.substring(0, mid)) + helper(str.substring(mid + 1));



    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int t = Integer.parseInt(sc.nextLine().trim());


        while (t-- > 0) {


            int n = Integer.parseInt(sc.nextLine().trim());
            String str = sc.nextLine();
            System.out.println(helper(str));

        }

    }
}

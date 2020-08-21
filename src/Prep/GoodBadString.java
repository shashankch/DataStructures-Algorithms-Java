package Prep;

import java.util.Scanner;

public class GoodBadString {


    public static String helper(String str) {
        
        String ans = "";
        for (int i = 0; i < str.length(); i++) 
        {
            
            int j = i;
            
            while (j < str.length() && str.charAt(i) == str.charAt(j)) 
            {
                j++;
            }

            ans += str.charAt(i);
             i=j-1;

        }


        return ans;


    } 


    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        while (n-- > 0) {
            
            String input = sc.next();

            String ans = helper(input);

            System.out.println(ans);

        }

    }
    
}
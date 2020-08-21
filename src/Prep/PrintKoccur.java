package Prep;

import java.util.HashMap;
import java.util.Scanner;

public class PrintKoccur {



    public static String helper(int k, String str, int len) {


        HashMap<Character, Integer> mp = new HashMap<>();
        String ans = "";

        for (int i = 0; i < str.length(); i++) {

            if (mp.containsKey(str.charAt(i)) && mp.get(str.charAt(i)) <= k) {
                mp.put(str.charAt(i), mp.get(str.charAt(i)) + 1);
            } else if (!mp.containsKey(str.charAt(i))) {
                mp.put(str.charAt(i), 1);
            }
        }

        for (int i = 0; i < str.length(); i++) {


            ans += str.charAt(i);



        }



        return ans;



    }

    public static String helper2(int k, String str, int len)
    
    {


        String ans = "";
        int freq[] = new int[26];

        for (int i = 0; i < str.length(); i++) {

            int index = str.charAt(i) - 'a';
            if (freq[index] < k) 
            {
                ans += str.charAt(i);

            }

            freq[index] += 1;
        }


        return ans; 

    }



    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        while (n-- > 0) {

            int len = sc.nextInt();

            int k = sc.nextInt();
            sc.nextLine();
            String str = sc.next();

            System.out.println(helper2(k, str, len));

        }

    }

}

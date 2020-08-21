package Prep;

import java.util.ArrayList;
import java.util.Scanner;

public class equilibriumIndex {

    public static void helper(ArrayList<Integer> arr) { 
        // System.out.println("arerer");
        int n = arr.size();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr.get(i); 
        }

        int left = 0; 
        for (int i = 0; i < n; i++) {
            sum -= arr.get(i);

            if (left == sum) {
                System.out.println(i);
                break;
            }
            left += arr.get(i);
        }

    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        // list(map(int, inputString.split(','))) in java
        String arr[] = str.split(",");
        ArrayList<Integer> values = new ArrayList<>();
        for (String val : arr) {
            // System.out.print(val+" ");
            values.add(Integer.parseInt(val));
        }
        // for (int i = 0; i < values.size(); i++) {
        //     System.out.print(values.get(i) + " ");
        // }
        
        helper(values);
    }

}

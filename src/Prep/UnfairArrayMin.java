package Prep;

import java.util.Arrays;
import java.util.Scanner;

public class UnfairArrayMin {

    public static int helper(int arr[],int k) {


        Arrays.sort(arr);
        int n = arr.length;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n - k+1; i++) {


            int diff = arr[i + k - 1] - arr[i];

            if (diff < min) {
                min = diff;
            }



        }
        
        return min;


    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int k = Integer.parseInt(sc.nextLine().trim());

        String arr[] = sc.nextLine().trim().split(",");
        int inp[] = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {

            inp[i] = Integer.parseInt(arr[i]);
        }

        int ans = helper(inp,k);

        System.out.println(ans);



    }


}

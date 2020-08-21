package Prep;

import java.util.Arrays;
import java.util.Scanner;

public class kingdomTravelTwo {


    public static int helper(int arr[], int n) {


        Arrays.sort(arr);
        int ans = 0;

        while (n > 3) {


            int first = (2 * arr[0]) + arr[n - 1] + arr[n - 2];
            int second = arr[0] + (2 * arr[1]) + arr[n - 1];

            ans += Math.min(first, second);

            n -= 2;



        }

        if (n == 3) {

            ans = ans + arr[0] + arr[1] + arr[2];
        } else if (n == 2){
            ans = ans + arr[1];
        }
        else {
            ans = ans + arr[0];
        }
        


        
        return ans;

    }




    public static void main(String[] args) {
        

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        sc.nextLine();
        while (t-- > 0) {


            int n = sc.nextInt();
            sc.nextLine();
            int arr[] = new int[n];
            String temp[] = sc.nextLine().split(" ");
            for (int i = 0; i < n; i++) {

                arr[i] = Integer.parseInt(temp[i]);
            }

            int ans = helper(arr, n);

            System.out.println(ans);



        }

    }
    
}
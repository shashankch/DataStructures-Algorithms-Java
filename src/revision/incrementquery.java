package revision;

import java.util.Scanner;

// given an empty array and given queries {start index,endIndex}
// you have to increment the subarray btw the given start and end
// brute : O(N*queries) but optimised : O(N+K)


public class incrementquery {

    public static void main(String[] args) {

        int n = 1000;


        int arr[] = new int[n];
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        int helper[] = new int[n];
        while (q-- > 0) {

            int start = sc.nextInt();
            int end = sc.nextInt();

            helper[start] = 1;
            helper[end + 1] -= 1;
        }
        arr[0] = helper[0];
        for (int i = 1; i < n; i++) {

            arr[i] = helper[i - 1] + helper[i];

        }

        for (int i = 0; i < n; i++) {
            System.out.println(arr[i] + " ");
        }
    }



}

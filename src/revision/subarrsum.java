package revision;

import java.util.HashMap;

public class subarrsum {

    public static void method1(int arr[], int target) { // O(N^3)

        int n = arr.length;

        for (int len = 1; len <= n; len++) {

            for (int start = 0; start < n; start++) {

                if (len + start > n) {
                    break;
                }

                int sum = 0;
                for (int i = start; i < start + len; i++) {
                    sum += arr[i];
                }
                if (sum == target) {
                    System.out.println(start + " " + (start + len - 1));
                }

            }

        }

    }

    // handles negative numbers..
    public static void method2(int arr[], int target) {

        HashMap<Integer, Integer> mp = new HashMap<>();

        int curr = 0;
        for (int i = 0; i < arr.length; i++) {

            curr += arr[i];

            if (curr == target) {
                System.out.println("0 " + i);
            }

            if (mp.containsKey(curr - target)) {

                System.out.println((mp.get(curr - target) + 1) + " " + i);
            }

            mp.put(curr, i);

        }

    }

    public static void method3(int arr[], int target) { // O(N^2)

        int n = arr.length;
        int curr = 0;

        for (int i = 0; i < n; i++) { // start of the subarry

            curr = arr[i];
            for (int j = i + 1; j <= n; j++) // all length
            {

                if (curr == target) {
                    System.out.println(i + " " + (j - 1));
                }
                if (curr > target || j == n) {
                    break;
                }

                curr += arr[j];

            }

        }

    }

    public static void method4(int arr[], int target) {  // O(N)

        int curr = arr[0], start = 0;
        int n = arr.length;

        for (int i = 1; i <= n; i++) {

            while (curr > target && start < i - 1) {

                curr -= arr[start++];
            }

            if (curr == target) {
                System.out.println(start + " " + (i - 1));
            }

            if (i < n) {
                curr += arr[i];
            }

        }

    }

    public static void main(String[] args) {

        int arr[] = { 15, 2, 4, 8, 9, 5, 10, 23 };

        // method1(arr, 23);

        // handles -ve
        // method2(arr, 23);

        // only +ve number..
        method3(arr, 23);
        method4(arr, 23);
    }

}
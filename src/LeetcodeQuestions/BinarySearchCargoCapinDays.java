package LeetcodeQuestions;

// https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/
public class BinarySearchCargoCapinDays {


    public static boolean isPossible(int cap, int d, int arr[]) {


        int curr = cap;
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {

            if (arr[i] <= curr) {

                curr -= arr[i];
            } else {

                curr = cap;
                ans += 1;
                curr -= arr[i];
            }


        }


        return (ans + 1) <= d;



    }



    public static int helper(int arr[], int d) {

        int n = arr.length;
        int sum = 0, max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {

            sum += arr[i];
            max = Math.max(arr[i], max);
        }

        int low = max, high = sum;

        while (low < high) {


            int mid = (low + high) / 2;

            if (isPossible(mid, d, arr)) {
                high = mid;
            } else {
                low = mid + 1;
            }


        }


        return low;



    }



    public static void main(String[] args) {


        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int d = 5;

        int ans = helper(arr, d);
       System.out.println(ans);

    }


}

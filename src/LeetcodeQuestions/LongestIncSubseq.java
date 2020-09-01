package LeetcodeQuestions;

public class LongestIncSubseq {


    public static int helper(int arr[]) {

        int n = arr.length;
        int dp[] = new int[n];

        // initial lis is one for each element.
        for (int i = 0; i < n; i++) {
            dp[i] = 1;

        }

        int best = -1;

        for (int i = 1; i < n; i++) {

            for (int j = 0; j < i; j++) {


                if (arr[i] >= arr[j]) {

                    int len = 1 + dp[j];
                    dp[i] = Math.max(dp[i], len);

                }

            }

            best = Math.max(best, dp[i]);


        }


        return best;



    }

    public static int helper2(int[] arr) {
        int n = arr.length;

        if (n == 0) {
            return 0;
        }

        int dp[] = new int[n];

        // initial lis is one for each element.

        dp[0] = 1;



        int best = 1;

        for (int i = 1; i < n; i++) {

            int len = 0;
            for (int j = 0; j < i; j++) {


                if (arr[i] > arr[j]) {


                    len = Math.max(dp[j], len);

                }

            }

            dp[i] = len + 1;
            best = Math.max(best, dp[i]);


        }


        return best;

    }



    public static void main(String[] args) {

        int arr[] = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(helper2(arr));
    }

}

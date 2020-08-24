package Prep;

public class subsetSumProblem {

    // Eat Or Not? subset sum problem
    public static boolean helper(int v, int c, int f, int p, int n, int V[], int C[], int F[],
            int P[]) {

        // target is reached
        if (v == 0 && c == 0 && f == 0 && p == 0) {
            return true;
        }

        // traversed entire array but target is'nt achieved.
        if (n == 0 && (v != 0 || c != 0 || f != 0 || p != 0)) {

            return false;


        }

        if (V[n] > v || C[n] > c || F[n] > f || P[n] > p) {

            return helper(v, c, f, p, n - 1, V, C, F, P);
        }


        return helper(v, c, f, p, n - 1, V, C, F, P)
                || helper(v - V[n], c - C[n], f - F[n], p - P[n], n, V, C, F, P);



    }

    public static boolean helperDP(int arr[], int n, int target) {


        boolean dp[][] = new boolean[target + 1][n + 1];

        for (int i = 0; i < n; i++) {

            dp[0][i] = true;


        }

        for (int i = 1; i <= target; i++) {

            dp[i][0] = false;


        }



        for (int i = 1; i <= target; i++) {

            for (int j = 1; j <= n; j++) {

                dp[i][j] = dp[i][j - 1];

                if (i >= arr[j - 1]) {
                    dp[i][j] = dp[i][j] || dp[i - arr[j - 1]][j - 1];
                }


            }
        }

        return dp[target][n];

    }



    public static void main(String[] args) {



    }

}

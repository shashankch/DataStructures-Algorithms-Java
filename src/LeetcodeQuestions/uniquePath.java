package LeetcodeQuestions;

// https://leetcode.com/problems/unique-paths/
// https://leetcode.com/problems/unique-paths-ii/
public class uniquePath {


    //O(M*N)
    public static int uniquePathwithObstacles(int arr[][]) {


        int r = arr.length;
        int c = arr[0].length;

        if (arr[0][0] == 1) {
            return 0;
        }

        arr[0][0] = 1;

        for (int i = 1; i < r; i++) {

            arr[i][0] = (arr[i][0] == 0 && arr[i - 1][0] == 1) ? 1 : 0;
        }


        for (int i = 1; i < r; i++) {

            arr[0][i] = (arr[0][i] == 0 && arr[0][i - 1] == 1) ? 1 : 0;
        }


        for (int i = 1; i < r; i++) {

            for (int j = 1; j < c; j++) {

                if (arr[i][j] == 0) {
                    arr[i][j] = arr[i - 1][j] + arr[i][j - 1];
                } else {
                    arr[i][j] = 0;
                }
            }
        }


        return arr[r - 1][c - 1];


    }


    // Unique paths without any obstacles recursive and dp solution ...
    public int uniquePaths(int m, int n) {

        return solve(0, 0, m, n);
    }
// recursive
    public int solve(int i, int j, int m, int n) {
        if (i >= m || j >= n)
            return 0;
        if (i == m - 1 && j == n - 1)
            return 1;
        return solve(i + 1, j, m, n) + solve(i, j + 1, m, n);
    }


    int[][] dp = new int[101][101];
// dp ...
    public int uniquePathsDP(int m, int n) {

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                dp[i][j] = -1;

        return solvedp(0, 0, m, n);
    }

    public int solvedp(int i, int j, int m, int n) {
        if (i >= m || j >= n)
            return 0;
        if (i == m - 1 && j == n - 1)
            return 1;
        if (dp[i][j] != -1)
            return dp[i][j];
        return dp[i][j] = solve(i + 1, j, m, n) + solve(i, j + 1, m, n);
    }


    // convert into 1d dp method...
    static int numberOfPaths(int m, int n) {
        // Create a 1D array to store results of subproblems
        int[] dp = new int[n];
        dp[0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] += dp[j - 1];
            }
        }

        return dp[n - 1];
    }

    // using combinatorics..
    static int numberOfPaths2(int m, int n) {
        // We have to calculate m+n-2 C n-1 here
        // which will be (m+n-2)! / (n-1)! (m-1)!
        int path = 1;
        for (int i = n; i < (m + n - 1); i++) {
            path *= i;
            path /= (i - n + 1);
        }
        return path;
    }

    public static void main(String[] args) {

        int arr[][] = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};



        System.out.println();

    }

}

package LeetcodeQuestions;

public class PaintFenceDp {


    // paint fence n fence with k colour with atmost two fences can have same colour.
    public static long helper(int n, int k) {
        int mod = 1000000007;
        long total = k;
        int dp[] = new int[n + 1];
        // total ways to paint=same colour way+different colour way
        // for n=3 check for (same colour of first2+diff col of first2)*(k-1) choices total
        int same = 0, diff = k;
        dp[1] = k; // here if one fence then k choices
        for (int i = 1; i <= n; i++) {

            same = diff;

            diff = (int) total * (k - 1);
            diff = diff % mod;
            total = (same + diff) % mod;

        }


        return total;
    }



    public static void main(String[] args) {

        int n = 3, k = 2;
        System.out.println(helper(n, k));

    }

}

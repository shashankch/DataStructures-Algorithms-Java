package Prep;

import java.util.Scanner;

public class ShootingGameProbDp {

    public static void helper(int x, int y, int n, int w, int p, int q) {


        double dp[][] = new double[n + 1][w + 1];

        for (int i = 1; i <= w; i++) {
            dp[0][i] = 0;
        }
        for (int j = 1; j <= n; j++) {

            dp[j][0] = 1;
        }

        double pp = 0.01 * p;
        double qq = 0.01 * q;

        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= w; j++) {


                double p1 =
                        pp * (dp[i - 1][Math.max(j - x, 0)]) + (1 - pp) * (dp[i - 1][Math.max(j, 0)]);
                double p2 =
                        qq * (dp[i - 1][Math.max(j - y, 0)]) + (1 - qq) * (dp[i - 1][Math.max(j, 0)]);
                dp[i][j] = Math.max(p1, p2);

            }

        }

        System.out.format("%.6f",dp[n][w] * 100);



    }



    public static void main(String[] args) {


        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int x, y, n, w, p, q;
            x = sc.nextInt();
            y = sc.nextInt();
            n = sc.nextInt();
            w = sc.nextInt();
            p = sc.nextInt();
            q = sc.nextInt();
            helper(x, y, n, w, p, q);

        }

       



    }



}

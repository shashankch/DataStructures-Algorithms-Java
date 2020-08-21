package Prep;

public class commonChildLcs {


    public static int lcs(String a,String b)
    {

        int n = a.length();
        int m = b.length();

        int dp[][] = new int[n+1][m+1];

        for(int i=0;i<n;i++){

            for (int j = 0; j < m; j++) {
                
                if (a.charAt(i) == b.charAt(j)) {

                    dp[i + 1][j + 1] = dp[i][j] + 1;
                }
                else {
                    
                    dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
                }

            }
        }


        return dp[n][m];


    }

    public static void main(String[] args) {

        int ans = lcs("abcd", "abdc");

        System.out.println(ans);
    }
    
}
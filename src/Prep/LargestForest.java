package Prep;

import java.util.Scanner;

public class LargestForest {
    
    public static int helper(int i, int j, String mat[], int n) {

        if (i < 0 || i >= n || j < 0 || j >= n) {
            return 0;
        }
        if (mat[i].charAt(j) == 'X' || mat[i].charAt(j) == 'W') {
            return 0;
        }

        // mat[i][j] = 'X';

        int x[] = {0, 0, 1, -1};
        int y[] = {1, -1, 0, 0};
        int res = 1;
        for (int k = 0; k < 4; k++) {

            int xn = x[k] + i;
            int yn = y[k] + j;
            res += helper(xn, yn, mat, n);
        }


        return res;

    }

    public static void main(String[] args) {

       
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String mat[] = new String[n];
      
        for (int i = 0; i < n; i++) {
        
            mat[i] = sc.nextLine();
        
        }


      
        int ans = 0;
        for (int i = 0; i < n; i++) {


            for (int j = 0; j < n; j++) {
                if (mat[i].charAt(j) == 'T') {

                    ans = Math.max(ans, helper(i, j, mat, n));
                }
            }
        }


        System.out.print(ans);
        
    }

}
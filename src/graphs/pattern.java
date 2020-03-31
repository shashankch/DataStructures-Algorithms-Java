package graphs;

import java.util.Scanner;

public class pattern {

    public static boolean valid(int x, int y, int n, int m) {

        if (x < 0 && y < 0 && x >= n && y >= m) {
            return false;
        }

        return true;

    }
    public static int ans=0;
    public static int helper(String graph[], int i, int j, int pi, int n, int m, String pat, int[][] moves,
            int[][] used) {

        if (pi == pat.length()) {
            return 1;
        }

        used[i][j] = 1;

        for (int mv = 0; mv < 8; mv++) {

            int x = i + moves[mv][0];
            int y = j + moves[mv][1];

            if (valid(x, y, n, m) && graph[x].charAt(y) == pat.charAt(pi) && used[x][y] == 0) {

                ans = helper(graph, x, y, pi + 1, n, m, pat, moves, used);

               
            }
          
        }
        used[i][j] = 0;
        return ans;

    }

    public static int findpattern(String[] graph, int n, int m) {

        int moves[][] = { { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 }, { 0, -1 }, { -1, -1 }, { -1, 0 }, { -1, 1 } };

        String pat = "codingninja";
        int used[][] = new int[n][m];
        int flag = 0;
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < m; j++) {

                if (graph[i].charAt(j) == 'c') {

                    flag = helper(graph, i, j, 1, n, m, pat, moves, used);
                    if (flag == 1) {
                        break;
                    }
                }

            }
            if (flag == 1) {
                break;
            }

        }

        return flag;

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N, M, i;

        N = sc.nextInt();
        M = sc.nextInt();

        String[] Graph = new String[N];

        for (i = 0; i < N; i++) {

            Graph[i] = sc.next();

        }

        System.out.print(findpattern(Graph, N, M));
        sc.close();
    }
}
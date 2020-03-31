package graphs;

import java.util.Scanner;

public class cycle {
    public static int[] u = new int[1000];
    public static int[] v = new int[1000];

    public static int solve(int n, int m, int u[], int v[]) {

        int adj[][] = new int[n + 1][m + 1];
        for (int i = 0; i < m; i++) {

            adj[u[i]][v[i]] = 1;
            adj[v[i]][u[i]] = 1;

        }
        int cycle = 0;
        for (int p = 1; p <= n; p++) {

            for (int q = 1; q <= n; q++) {

                if (adj[p][q] == 1) {
                    for (int j = 1; j <= n; j++) {

                        if (adj[q][j] == 1) {

                            if (j != p) {
                                cycle++;
                            }
                        }

                    }
                }

            }
        }

        return cycle / 6;

    }

    public static void main(String[] args) {

        int n, m;
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        m = scan.nextInt();
        for (int i = 0; i < m; i++) {
            u[i] = scan.nextInt();
        }
        for (int i = 0; i < m; i++) {
            v[i] = scan.nextInt();
        }
        System.out.println(solve(n, m, u, v));

    }
}
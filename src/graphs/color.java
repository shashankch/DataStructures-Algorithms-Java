package graphs;

import java.util.Scanner;

public class color {

    public static int valid(int i, int j, int n, int m) {

        if (i >= 0 && i < n && j >= 0 && j < m) {
            return 1;
        }
        return 0;

    }

    public static int dx[] = { 1, -1, 0, 0 };
    public static int dy[] = { 0, 0, 1, -1 };
    public static int ans = 0;

    public static int helper(String board[], int n, int m, int i, int j, int[][] vis, char ch) {
        if (valid(i, j, n, m) == 0) {
            return 0;
        }
        if (board[i].charAt(j) != ch) {
            return 0;
        }
        if (vis[i][j] == 1) {
            return 1;
        }

        vis[i][j] = 1;
        // int ans=0;
        for (int mv = 0; mv < 4; mv++) {

            int x = i + dx[mv];
            int y = j + dy[mv];

            ans = helper(board, n, m, x, y, vis, ch);

        }

        return ans;

    }

    public static void initial(int[][] loop, int n, int m) {

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                loop[i][j] = 0;
            }
        }

    }

    public static int colorcycle(String[] board, int n, int m) {
        // Write your code here.

        int loopvisit[][] = new int[n][m];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (loopvisit[i][j] == 0) {

                    ans = helper(board, n, m, i, j, loopvisit, board[i].charAt(j));
                    initial(loopvisit, n, m);
                    if (ans == 1) {
                        return 1;
                    }
                }

            }
        }

        return 0;

    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int N, M, i;

        N = scan.nextInt();
        M = scan.nextInt();

        String[] board = new String[N];

        for (i = 0; i < N; i++) {

            board[i] = scan.next();

        }
        System.out.println(colorcycle(board, N, M));

    }
}

/*
 * import java.util.*; public class solution {
 * 
 * 
 * public static int valid(int i,int j,int n,int m ){
 * 
 * if(i>=0 && i<n && j>=0 && j<m){ return 1; } return 0;
 * 
 * } public static int loopvisit[][]; public static int dx[]={1,-1,0,0}; public
 * static int dy[]={0,0,1,-1}; public static int ans=0;
 * 
 * public static int helper(String board[],int n,int m,int i,int j,int
 * [][]vis,char ch,int pi,int pj){
 * 
 * if(valid(i,j,n,m)==0){ return 0; }
 * 
 * if(board[i].charAt(j)!=ch){ return 0; } if(vis[i][j]==1){ return 1; }
 * 
 * 
 * 
 * 
 * vis[i][j]=1; // int ans=0; for(int mv=0;mv<4;mv++){
 * 
 * int x=i+dx[mv]; int y=j+dy[mv];
 * 
 * if(pi==x && pj==y){ continue; } ans=helper(board,n,m,x,y,vis,ch,i,j);
 * 
 * }
 * 
 * 
 * //vis[i][j]=0;
 * 
 * 
 * return ans;
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * }
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * public static void initial(int [][]loop,int n,int m){
 * 
 * for(int i=0;i<n;i++){ for(int j=0;j<m;j++){ loop[i][j]=0; } }
 * 
 * 
 * }
 * 
 * 
 * 
 * 
 * 
 * 
 * int solve(String[] board , int n, int m) { // Write your code here.
 * 
 * loopvisit=new int[n][m]; for(int k=0;k<n;k++){ Arrays.fill(loopvisit[k],0); }
 * 
 * int res=-1; for(int i=0;i<n;i++) { for(int j=0;j<m;j++){
 * 
 * if(loopvisit[i][j]==0){
 * 
 * res=helper(board,n,m,i,j,loopvisit,board[i].charAt(j),-1,-1);
 * 
 * initial(loopvisit,n,m); if(res==1){ return 1; }
 * 
 * }
 * 
 * } }
 * 
 * 
 * 
 * 
 * 
 * return 0;
 * 
 * } }
 * 
 * 
 */
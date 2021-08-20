package backtracking;

public class NQueen {


    public static boolean issafe(int board[][],int i,int j,int n){

        for(int row=0;row<i;row++){

            if(board[row][j]==1){
                return false;
            }

        }

        int x=i;
        int y=j;

        while(x>=0 && y>=0){


            if(board[x][y]==1){
                return false;
            }
            x--;
            y--;

        }

        x=i;
        y=j;


        while(x>=0 && y<=n){

            if(board[x][y]==1){
                return false;
            }
            x--;
            y++;
        }
        return true;

    }

    public static boolean solve(int board[][],int i,int n){

        if(i==n+1){

            //  board[n][n]=1;
            for(int p=0;p<=n;p++){

                for(int q=0;q<=n;q++){

                    System.out.print(board[p][q]+" ");
                }
            }

            System.out.println();
            return false;
        }
         for(int j=0;j<=n;j++){

             if(issafe(board,i,j,n)){

                board[i][j]=1;
                boolean result=solve(board,i+1,n);
                if(result){

                    return true;
                }

                board[i][j]=0;

            }

        }

        return false;

    }

    public static void placeNQueens(int n){

        int board[][]=new int[n][n];
        boolean ans= solve(board,0,n-1);

    }

}

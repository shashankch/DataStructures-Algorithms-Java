package backtracking;

public class RatInMazeProblem {

    //one unique path
    public static boolean helper2(int maze[][],int i,int j,int n,int m,int soln[][])
    {


        if(i==n && j==m)
        {

            return true;


        }

        if(i>n || j>m || i<0 || j<0 || maze[i][j]==0 || soln[i][j]==1){

            return false;
        }

        soln[i][j]=1;

        boolean left=helper2(maze,i,j-1,n,m,soln);
        boolean right=helper2(maze,i,j+1,n,m,soln);
        boolean top=helper2(maze,i-1,j,n,m,soln);
        boolean down=helper2(maze,i+1,j,n,m,soln);


        soln[i][j]=0;


        if(left){


            return true;


        }

        if(right){
            return true;
        }


        if(top){
            return true;
        }


        if(down){
            return true;
        }


        return false;

    }



    //all paths
    public static boolean helper(int maze[][],int i,int j,int n,int m,int soln[][])
    {
        if(i==n && j==m)
        {

            soln[i][j]=1;
            for(int p=0;p<=n;p++){
                for(int q=0;q<=m;q++){

                    System.out.print(soln[p][q]+" ");

                }
            }
            System.out.println();
            return true;

        }

        if(i>n || j>m || i<0 || j<0 || maze[i][j]==0 || soln[i][j]==1){

            return false;
        }

        soln[i][j]=1;

        boolean left=helper(maze,i,j-1,n,m,soln);
        boolean right=helper(maze,i,j+1,n,m,soln);
        boolean top=helper(maze,i-1,j,n,m,soln);
        boolean down=helper(maze,i+1,j,n,m,soln);

        soln[i][j]=0;

        if(left){

            return true;

        }

        if(right){
            return true;
        }


        if(top){
            return true;
        }


        if(down){
            return true;
        }
         return false;

    }

    public static void ratInAMaze(int maze[][]) {
       int n=maze.length;
        int soln[][]=new int[n][n];
        boolean ans= helper(maze,0,0,n-1,n-1,soln);
        helper2(maze,0,0,n-1,n-1,soln);
    }

}

package arrays;

public class practiceProblems {

    public static void sumBoundariesdiagonal(int n) {

        int arr[][]=new int[n][n];

        for(int i=0;i<n;i++){

            for(int j=0;j<n;j++){

            //    arr[i][j]=sc.nextInt();

            }
        }

        int sum=0;
        for(int i=0;i<n;i++){

            for(int j=0;j<n;j++){


                if(i==0 || j==0 || i==n-1 || j==n-1 || i==j || (i+j)==n-1){

                    sum+=arr[i][j];
                }

            }


        }

        System.out.print(sum);

    }

    // input - input 2D array
    public static void wavePrint(int input[][]){

        for(int j=0;j<input[0].length;j++){


            if((j&1)>0){


                for(int i=input.length-1;i>=0;i--){

                    System.out.print(input[i][j]+" ");

                }

            }
            else{

                for(int i=0;i<input.length;i++){

                    System.out.print(input[i][j]+" ");
                }

            }

        }

    }
    public static void spiralPrint(int matrix[][]){

        int r=matrix.length;
        int c=matrix[0].length;

        int sc=0,ec=c-1;
        int sr=0,er=r-1;

        while(sc<=ec && sr<=er){


            // print from left to right
            for(int j=sc;j<=ec;j++){

                System.out.print(matrix[sr][j]+" ");
            }

            sr++;

            // print top to bottom
            for(int i=sr;i<=er;i++){

                System.out.print(matrix[i][ec]+" ");

            }

            ec--;

            // print from right to left
            if(sr<=er){
                for(int j=ec;j>=sc;j--){

                    System.out.print(matrix[er][j]+" ");
                }

                er--;
            }

            if(sc<=ec){
                // print from bottom to top..
                for(int i=er;i>=sr;i--){

                    System.out.print(matrix[i][sc]+" ");

                }

                sc++;
            }
        }

    }

   // Leader, if all the elements following it (i.e. present at its right) are less than or equal to A[i].
   public static void leaders(int[] input) {
       int n=input.length;
       int max=input[n-1];
       System.out.print(max+" ");
       for(int i=n-2;i>=0;i--){


           if(input[i]>=max){
               System.out.print(input[i]+" ");
               max=input[i];
           }

       }

   }

   public static String minLengthWord(String input){

        int n=input.length();
        int min=Integer.MAX_VALUE;
        int start=0;
        int pos=-1;
        for(int i=0;i<n;i++){


            if(input.charAt(i)==' ' || i==input.length()-1){


                if(i==input.length()-1){


                    int end=input.length()-1;
                    int curlen=end-start+1;

                    if(curlen<min){
                        min=curlen;
                        pos=start;
                    }

                }
                else{

                    int end=i-1;
                    int curlen=end-start+1;

                    if(curlen<min){
                        min=curlen;
                        pos=start;
                    }

                    start=i+1;

                }



            }



        }

        String ans="";
        while(pos<n && input.charAt(pos)!=' ')
        {

            ans+=input.charAt(pos)+"";
            pos++;


        }


        return ans;



    }

    //two sorted array increasing order find intersection path maxsum
    public static long maximumSumPath(int[] input1, int[] input2) {

        int n=input1.length;
        int m=input2.length;

        int i=0,j=0;
        long one=0,two=0,sum=0;

        while(i<n && j<m){


            if(input1[i]<input2[j]){

                one+=input1[i];
                i++;
            }

            else if(input2[j]<input1[i]){

                two+=input2[j];
                j++;
            }
            else if(input1[i]==input2[j]){

                one+=input1[i];
                two+=input2[j];
                i++;
                j++;


                sum+=Math.max(one,two);

                one=0;
                two=0;
            }


        }

        while(i<n){

            one+=input1[i];
            i++;

        }

        while(j<m){

            two+=input2[j];
            j++;
        }

        sum+=Math.max(one,two);

        return sum;

    }
}

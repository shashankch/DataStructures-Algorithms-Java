package strings;

import java.util.*;

public class practiceProblems {

    // largest pal string by changing k digits. return lex largest possible string
    public static void main(String number,int k) {


        StringBuffer temp=new StringBuffer(number);


        // first to check all the changes required.

        int start=0,end=number.length()-1;

        while(start<end){


            if(number.charAt(start)!=number.charAt(end)) {


                if(number.charAt(start)>number.charAt(end)){

                    temp.setCharAt(start,number.charAt(start));
                    temp.setCharAt(end,number.charAt(start));
                }
                else{
                    temp.setCharAt(start,number.charAt(end));
                    temp.setCharAt(end,number.charAt(end));
                }


                k--;
            }


            start++;
            end--;

        }


        if(k<0){

            System.out.print("NOT POSSIBLE");
        }

        else{
            //  System.out.print
            int low=0;
            int high=number.length()-1;


            while(low<=high){


                if(low==high && k>0){


                    temp.setCharAt(low,'9');

                }


                if(temp.charAt(low)<'9'){


                    if(k>=2 && ((number.charAt(low)==temp.charAt(low)) && (number.charAt(high)==temp.charAt(high))) ) {

                        temp.setCharAt(low,'9');
                        temp.setCharAt(high,'9');


                        k-=2;
                    }

                    else if(k>=1  && ((number.charAt(low)!=temp.charAt(low)) || (number.charAt(high)!=temp.charAt(high)) ) ){

                        temp.setCharAt(low,'9');
                        temp.setCharAt(high,'9');

                        k--;
                    }


                }


                low++;
                high--;

            }

            System.out.print(temp);
        }

    }

    //first lex pal string
    public static String nextPalindrome(String input) {

        int n=input.length();

        int freq[]=new int[26];

        for(int i=0;i<n;i++){

            freq[input.charAt(i)-'a']++;

        }

        if(n%2==0){

            for(int i=0;i<26;i++){

                if(freq[i]!=0 && freq[i]%2!=0){

                    return "";

                }
            }


            int l=0,h=input.length()-1;

            char temp[]=input.toCharArray();

            for(int i=0;i<26;i++){

                if(freq[i]!=0){

                    while(freq[i]>0){
                        temp[l]=temp[h]=(char)(i+'a');

                        l++;
                        h--;
                        freq[i]-=2;
                    }
                }

            }

            String ans="";
            for(int i=0;i<input.length();i++){

                ans+=temp[i];
            }


            return ans;

        }

        else{

            char od=' ';
            int count=0;
            for(int i=0;i<26;i++){


                if(freq[i]!=0 && freq[i]%2!=0){
                    count++;
                    od=(char)(i+'a');
                }
            }

            if(count!=1){
                return "";
            }




            int l=0,h=input.length()-1;

            char temp[]=input.toCharArray();

            temp[input.length()/2]=od;

            for(int i=0;i<26;i++){

                if(freq[i]>1){
                    while(freq[i]>0){
                        temp[l]=temp[h]=(char)(i+'a');

                        l++;
                        h--;
                        freq[i]-=2;
                    }
                }

            }

            String ans="";
            for(int i=0;i<input.length();i++){

                ans+=temp[i];
            }


            return ans;






        }

    }

    public static void largestNonPalString(String str) {

        int n=str.length();

        int freq[]=new int[26];

        for(int i=0;i<n;i++){


            freq[str.charAt(i)-'a']++;

        }

        int count=0;
        for(int i=0;i<26;i++){


            if(freq[i]!=0){

                count++;
            }

        }

        if(count==1){

            System.out.print(0);

        }

        else{


            int l=0,h=str.length()-1;
            boolean flag=false;
            while(l<h){

                if(str.charAt(l)!=str.charAt(h)){
                    System.out.print(n);
                    flag=true;
                    break;
                }
                l++;
                h--;
            }

            if(flag!=true){

                System.out.print(n-1);
            }

        }

    }

    public static void excelProblemfindcolbyExcelNo(int n) {

       // Scanner sc=new Scanner(System.in);

        //int n=sc.nextInt();
        int rem=0,q=0;
        String ans="";
        while(n!=0){


            rem=n%26;
            q=n/26;

            if(rem==0){

                ans="Z"+ans;
                n=q-1;
            }
            else {

                char ch=(char)(rem-1+'A');
                ans=ch+""+ans;
                n=q;

            }


        }


        System.out.print(ans);
    }


    // make all cells in that row/col as 1 if any cell is 1.
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();
        int m=sc.nextInt();

        int arr[][]=new int[n][m];

        for(int i=0;i<n;i++){


            for(int j=0;j<m;j++){


                arr[i][j]=sc.nextInt();


            }

        }

        boolean row=false;
        boolean col=false;

        for(int i=0;i<n;i++){


            for(int j=0;j<m;j++){


                // check for 1 in row
                if(i==0 && arr[i][j]==1){

                    row=true;
                }

                //check for 1 in col

                if(j==0 && arr[i][j]==1){

                    col=true;
                }

                // check for 1 in each cell and set in first row and col.
                if(arr[i][j]==1){

                    arr[i][0]=arr[0][j]=1;
                }



            }
        }

        // check for submatrix.
        for(int i=1;i<n;i++){

            for(int j=1;j<m;j++){

                // check in helper row and column..
                if(arr[i][0]==1 || arr[0][j]==1){

                    arr[i][j]=1;

                }



            }


        }

        if(row==true){

            for(int j=0;j<m;j++){

                arr[0][j]=1;
            }

        }

        if(col==true){


            for(int i=0;i<n;i++){

                arr[i][0]=1;
            }


        }



        for(int i=0;i<n;i++){

            for(int j=0;j<m;j++){

                System.out.print(arr[i][j]+" ");
            }

            System.out.println();
        }


    }

    // rotate by 90 anticlockwise
    public static void rotate(int input[][]){

        int n=input.length;


        for(int i=0;i<n;i++){


            for(int j=i;j<n;j++)
            {

                int temp=input[i][j];
                input[i][j]=input[j][i];
                input[j][i]=temp;



            }

        }


        for(int j=0;j<n;j++){


            for(int i=0;i<n/2;i++){

                int temp=input[i][j];
                input[i][j]=input[n-i-1][j];
                input[n-i-1][j]=temp;


            }

        }


    }
}

package fundamentals;

import java.util.Scanner;

public class isocelespattern {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int i=1;
        int row=(n+1)/2;

        // first part
        while(i<=row){

            int space=1;
            while(space<=row-i){
                System.out.print(" ");
                space=space+1;
            }
            int j=1;
            while(j<=i){

                System.out.print("*");
                j=j+1;
            }
            int dec=i-1;
            while(dec>=1){

                System.out.print("*");

                dec=dec-1;
            }


            System.out.println();
            i=i+1;
        }

        //second part
        int end=n/2;
        int k=1;
        while(k<=end){
            int j=1;
            while(j<=k){
                System.out.print(" ");
                j=j+1;
            }
            int stars=1;
            while(stars<=end-k+1){
                System.out.print("*");
                stars=stars+1;
            }
            int np=end-k;
            // int np=stars-2;
            while(np>=1){
                System.out.print("*");
                np=np-1;
            }

            System.out.println();
        k=k+1;
        }



    }
}

package fundamentals;

import java.util.Scanner;

public class halfdiamond {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int i=1;

        System.out.println("*");
        while(i<=n){

            System.out.print("*");
            int j=1;
            while(j<=i){
                System.out.print(j);

                j=j+1;
            }
            int dec=i-1;
            while(dec>=1){

                System.out.print(dec);

                dec=dec-1;
            }
            System.out.print("*");


            System.out.println();
            i=i+1;
        }

        //second part..

        int end=n-1;
        int k=1;
        while(k<=end){
            System.out.print("*");
            int j=1;
            while(j<=end-k+1){
                System.out.print(j);
                j=j+1;
            }
//            int dec=j-2;
            int dec=end-k;
            while(dec>=1){
                System.out.print(dec);
                dec=dec-1;
            }

            System.out.println("*");
            k=k+1;
        }




        System.out.print("*");






    }
}

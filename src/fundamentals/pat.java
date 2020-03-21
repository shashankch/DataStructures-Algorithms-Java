package fundamentals;

import java.util.Scanner;

public class pat{






public static void main(String[] args) {
    
Scanner sc=new Scanner(System.in);

int n=sc.nextInt();

for(int i=1;i<=n;i++){

    for(int j=1;j<=2*n;j++){

        if(j<=(n-i+1)){
            System.out.print(j);
        }
        else if(j>(n+i-1)){
            System.out.print((2*n-j)+1);
        }
        else{
            System.out.print("*");
        }

    }

    System.out.println();

}




}




}
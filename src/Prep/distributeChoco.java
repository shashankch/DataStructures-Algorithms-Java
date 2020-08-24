package Prep;

import java.util.Scanner;

public class distributeChoco {



    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            
            int c=sc.nextInt();
            int n=sc.nextInt();
            if (n * (n + 1) / 2 > c) {
                System.out.println(c);
            }
            else {
                
                int k = (c - n * (n - 1) / 2) / n;
                System.out.println(c - n * k - n * (n - 1) / 2);

            }

        }
        

    }
    
}


// = k + (k + 1) + (k + 2) + . . . . + (k + n - 1)

// = n * k + (1 + 2 + . . . . + n - 1)

// = n * k + n * (n - 1) / 2
package fundamentals;

import java.util.Scanner;

public class patternnew {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int i = 1;

        while (i <= n) {

            int j = 1;
            while (j <= n) {

                if (i == n - j + 1) {
                    System.out.print("*");
                } else {

                    System.out.print(n - j + 1);

                }
                j = j + 1;

            }

            i = i + 1;
            System.out.println();
        }

    }

}

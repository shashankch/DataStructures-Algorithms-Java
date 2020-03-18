package fundamentals;

public class pattern {

    public static void main(String[] args) {
        int i, j, n = 10;
        for (i = 1; i <= n; i++) {

            for (j = 1; j <= n; j++) {

                if (j == n - i + 1) {
                    int c = 1;
                    while (c <= i) {
                        System.out.print(c + " ");
                        c++;
                    }
                } else {
                    System.out.print("  ");
                }
            }
            System.out.print("\n");
        }

    }
}

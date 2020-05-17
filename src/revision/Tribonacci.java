package revision;

import java.util.HashMap;

public class Tribonacci {

    public int tribonacci(int n) {

        if (n == 0) {
            return n;
        }
        if (n <= 2) {
            return 1;
        }
        int a = 0, b = 1, c = 1, d;
        for (int i = 3; i <= n; i++) {

            d = a + b + c;
            a = b;
            b = c;
            c = d;
        }

        return c;

    }

    private static HashMap<Integer, Integer> result = null;

    public int tribonacci2(int n) {
        if (result == null) {
            result = new HashMap<>();
        }
        if (n <= 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }
        if (result.containsKey(n)) {
            return result.get(n);
        }
        int valu = tribonacci2(n - 1) + tribonacci2(n - 2) + tribonacci2(n - 3);
        result.put(n, valu);
        return valu;
    }

    int trib[] = new int[38];

    public int tribonacci3(int n) {
        if (n == 0)
            return 0;
        else if (n <= 2)
            return 1;
        if (trib[n] != 0)
            return trib[n];
        int val1 = tribonacci3(n - 1);
        int val2 = tribonacci3(n - 2);
        int val3 = tribonacci3(n - 3);

        trib[n - 1] = val1;
        trib[n - 2] = val2;
        trib[n - 3] = val3;

        return val1 + val2 + val3;

    }

}

    public static void main(String[] args) {

    }

}


package revision;

import java.util.*;

class Codechef {

    public static long kadane(long arr[]) {

        int n = arr.length;
        long cs = 0, mx = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {

            cs += arr[i];

            if (cs < 0)
                cs = 0;
            else
                mx = Math.max(mx, cs);
        }

        return mx;

    }

    public static long accumulate(long arr[]) {

        long sum = 0;
        for (int i = 0; i < arr.length; i++) {

            sum += arr[i];
        }
        return sum;
    }

    public static void main(String[] args) throws java.lang.Exception {

        int t;
        Scanner sc = new Scanner(System.in);

        t = sc.nextInt();

        while (t-- > 0) {

            int n, k;
            n = sc.nextInt();
            k = sc.nextInt();

            long arr[] = new long[n];

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextLong();
            }

            long maxsum = kadane(arr);

            if (k == 1) {
                System.out.println(maxsum);
            } else {

                long total = accumulate(arr);

                long prefix = 0, suffix = 0, p = 0, s = 0;
                for (int i = 0; i < n; i++) {
                    p += arr[i];
                    s += arr[n - i - 1];
                    prefix = Math.max(prefix, p);
                    suffix = Math.max(suffix, s);
                }

                if (total > 0) {
                    maxsum = Math.max((((k - 2) * total) + prefix + suffix), maxsum);
                    System.out.println(maxsum);
                } else {
                    System.out.println(prefix + suffix);
                }

            }

        }

    }
}

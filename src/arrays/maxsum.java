package arrays;

public class maxsum {

    public static int maxsumbrute(int arr[], int n) { // O(N^3)

        int ans = Integer.MIN_VALUE;
        for (int sub_array_size = 1; sub_array_size <= n; ++sub_array_size) // O(n)
        {
            for (int start_index = 0; start_index < n; ++start_index) // O(n)
            {
                if (start_index + sub_array_size > n) // Subarray exceeds array bounds
                    break;
                int sum = 0;
                for (int i = start_index; i < (start_index + sub_array_size); i++) // O(n)
                    sum += arr[i];
                ans = Math.max(ans, sum);
            }
        }
        return ans;

    }

    public static int maxsum2(int arr[], int n) { // O(N^2)
        int ans = Integer.MIN_VALUE;
        for (int start_index = 0; start_index < n; ++start_index) // O(n)
        {
            int sum = 0;
            for (int sub_array_size = 1; sub_array_size <= n; ++sub_array_size) // O(n)
            {
                if (start_index + sub_array_size > n) // Subarray exceeds array bounds
                    break;
                sum += arr[start_index + sub_array_size - 1]; // Last element of the new Subarray
                ans = Math.max(ans, sum);
            }
        }
        return ans;
    }

    public static int mxfind(int arr[], int l, int m, int h) {

        // calculate best suffix sum of left sub array..
        int sum = 0;
        int left = Integer.MIN_VALUE;
        for (int i = m; i >= l; i--) {
            sum += arr[i];
            if (sum > left) {
                left = sum;
            }
        }

        // calculate best prefix sum of right sub array..

        sum = 0;
        int right = Integer.MIN_VALUE;
        for (int i = m + 1; i <= h; i++) {
            sum += arr[i];
            if (sum > right) {
                right = sum;
            }
        }

        return left + right;

    }

    public static int mxsumdivideconq(int arr[], int l, int h) { // 2T(n/2)+kn==O(nlogn) approach.

        if (l == h) {
            return arr[l];
        }

        int mid = (l + h) / 2;
        int left = mxsumdivideconq(arr, l, mid);
        int right = mxsumdivideconq(arr, mid + 1, h);
        int bothlr = mxfind(arr, l, mid, h);

        return Math.max(bothlr, Math.max(left, right));

    }

    public static int maxsum4(int arr[], int n) { // O(N) approach.

        int cs = 0, ms = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {

            cs += arr[i];
            if (ms < cs) {
                ms = cs;
            }

            if (cs < 0) {
                cs = 0;
            }

        }

        return ms;

    }

    public static void main(String[] args) {

        // Scanner sc = new Scanner(System.in);
        // int n = sc.nextInt();
        int arr[] = { 3, -2, 5, -1 };
        int n = 4;
        System.out.println(mxsumdivideconq(arr, 0, n - 1));
    }
}
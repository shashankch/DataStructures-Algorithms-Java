package revision;

public class slidingwinMaxsubarrsum {

    






    public static int slidingwin(int arr[], int k) {

        int n = arr.length;
        int mx = 0;
        // first compute the sum of k elements
        for (int i = 0; i < k; i++) {
            mx += arr[i];

        }

        int win = mx;
        for (int i = k; i < n; i++) {

            win += arr[i] - arr[i - k];
            mx = Math.max(mx, win);

        }

        return mx;


    }



    public static void main(String[] args) {

    }



}

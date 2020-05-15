package revision;

import java.util.Stack;

public class slidingwinMaxsubarrsum {



    public static void slidewinmaxsum(int arr[], int n, int k) {

        int mx;
        for (int i = 0; i <= n - k; i++) {

            mx = arr[i];

            for (int j = 1; j < k; j++) {

                if (arr[i + j] > mx) {
                    mx = arr[i + j];
                }
            }
            System.out.println(mx + " ");

        }



    }

    // max
    public static void stackslidemaxsum(int arr[], int n, int k) {


        Stack<Integer> stk = new Stack<>();

        stk.push(0);
        int mx[] = new int[n];
        for (int i = 0; i < n; i++) {

            while (!stk.isEmpty() && arr[i] > arr[stk.peek()]) {

                mx[stk.peek()] = i - 1;
                stk.pop();
            }
            stk.push(i);

        }

        while (!stk.isEmpty()) {
            mx[stk.peek()] = n - 1;
            stk.pop();
        }


        int j = 0;

        for (int i = 0; i <= n - k; i++) {

            // check whether j index element is outside the window.
            while (j < i || mx[j] < i + k - 1) {
                j++;
            }

            System.out.println(arr[j] + " ");


        }


        



    }



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

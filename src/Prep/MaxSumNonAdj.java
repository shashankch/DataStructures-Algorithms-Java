package Prep;

public class MaxSumNonAdj {


    public static int helper2(int arr[], int i, int prev) {


        if (i == arr.length) {

            return 0;
        }

        int ex = helper2(arr, i + 1, prev);

        int in = 0;

        if (prev + 1 != i) {

            in = helper2(arr, i + 1, i) + arr[i];

        }


        return Math.max(ex, in);



    }


    public static int helper(int arr[]) {

        int inc = arr[0];
        int exc = 0;
        int temp;

        for (int i = 1; i < arr.length; i++) {

            temp = Math.max(inc, exc);

            inc = exc + arr[i];
            exc = temp;



        }


        return Math.max(inc, exc);



    }

    public static void main(String[] args) {


        int arr[] = {-2, 1, 3, -4, 5};

        System.out.println(helper(arr));


    }

}

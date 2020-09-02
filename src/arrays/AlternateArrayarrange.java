package arrays;

public class AlternateArrayarrange {


    public static int[] helper(int n) {



        int arr[] = new int[n];
        int val = 1, s = 0, e = n - 1;
        while (s < e) {


            arr[s] = val;
            val++;
            arr[e] = val;

            val++;

            s++;
            e--;

        }

        if (n % 2 != 0) {

            arr[s] = val;
        }


        return arr;

    }


    public static void main(String[] args) {

    }
}

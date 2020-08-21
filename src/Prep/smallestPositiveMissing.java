package Prep;

public class smallestPositiveMissing {

    // naive search each number from array. O(n^2)
    // sort the number and check missing no. O(nlogn +n)
    // use hashing o(n) and space O(n)

    // o(1) space
    public static int helper(int arr[]) {


        int index = helper2(arr);

        int a[] = new int[arr.length - index];
        int j = 0;
        for (int i = index; i < arr.length; i++) {

            a[j++] = arr[i];

        }

        for (int k = 0; k < j; k++) {

            int x = Math.abs(a[k]);

            if (x - 1 < j && a[x - 1] > 0) {

                a[x - 1] = -a[x - 1];
            }


        }


        for (int y = 0; y < j; y++) {
            if (a[y] > 0) {
                return y + 1;
            }
        }


        return j + 1;

    }

    public static int helper2(int arr[]) {

        int j = 0;
        for (int i = 0; i < arr.length; i++) {


            if (arr[i] <= 0) {

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }


        }

        return j;

    }



    public static void main(String[] args) {

        int arr[] = {-5, 2, 0, -1, -10, 15};

        System.out.println(helper(arr));


    }
}

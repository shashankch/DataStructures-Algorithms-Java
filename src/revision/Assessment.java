package revision;

/*
 * // Q1. Approach : divided array into 3 slots(0|1|2) and using index pointer mid,low,high moved
 * 0,1,2 to // the respective slot by swapping. first took mid and low pointer in the starting for
 * 0,1 and high // for 2. Then check if current element is 1 then just increment mid pointer as 1
 * lies in mid and if // element is 0 then swapped mid and low to move 0 in the beginning. similarly
 * for 2, did swap of // mid and high(pointing to last index of array) to push 2 in the end.
 * 
 * ***
 * 
 * Q2. Approach: to print in the wave form. As there can be many possible solutions. here i
 * traversed on even indexed elements and checked for prev and next element if it is greater than
 * current even indexed element or not if it is then just swap the current element with that prev
 * and next element. only single traversal is needed. we can also traverse on odd indexed element
 * and perform the same operation to sort elements in wave like form.
 * 
 */



public class Assessment {

    public static void helper(int[] input) { // Q1. Time complexity: O(length of input array)

        int mid = 0, low = 0, high = input.length - 1;

        while (mid <= high) {

            if (input[mid] == 1) {
                mid++;

            } else if (input[mid] == 0) {
                int temp = input[low];
                input[low] = input[mid];
                input[mid] = temp;
                low++;
                mid++;
            } else if (input[mid] == 2) {
                int temp = input[high];
                input[high] = input[mid];
                input[mid] = temp;
                mid++;
                high--;
            }

        }

    }

    public static void swapHelper(int first, int second, int input[]) {

        int temp = input[first];
        input[first] = input[second];
        input[second] = temp;



    }


    public static void helper2(int[] input) { // Q2. Time complexity: O(length of input array)

        int n = input.length - 1;
        for (int i = 0; i <= n; i += 2) {

            if (i < n && input[i] < input[i + 1]) {

                swapHelper(i, i + 1, input);
            }

            if (i > 0 && input[i] < input[i - 1]) {
                swapHelper(i, i - 1, input);
            }


        }



    }


    public static int[] sortArray(int[] input) {

        // helper(input); //Q1.
        helper2(input); // Q2.
        return input;


    }

    public static void main(String[] args) {

        int arr[] = {20, 10, 8, 6, 4, 2};
        // 20, 10, 8, 6, 4, 2
        // int input[] = {0, 1, 0, 2, 0, 1, 2, 0};
        int res[] = sortArray(arr);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }

    }

}

package arrays;

public class arraySum {


    public static int sum(int[] input) {

        int sum = 0;
        for (int i = 0; i < input.length; i++) {

            sum += input[i];


        }


        return sum;

    }

    public static int linearSearch(int[] arr, int num) {


        for (int i = 0; i < arr.length; i++) {


            if (arr[i] == num) {

                return i;
            }


        }

        return -1;


    }

    public static void main(String[] args) {

    }


}

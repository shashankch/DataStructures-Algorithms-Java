package arrays;

import java.util.Arrays;

public class PairSum {
    public static void pairSum1(int[] arr, int num) {

        Arrays.sort(arr);

        int l = 0, h = arr.length - 1;

        while (l < h) {

            if (arr[l] + arr[h] == num) {

                int end = h;
                while (arr[l] + arr[end--] == num) {
                    System.out.println(arr[l] + " " + arr[h]);
                }
                l++;

            } else if (arr[l] + arr[h] > num) {

                h--;

            }

            else {

                l++;
            }

        }

    }


    public static void pairSum2(int[] input, int x) {

        for (int i = 0; i < input.length - 1; i++) {

            for (int j = i + 1; j < input.length; j++)

            {

                if (input[i] + input[j] == x) {

                    if (input[i] < input[j]) {
                        System.out.println(input[i] + " " + input[j]);
                    } else {
                        System.out.println(input[j] + " " + input[i]);
                    }

                }



            }
        }



    }
    
    public static void main(String[] args) {
        
    }
}

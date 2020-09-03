package arrays;

import java.util.Scanner;
import java.util.Arrays;

public class tripletsum {

    public static void tripletfun(int arr[], int n, int x) {

        Arrays.sort(arr);
        for (int i = 0; i < n; i++) {

            int start = i + 1;
            int end = arr.length - 1;
            int val = x - arr[i];

            while (start < end) {

                if (arr[start] + arr[end] < val) {
                    start++;
                } else if (arr[start] + arr[end] > val) {

                    end--;
                } else {

                    int cstart = 0, cend = 0;
                    for (int p = start; p <= end; p++) {

                        if (arr[p] == arr[start]) {
                            cstart++;
                        } else {
                            break;
                        }
                    }

                    for (int p = end; p >= start; p--) {

                        if (arr[p] == arr[end]) {
                            cend++;
                        } else {
                            break; /// for contnuous duplicates..
                        }
                    }

                    int pairs = cstart * cend;
                    if (arr[start] == arr[end]) {
                        pairs = ((end - start + 1) * (end - start)) / 2;
                    }

                    // print all triplet pairs.taking duplicates into account..
                    for (int k = 0; k < pairs; k++) {

                        System.out.println(arr[i] + " " + arr[start] + " " + arr[end]);

                    }

                    end -= cend;
                    start -= cstart;

                }

            }

        }

    }

    public static void tripletfun2(int[] input, int x) {

        Arrays.sort(input);
        for (int i = 0; i < input.length; i++) {

            for (int j = i + 1; j < input.length; j++) {

                for (int k = j + 1; k < input.length; k++) {

                    if (input[i] + input[j] + input[k] == x) {

                        System.out.println(input[i] + " " + input[j] + " " + input[k]);

                    }


                }
            }


        }


    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {

            arr[i] = sc.nextInt();
        }

        int x;
        x = sc.nextInt();

        tripletfun(arr, n, x);

    }

}

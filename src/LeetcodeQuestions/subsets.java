package LeetcodeQuestions;

import java.util.ArrayList;
import java.util.List;

public class subsets {



    public static void subset(int k, int arr[], List<Integer> out, int i,
            List<List<Integer>> result) {

        if (out.size() == k) {
            result.add(new ArrayList<Integer>(out));
        }

        for (int j = i; j < arr.length; j++) {

            out.add(arr[j]);
            subset(k, arr, out, j + 1, result);
            out.remove(out.size() - 1);



        }



    }



    public static List<List<Integer>> helper(int arr[]) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> out = new ArrayList<>();

        for (int k = 0; k <= arr.length; k++) {
            subset(k, arr, out, 0, result);
        }

        return result;
    }

    // O(N*2^N)
    public static List<List<Integer>> helper2(int arr[]) {

        List<List<Integer>> output = new ArrayList<>();
        int n = arr.length;

        for (int i = (int) Math.pow(2, n); i < (int) Math.pow(2, n + 1); ++i) {
            // generate bitmask, from 0..00 to 1..11
            String bitmask = Integer.toBinaryString(i).substring(1);

            List<Integer> curr = new ArrayList<>();
            for (int j = 0; j < n; ++j) {
                if (bitmask.charAt(j) == '1')
                    curr.add(arr[j]);
            }
            output.add(curr);
        }
        return output;


    }


    public static void main(String[] args) {

        int arr[] = {1, 2, 3};
        for (List<Integer> li : helper(arr)) {

            System.out.println(li);

        }

    }

}

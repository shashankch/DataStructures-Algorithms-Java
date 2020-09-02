package LeetcodeQuestions;

import java.util.ArrayList;
import java.util.List;

public class SubsetSum {



    public static void helper(int arr[], int tar, int sum, int i, List<Integer> out,
            List<List<Integer>> res) {


        if (sum > tar) {
            return;
        }
        if (tar == sum) {

            res.add(new ArrayList<>(out));
            return;
        }


        for (int k = i; k < arr.length; k++) {

            out.add(arr[k]);
            helper(arr, tar, sum + arr[k], k, out, res);
            out.remove(out.size() - 1);
        }



    }


    public static List<List<Integer>> combSum(int arr[], int tar) {

        List<Integer> out = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        helper(arr, tar, 0, 0, out, res);

        return res;


    }



    public static void main(String[] args) {

        int arr[] = {2, 3, 6, 7};
        int tar = 7;
        for (List<Integer> li : combSum(arr, tar)) {

            System.out.println(li);

        }



    }



}

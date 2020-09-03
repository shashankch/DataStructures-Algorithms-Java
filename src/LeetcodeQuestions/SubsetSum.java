package LeetcodeQuestions;

import java.util.ArrayList;
import java.util.Arrays;
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


    // Method 2------------>

    public static void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int remain,
            int start) {
        if (remain < 0)
            return;
        else if (remain == 0)
            list.add(new ArrayList<>(tempList));
        else {
            for (int i = start; i < nums.length; i++) {
                tempList.add(nums[i]);
                backtrack(list, tempList, nums, remain - nums[i], i); // not i + 1 because we can
                                                                      // reuse same elements
                tempList.remove(tempList.size() - 1);
            }
        }
    }


// Method 2---> with duplicate values..  can't reuse same element
    public static void backtrack2(List<List<Integer>> list, List<Integer> tempList, int[] nums, int remain,
            int start) {
        if (remain < 0)
            return;
        else if (remain == 0)
            list.add(new ArrayList<>(tempList));
        else {
            for (int i = start; i < nums.length; i++) {
                if (i > start && nums[i] == nums[i - 1])
                    continue; // skip duplicates
                tempList.add(nums[i]);
                backtrack2(list, tempList, nums, remain - nums[i], i + 1);
                tempList.remove(tempList.size() - 1);
            }
        }
    }


    public List<List<Integer>> helper2(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, target, 0);
        return list;

    }

    public static void main(String[] args) {

        int arr[] = {2, 3, 6, 7};
        int tar = 7;
        for (List<Integer> li : combSum(arr, tar)) {

            System.out.println(li);

        }



    }



}

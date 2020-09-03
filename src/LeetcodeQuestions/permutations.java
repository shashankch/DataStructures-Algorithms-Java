package LeetcodeQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/permutations/


// https://github.com/shashankch/DataStructures-Algo-Java/blob/master/src/PrepStringPermuteBacktrack.java

public class permutations {

    public static void permute(int[] nums, int i, List<List<Integer>> list) {
        if (i == nums.length) {
            List<Integer> sublist = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                sublist.add(nums[j]);
            }
            list.add(sublist);
            return;
        }
        for (int start = i; start < nums.length; start++) {
            swap(nums, i, start);
            permute(nums, i + 1, list);
            swap(nums, i, start);
        }

    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static List<List<Integer>> helper(int[] nums) {


        List<List<Integer>> list = new ArrayList<>();
        permute(nums, 0, list);
        return list;


    }


    // Method 2-------------->

    public static void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums) {
        if (tempList.size() == nums.length) {
            list.add(new ArrayList<>(tempList));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (tempList.contains(nums[i]))
                    continue; // element already exists, skip
                tempList.add(nums[i]);
                backtrack(list, tempList, nums);
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    // Method 2 with duplicate values...
    public static void backtrack2(List<List<Integer>> list, List<Integer> tempList, int[] nums,
            boolean[] used) {
        if (tempList.size() == nums.length) {
            list.add(new ArrayList<>(tempList));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i - 1])
                    continue;
                used[i] = true;
                tempList.add(nums[i]);
                backtrack2(list, tempList, nums, used);
                used[i] = false;
                tempList.remove(tempList.size() - 1);
            }
        }
    }


    public List<List<Integer>> helper2(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums); // sorting needed in duplicate values case
        backtrack2(list, new ArrayList<>(), nums, new boolean[nums.length]);
        return list;
    }


    public static void main(String[] args) {

        int arr[] = {1, 2, 3};
        for (List<Integer> li : helper(arr)) {

            System.out.println(li);

        }

    }
}

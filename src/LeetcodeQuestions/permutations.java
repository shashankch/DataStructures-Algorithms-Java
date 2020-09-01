package LeetcodeQuestions;

import java.util.ArrayList;
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

    public  static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static List<List<Integer>> helper(int[] nums) {


        List<List<Integer>> list = new ArrayList<>();
        permute(nums, 0, list);
        return list;


    }
    

    public static void main(String[] args) {
        
        int arr[] = {1, 2, 3};
        for (List<Integer> li : helper(arr)) {

            System.out.println(li);
            
        }

    }
}

package LeetcodeQuestions;

public class maxSubarrkadane {


    public static int helper(int[] nums) {
        int maxSub = nums[0], curSum = 0;

        for (int n : nums) {
            if (curSum < 0)
                curSum = 0;
            curSum += n;
            maxSub = Math.max(maxSub, curSum);
        }
        return maxSub;
    }



    public static void main(String[] args) {

        int arr[] = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(helper(arr));

    }

}

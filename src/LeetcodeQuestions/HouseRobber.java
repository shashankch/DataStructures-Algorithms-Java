package LeetcodeQuestions;

// https://leetcode.com/problems/house-robber/
// https://leetcode.com/problems/house-robber-ii/
public class HouseRobber {

    // linear..
    public static int houserob(int nums[]) {

        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i < nums.length + 1; i++) {
            dp[i] = Math.max(dp[i - 1], nums[i - 1] + dp[i - 2]);
        }
        return dp[nums.length];
    }


    // when houses are in circular fashion..

    public static int houserobCircular(int nums[]) {
        if (nums.length == 0)
            return 0;

        if (nums.length == 1)
            return nums[0];

        int maxExcludeFirst = helper(nums, 1, nums.length);
        int maxExcludeLast = helper(nums, 0, nums.length - 1);

        return Math.max(maxExcludeFirst, maxExcludeLast);


    }

    public static int helper(int[] nums, int start, int end) {
        int prevMax = 0;
        int currentMax = 0;

        for (int i = start; i < end; i++) {
            int newMax = Math.max(currentMax, nums[i] + prevMax);

            prevMax = currentMax;
            currentMax = newMax;
        }

        return currentMax;
    }


    public static void main(String[] args) {

    }
}

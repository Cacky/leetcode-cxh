package 动态规划.q53_最大子序和.f2;

/**
 * 动态规划 dp[i]表示以nums[i]结尾的最大子序和 o(n)
 */
public class Solution {

    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];

        int rs = dp[0];

        for (int i = 1; i < nums.length; i++) {
            int temp = dp[i - 1] + nums[i];
            dp[i] = Math.max(nums[i], temp);
            rs = Math.max(rs, dp[i]);
        }
        return rs;
    }

    public int maxSubArray2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int currentSum = nums[0];
        int maxSum = 0;
        for (int i = 1; i < nums.length; i++) {
            currentSum = currentSum > 0 ? currentSum + nums[i] : nums[i];
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxSubArray2(new int[]{-2}));
    }
}

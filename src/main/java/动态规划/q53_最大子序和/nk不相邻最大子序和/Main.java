package 动态规划.q53_最大子序和.nk不相邻最大子序和;

/**
 * 动态规划.q53_最大子序和.nk不相邻最大子序和.
 *
 * @author chengxiaohai.
 * @date 2021/4/12.
 */
public class Main {

    /**
     * 给你一个n（1≤n≤10^5），和一个长度为n的数组，在不同时选位置相邻的两个数的基础上，求该序列的最大子序列和（挑选出的子序列可以为空）。 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可 计算
     *
     * @param n int整型 数组的长度
     * @param array int整型一维数组 长度为n的数组
     * @return long长整型
     */
    public long subsequence(int n, int[] array) {
        // write code here
        if (n <= 0) {
            return 0L;
        }
        int maxSum = array[0];
        for (int i = 0; i < array.length; i++) {
            int currentSum = array[i];
            for (int j = i + 2; j < array.length; j++) {
                if (j >= array.length) {
                    break;
                } else {
                    currentSum = array[j] > 0 ? currentSum + array[j] : currentSum;
                }
            }
            maxSum = Math.max(currentSum, maxSum);
        }
        return maxSum;
    }

    /**
     * 每个位置有两个状态， 拿或者不拿
     * <p>
     * 拿当前位置时， 最大值只能从 不拿上一个位置 转移来 不拿当前位置时，最大值可以从 不拿上一个位置 和 拿上一个位置 转移
     */
    public long subsequence2(int n, int[] array) {
        // write code here
        /**
         * 其实就是一个打家劫舍的问题，数组中每一个元素值就是可以偷的金额，相邻的不能偷，求能够偷出的最大金额是多少。
         *
         * 设置一个状态转移数组dp，dp[i]表示数组中前i个元素所能偷的最大金额是多少
         *
         * 状态转移表达式：
         * (1)对于当前的元素arr[i],如果偷，那么dp[i] = dp[i-2] + arr[i]
         * (2)如果不偷，那么dp[i] = dp[i-1]
         */
        long[] dp = new long[n + 1];
        dp[0] = 0;
        dp[1] = array[0];
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + array[i - 1]);
        }

        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new Main().subsequence2(3, new int[]{-1, 2, 3}));
    }

}

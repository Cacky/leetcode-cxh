package com.theodorehai.leetcode.test.中等NC87丢棋子问题;

/**
 * com.theodorehai.leetcode.test.中等NC87丢棋子问题.
 *题目描述
 *
 * 一座大楼有0-N层，地面算作第0层，最高的一层为第N
 * 层。已知棋子从第0层掉落肯定不会摔碎，从第i层掉落可能会摔碎，也可能不会摔碎(1≤i≤N)。
 * 给定整数N作为楼层数，再给定整数K作为棋子数，返回如果想找到棋子不会摔碎的最高层数，
 * 即使在最差的情况下扔的最小次数。一次只能扔一个棋子。
 *
 * 示例1
 * 输入 10,1
 * 返回值 10
 * 说明
 * 因为只有1棵棋子，所以不得不从第1层开始一直试到第10层，在最差的情况下，即第10层是不会摔坏的最高层，最少也要扔10次
 * 示例2
 * 输入 3,2
 * 返回值  2
 * 说明
 * 先在2层扔1棵棋子，如果碎了，试第1层，如果没碎，试第3层
 * 示例3
 * 输入 105,2
 * 返回值 14
 * 说明
 * 第一个棋子先在14层扔，碎了则用仅存的一个棋子试1~13层
 * 若没碎，第一个棋子继续在27层扔，碎了则用仅存的一个棋子试15~26层
 * 若没碎，第一个棋子继续在39层扔，碎了则用仅存的一个棋子试28~38层
 * 若没碎，第一个棋子继续在50层扔，碎了则用仅存的一个棋子试40~49层
 * 若没碎，第一个棋子继续在60层扔，碎了则用仅存的一个棋子试51~59层
 * 若没碎，第一个棋子继续在69层扔，碎了则用仅存的一个棋子试61~68层
 * 若没碎，第一个棋子继续在77层扔，碎了则用仅存的一个棋子试70~76层
 * 若没碎，第一个棋子继续在84层扔，碎了则用仅存的一个棋子试78~83层
 * 若没碎，第一个棋子继续在90层扔，碎了则用仅存的一个棋子试85~89层
 * 若没碎，第一个棋子继续在95层扔，碎了则用仅存的一个棋子试91~94层
 * 若没碎，第一个棋子继续在99层扔，碎了则用仅存的一个棋子试96~98层
 * 若没碎，第一个棋子继续在102层扔，碎了则用仅存的一个棋子试100、101层
 * 若没碎，第一个棋子继续在104层扔，碎了则用仅存的一个棋子试103层
 * 若没碎，第一个棋子继续在105层扔，若到这一步还没碎，那么105便是结果
 * 备注:
 * 0≤N,K≤10^6
 *
 * @author chengxiaohai.
 * @date 2021/5/9.
 */
public class Solution {

    public int solve2 (int n, int k) {
        if(n < 1 || k <1){
            return 0;
        }
        if(k == 1) return n;
        int[][] dp = new int[n+1][k+1];
        for (int i = 1; i < dp.length; i++) {
            dp[i][1] = i;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 2; j <=k ; j++) {
                int min = Integer.MAX_VALUE;
                for (int s = 1; s < i+1; s++) {
                    min = Math.min(min,Math.max(dp[s-1][j-1],dp[i-s][j]));
                }
                dp[i][j] = min +1;
            }
        }
        return dp[n][k];
    }
    /**
     * 通过研究以上递归函数发现， P(N, K)过程依赖于P(0...N-1, K-1)
     * 和 P(0...N-1, K)。所以，若把所有的递归的返回值看作是一个二维数组，
     * 可以用动态规划的方法优化递归过程。从而减少计算量。
     * dp[0][K] = 0, dp[N][1] = N,
     * dp[N][K] = min( max(dp[i-1][K-1], dp[N-i][K])) + 1。
     */
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 返回最差情况下扔棋子的最小次数
     * @param n int整型 楼层数
     * @param k int整型 棋子数
     * @return int整型
     */
    public int solve (int n, int k) {
        // write code here
        if ( n<1 || k<1 )
            return 0;
        if ( k == 1 ) return n;
        int[][] dp = new int[n+1][k+1];
        for(int i=1; i<dp.length; ++i) {
            dp[i][1] = i;
        }
        for(int i=1; i<dp.length; ++i) {
            for(int j=2; j<=k; ++j) {
                int min = Integer.MAX_VALUE;
                for(int s=1; s<i+1; ++s) {
                    min = Math.min(min, Math.max(dp[s-1][j-1], dp[i-s][j]));
                }
                dp[i][j] = min + 1;
            }
        }
        return dp[n][k];
    }

    /**
     *  分析动态规划的过程发现，dp[N][K]只需要它左边的数据dp[0...N-1][K-1]
     *  和它上面一排的数据dp[0...N-1][K]。
     *  那么在动态规划计算时，就可以用两个数组不停复用的方式实现，
     *  而不需要申请整个二维数组的空间。
     * @param N
     * @param K
     * @return
     */
    public int solutionThree(int N, int K){
        if ( N<1 || K<1 )
            return 0;
        if ( K == 1 ) return N;
        int[] preArr = new int[N+1];
        int[] curArr = new int[N+1];
        for(int i=1; i<curArr.length; ++i) {
            curArr[i] = i;
        }
        for(int i=1; i<K; ++i) {
            int[] tmp = preArr;
            preArr = curArr;
            curArr = tmp;
            for(int j=1; j<curArr.length; ++j){
                int min = Integer.MAX_VALUE;
                for(int k=1; k<j+1; ++k) {
                    min = Math.min(min,  Math.max(preArr[k-1], curArr[j-k]));
                }
                curArr[j] = min + 1;
            }
        }
        return curArr[curArr.length-1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solve(105, 2));
        System.out.println(solution.solve2(105, 2));
    }
}

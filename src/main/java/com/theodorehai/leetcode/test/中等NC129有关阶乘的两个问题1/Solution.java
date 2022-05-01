package com.theodorehai.leetcode.test.中等NC129有关阶乘的两个问题1;

/**
 * com.theodorehai.leetcode.test.中等NC129有关阶乘的两个问题1.
 *题目描述
 * 给定一个非负整数 N，返回N! 结果的末尾为 0 的数量。
 * N! 是指自然数 N 的阶乘,即:N!=1*2*3…(N-2)*(N-1)*N。
 *
 * 示例1
 * 输入3
 * 返回值 0
 * 说明
 * 3!=6
 * 示例2
 * 输入 5
 * 返回值 1
 * 说明
 * 5!=120
 * 示例3
 * 输入  1000000000
 * 返回值 249999998
 * 备注:
 * 1≤N≤10^18
 * @author chengxiaohai.
 * @date 2021/5/9.
 */
import java.util.*;


public class Solution {
    /**
     * 观察一下10以内的数字互相乘，会发现，只有
     * 2×5 = 10
     * 4×5 = 20
     * 6×5 = 30
     * 8×5 = 40
     * 相乘会产生0，而且 4×5 = (2×5)×2，6×5 = (2×5)×3...
     * 所以我们只需要看一下 n 以内 能拆出多少对 2×5
     * 然后我们可以发现，有5因子的数比有2因子的数要少，所以我们就看能拆出来多少5就可以了，因为肯定能有足够数量的因子2来匹配。
     * 25!=1×2×3×4×5×6×7×8×9×10×11×12×13×14×15×16×17×18×19×20×21×22×23×24×25
     * =1×2×3×4×5×6×7×8×9×(2×5)×11×12×13×14×(3×5)×16×17×18×19×(4×5)×21×22×23×24×(5×5)
     * 所以阶乘末尾0的数量就是 1∼n 中能拆出来的5的数量。但是，从 1 遍历到 n 每个数看一下它能除多少次 5 是不行的。
     * 因为 n 的数据范围是1e18。
     * 遍历1e18个数复杂度太大了。
     * 那我们来考虑一下，5的倍数可以至少产生1个5，25的倍数可以产生至少2个5，125的倍数可以产生至少3个5...
     * 这样的话1∼n 中有n/5个5的倍数，n/25个25的倍数，n/125个125的倍数...
     *
     * 所以答案就是 n/5+n/25..
     * the number of 0
     * @param n long长整型 the number
     * @return long长整型
     */
    public long thenumberof0 (long n) {
        // write code here
        long ans = 0;
        long d = 5;
        while(n>=d) {
            ans+=n/d;
            d = d*5;
        }
        return ans;
    }
    public long thenumberof1 (long n) {
       long res = 0;
       long d = 5;
       while (n>=d){
           res += n/d;
           d = d *5;
       }
       return res;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.thenumberof0(100));
        System.out.println(solution.thenumberof1(100));
    }
}

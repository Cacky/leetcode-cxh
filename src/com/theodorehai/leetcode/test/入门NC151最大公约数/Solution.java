package com.theodorehai.leetcode.test.入门NC151最大公约数;

/**
 * com.theodorehai.leetcode.test.入门NC151最大公约数.
 *题目描述
 * 求出两个数的最大公约数，
 * 如果有一个自然数a能被自然数b整除，则称a为b的倍数，b为a的约数。
 * 几个自然数公有的约数，叫做这几个自然数的公约数。
 * 公约数中最大的一个公约数，称为这几个自然数的最大公约数。
 * 示例1
 * 输入 3,6
 * 返回值 3
 * 示例2
 * 输入 8,12
 * 返回值 4
 * 备注: a和b的范围是[1-109]
 * @author chengxiaohai.
 * @date 2021/5/8.
 */
import java.util.*;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 求出a、b的最大公约数。
     * @param a int
     * @param b int
     * @return int
     */
    public int gcd (int a, int b) {
        // write code here
        //辗转相除法
//         int result = 0;
//         while(b != 0){
//             result = a % b;
//             a = b;
//             b = result;
//         }
//         return result;
        //更相减损术
        if (a % b == 0 || b % a == 0){
            return a % b == 0 ? b : a;
        }
        while(a != b){
            if(a > b)
                a -= b;
            else
                b -= a;
        }
        return a;
    }

    /**
     * 我们用辗转相除法（又称欧几里得算法）来计算两个数的最大公约数 (Greatest Common Divisor)
     * 所以下文用gcd(a,b)表示a和b的最大公约数。
     *
     * 先举一个例子：
     * 假如需要求 434 和 652 的最大公约数,用欧几里得算法，是这样进行的：
     * 434 / 652 = 0 (余 434)
     * 652 / 434 = 1(余218)
     * 434 / 218 = 216(余2)
     * 216 / 2 = 108 (余0)
     * 以除数和余数反复做除法运算，当余数为 0 时，取当前算式除数为最大公约数，所以就得出了 434 和 652 的最大公约数 2。
     * 算法的核心其实是 ：gcd(a,b)=gcd(b,a mod b) （即：a 和 b 的最大公约数等于 a 和 a%b 的最大公约数。
     * 这个性质在本文最后会给出证明）
     * 然后我们考虑，对于两个数 a ，b 如果a%b==0的话,那这两个数的最大公约数是b
     * 这样的话代码我们就可以直接写出来了。
     */
    public int gcd2 (int a, int b) {
        // write code here
        int c = a%b;
        if (c == 0) {
            return b;
        }
        return gcd2(b,c);
    }
    public static int gcd3(int a,int b){
        int c = a %b;
        if(c ==0) return b;
        return gcd3(b,c);
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.gcd(15, 3));
        System.out.println(solution.gcd2(15, 3));
        System.out.println(gcd3(15, 3));
    }
}

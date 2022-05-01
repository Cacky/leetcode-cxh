package com.theodorehai.leetcode.test.较难NC100将字符串转化为整数;

/**
 * com.theodorehai.leetcode.test.较难NC100将字符串转化为整数.
 *题目描述
 * 实现函数 atoi 。函数的功能为将字符串转化为整数
 * 提示：仔细思考所有可能的输入情况。这个问题没有给出输入的限制，你需要自己考虑所有可能的情况。

 * 示例1
 * 输入 "123"
 * 返回值  123
 * @author chengxiaohai.
 * @date 2021/4/27.
 */
public class Solution {
    /**
     * 1. 处理空字符串
     * 2. 忽略前置空格
     * 3. 保存符号
     * 4. 处理非法输入
     * 5. 处理溢出
     * @param str string字符串
     * @return int整型
     */
    public int atoi (String str) {
        // write code here
        int idx = 0, sign = 1, val = 0;
        // 1. 空字符串
        if (str == null || str.trim().length() == 0) return 0;
        // 2. 忽略前置空格
        while (str.charAt(idx) == ' ') ++idx;
        // 3. 记录符号
        if (str.charAt(idx) == '-') {sign = -1; ++idx;}
        if (str.charAt(idx) == '+') {++idx;}
        for (; idx < str.length(); ++idx) {
            // 4. 处理非法值
            if (str.charAt(idx) < '0' || str.charAt(idx) > '9') break;
            // 5. 处理溢出
            if (val > Integer.MAX_VALUE / 10
                || (val == Integer.MAX_VALUE / 10 && Integer.MAX_VALUE % 10 < str.charAt(idx) - '0')) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            val = val * 10 + str.charAt(idx) - '0';
        }
        return val * sign;
    }

    public static int atoi2(String str){
        int index = 0,sign = 1,val = 0;
        //1.空字符串
        if(str == null || str.trim().length() ==0) return 0;
        //2. 忽略前置空格
        while (str.charAt(index) ==' ')  index++;
        //3. 记录符号
        if(str.charAt(index) == '-'){
            sign = -1;
            index++;
        }
        if(str.charAt(index) == '+'){
            index++;
        }
        for (; index < str.length(); index++) {
            //4. 处理非法值
            if(str.charAt(index) <'0' || str.charAt(index)>'9') break;
            //5. 处理溢出
            if(val > Integer.MAX_VALUE/10
                || val == Integer.MAX_VALUE/10 &&(Integer.MAX_VALUE %10 < str.charAt(index)-'0')){
                return sign ==1?Integer.MAX_VALUE:Integer.MIN_VALUE;
            }
            val = val*10 + str.charAt(index)-'0';
        }
        return val * sign;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.atoi("+002147483647"));
        System.out.println(solution.atoi("   -42"));
        System.out.println(solution.atoi("4193 with words"));
        System.out.println(solution.atoi("words and 987"));
        System.out.println(solution.atoi(" "));
        System.out.println(solution.atoi("-912834723"));
        System.out.println(solution.atoi("10000000000000000000000000000000000000000000000000000000000000000522545459"));
        System.out.println(solution.atoi("00000000000000000000000000000000000000000000000000000000000000000522545459"));
        System.out.println(atoi2("-912834723"));
    }
}

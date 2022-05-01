package com.theodorehai.leetcode.test.简单NC156数组中只出现一次的数其它数出现k次;

/**
 * com.theodorehai.leetcode.test.简单NC156数组中只出现一次的数其它数出现k次.
 *题目描述
 * 给定一个整型数组 arr 和一个整数 k(k>1)。
 * 已知 arr 中只有 1 个数出现一次，其他的数都出现 k 次。
 * 请返回只出现了 1 次的数。
 * 示例1
 * 输入 [5,4,1,1,5,1,5],3
 * 返回值 4
 * @author chengxiaohai.
 * @date 2021/5/7.
 */
import java.util.*;
import java.util.Map.Entry;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param arr int一维数组
     * @param k int
     * @return int
     */
    //解法1：排序
    public int foundOnceNumber(int[] arr, int k) {
        Arrays.sort(arr);
        for(int i = 0; i<arr.length-1; i++){
            if(arr[i]==arr[i+1]){
                i += k-1;
            }else{
                return arr[i];
            }

        }
        return arr[arr.length-1];
    }

    /**
     * 解法2：位运算
     * 出现k次就不能再用异或的方法了，因为k(奇数)个相同的数异或还是得到本身。
     * 但是还是可以采用位运算的思想，因为出现k(奇数)次的数字每个位（0或者1）也是出现k(奇数)次，
     * 因此可以每一位的和能够被k整除（对k取余为0）。所以如果把每个数的二进制表示的每一位加起来，对于每一位的和，
     * 如果能被k整除，那对应那个只出现一次的数字的那一位就是0，否则对应的那一位是1。
     *
     * 我们需要用一个长度为32（int型二进制表示最多为32位，4字节）的数组bitSum保存每一位的和
     * 具体来讲实现过程是，先初始化为0，然后对于每个数字，遍历它二进制表示的每一位，如果这一位是1，bitSum对应的那一位就加1。
     * @param arr
     * @param k
     * @return
     */
    public int foundOnceNumber1 (int[] arr, int k) {
        // 每个二进制位求和，如果某个二进制位不能被k整除，那么只出现一次的那个数字在这个二进制位上为1。
        int[] binarySum = new int[32];
        for(int i = 0; i< 32; i++){//求每个二进制位的和
            int sum = 0;
            for(int num : arr){
                sum += (num >>i & 1);//依次右移num，同1相与，计算每一位上1的个数
            }
            binarySum[i] = sum;
        }
        int res = 0;
        for (int i = 0; i< 32; i++){
            if(binarySum[i]%k!=0){
                res += 1<<i;//左移恢复
            }
        }
        return res;
    }

    //解法3：HashMap
    public int foundOnceNumber2 (int[] arr, int k) {
        // write code here
        HashMap<Integer, Boolean> map = new HashMap<>();//key存数字，value表示是否出现过
        for(int num: arr){
            if(map.containsKey(num)){
                map.put(num, true);
            }else{
                map.put(num, false);
            }
        }
        Set<Integer> set = map.keySet();
        for(int num : set){
            if(map.get(num) == false){
                return num;
            }
        }
        return 0;
    }

    public int foundOnceNumber3 (int[] arr, int k) {
        // write code here
        HashMap<Integer, Integer> map = new HashMap<>();//key存数字，value表示是否出现过
        for(int num: arr){
            if(map.containsKey(num)){
                map.put(num, map.get(num)+1);
            }else{
                map.put(num, 1);
            }
        }
        Set<Integer> set = map.keySet();
        for(int num : set){
            if(map.get(num) == 1){
                return num;
            }
        }
        return 0;
    }
    public static int foundOnceNumber4 (int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if(map.containsKey(arr[i])){
                map.put(arr[i],map.get(arr[i])+1);
            }else{
                map.put(arr[i],1);
            }
        }
        for (Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue() == 1){
                return entry.getKey();
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] data = new int[]{5,4,1,1,5,1,5};
        System.out.println(solution.foundOnceNumber3(data, 3));
        System.out.println(foundOnceNumber4(data, 3));
    }

}

package com.theodorehai.leetcode.test.简单NC90设计getMin功能的栈;

/**
 * com.theodorehai.leetcode.test.简单NC90设计getMin功能的栈.
 *题目描述
 * 实现一个特殊功能的栈，在实现栈的基本功能的基础上，再实现返回栈中最小元素的操作。
 * 示例1
 * 输入 [[1,3],[1,2],[1,1],[3],[2],[3]]
 * 返回值 [1,2]
 * 备注:
 * 有三种操作种类，op1表示push，op2表示pop，op3表示getMin。
 * 你需要返回和op3出现次数一样多的数组，表示每次getMin的答案
 *
 * 1<=操作总数<=1000000
 * -1000000<=每个操作数<=1000000
 * 数据保证没有不合法的操作
 * @author chengxiaohai.
 * @date 2021/4/30.
 */
import java.util.*;


public class Solution {
    /**
     * 题目意思：[1,x]表示入栈x     [2]表示出栈     [3]表示getmin
     * 解答：建立一个堆栈min和一个动态数组队列sz,堆栈中每当压入的数大于栈顶的数，
     * 保留这个数，否则将栈顶数复制，
     * （这样保证了堆栈顶一直存放的是最小数，而且不会将之前的数的个数改变，
     * 因此当pop时，能够保证之前的最小数）
     * return a array which include all ans for op3
     * @param op int整型二维数组 operator
     * @return int整型一维数组
     */
    public int[] getMinStack (int[][] op) {
        // write code here
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0;i<op.length;i++){
            if (op[i][0] == 1){ // 入栈
                list.add(op[i][1]);
            }else if (op[i][0] == 2){
                list.remove(list.size()-1);
            }else if (op[i][0] == 3)
                res.add(getMin(list));
        }
        return res.stream().mapToInt(Integer::valueOf).toArray();
    }
    public int getMin(ArrayList<Integer> list){
        int min = Integer.MAX_VALUE;
        for (int val : list){
            if (min > val)
                min = val;
        }
        return min;
    }

    public int[] getMinStack2 (int[][] op) {
        Stack<Integer> stack = new Stack<>();
        stack.push(Integer.MAX_VALUE);
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < op.length; i++) {
            if(op[i][0] == 1){
                stack.push(Math.min(op[i][1],stack.peek()));
            }else if(op[i][0] == 2){
                stack.pop();
            }else{
                res.add(stack.peek());
            }
        }
        return res.stream().mapToInt(Integer::valueOf).toArray();
    }

    public int[] getMinStack3 (int[][] op) {
        // write code here
        ArrayList<Integer> list = new ArrayList<>();
        Stack<Integer> minStack = new Stack<>();
        minStack.push(Integer.MAX_VALUE);
        Stack<Integer> stack = new Stack<>();
        for (int[] arr : op) {
            if (arr.length == 2) {
                minStack.push(Math.min(minStack.peek(), arr[1]));
                stack.push(arr[1]);
            } else {
                if (arr[0] == 2) {
                    minStack.pop();
                    stack.pop();
                } else {
                    list.add(minStack.peek());
                }
            }
        }
        return list.stream().mapToInt(Integer::valueOf).toArray();
    }

    public static void main(String[] args) {
        int[][] data = {{1,2},{1,1},{1,3},{3},{2},{3}};
        Solution solution = new Solution();
        solution.myPrint(solution.getMinStack(data));
        solution.myPrint(solution.getMinStack2(data));
        solution.myPrint(solution.getMinStack3(data));
    }

    private void myPrint(int[] data){
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i]+" ");
        }
        System.out.println();
    }
}

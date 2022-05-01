package 双指针遍历.q42_接雨水;

import java.util.Stack;

/**
 * 暴力法o(n^2) 找出每个元素（柱子）上面的水量，可提前存储最大高度数组（两个左和右），最后遍历一次优化为o(n)
 *
 * https://blog.csdn.net/qq_41231926/article/details/82682179
 */
public class Solution {

    //暴力解法
    public int trap2(int[] height) {
        int ans = 0;
        int size = height.length;
        for (int i = 1; i < size - 1; i++) {
            int maxLeft = 0, maxRight = 0;
            for (int j = i; j >= 0; j--) {
                maxLeft = Math.max(maxLeft, height[j]);
            }
            for (int j = i; j < size; j++) {
                maxRight = Math.max(maxRight, height[j]);
            }
            ans += Math.min(maxLeft, maxRight) - height[i];
        }
        return ans;
    }

    //利用栈对思路一进行改进
    public int trap(int[] height) {
        int n = height.length;
        int result = 0;
        if(n == 0 || n == 1) {
            return result;
        }
        int cur = 0;
        Stack<Integer> stack = new Stack<Integer>();
        while(cur < n) {
            while(!stack.isEmpty() && height[cur] > height[stack.peek()]){
                int top = stack.pop();
                if(stack.isEmpty()){
                    break;
                }
                //distance represents the width
                int distance = cur - stack.peek() - 1;
                //tempHeight represents the height
                int tempHeight = Math.min(height[cur], height[stack.peek()]) - height[top];
                result += tempHeight  * distance;
            }
            stack.push(cur);
            cur++;
        }
        return result;
    }

    //双指针夹逼寻找雨水数
    public int trap3(int[] height) {
        int n = height.length;
        int result = 0;
        if(n == 0 || n == 1) {
            return result;
        }
        int left = 0;
        int right = n - 1;
        int leftHeight = 0;
        int rightHeight = 0;
        while(left < right) {
            if(height[left] <= height[right]) {
                leftHeight = Math.max(leftHeight, height[left]);
                result += leftHeight - height[left];
                left++;
            }else {
                rightHeight = Math.max(rightHeight, height[right]);
                result += rightHeight - height[right];
                right--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] data = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(new Solution().trap(data));
        System.out.println(new Solution().trap2(data));
        System.out.println(new Solution().trap3(data));
    }
}

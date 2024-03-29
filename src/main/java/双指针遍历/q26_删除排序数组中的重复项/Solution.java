package 双指针遍历.q26_删除排序数组中的重复项;

/**
 * 双指针 o(n)
 * https://zhuanlan.zhihu.com/p/41373837
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        int c = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[c]) {
                c++;
                nums[c] = nums[i];
            }
        }
        return c + 1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().removeDuplicates(new int[]{1, 1, 2,3,4,4}));
    }
}

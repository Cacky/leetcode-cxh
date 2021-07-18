package 双指针遍历.q3_无重复字符的最长子串;

import java.util.HashMap;
import java.util.Map;

/**
 * https://www.cnblogs.com/ariel-dreamland/p/8668286.html
 * Hash+双指针滑动窗口 o(n) 给定 "abcabcbb" ，没有重复字符的最长子串是 "abc" ，那么长度就是3。
 * <p>
 * 给定 "bbbbb" ，最长的子串就是 "b" ，长度是1。
 * <p>
 * 给定 "pwwkew" ，最长子串是 "wke" ，长度是3。请注意答案必须是一个子串，"pwke" 是 子序列 而不是子串
 */
public class Solution {

    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int len = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        while (right < s.length()) {
            Integer index = map.get(s.charAt(right));
            map.put(s.charAt(right), right);
            if (index != null && index >= left) {
                left = index + 1;
            }
            if (right - left + 1 > len) {
                len = right - left + 1;
            }
            right++;
        }
        return len;
    }

    public int lengthOfLongestSubstring2(String s) {
        int ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < s.length(); j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }
}

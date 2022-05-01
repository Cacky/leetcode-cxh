package 字符串操作.q763_划分字母区间;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (贪心算法）
 * 先存储每个字母最后出现的位置，最后遍历一次 o(n)
 */
public class Solution {

    public List<Integer> partitionLabels(String S) {
        int[] last = new int[26];
        for (int i = 0; i < S.length(); ++i) {
            last[S.charAt(i) - 'a'] = i;
        }
        int j = 0, anchor = 0;
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < S.length(); ++i) {
            j = Math.max(j, last[S.charAt(i) - 'a']);
            if (i == j) {
                ans.add(i - anchor + 1);
                anchor = i + 1;
            }
        }
        return ans;
    }

    public static List<Integer> partitionLabels2(String S) {

        // 键：字符，值：下标
        Map<Character, Integer> map = new HashMap<>();
        
        // 第一遍循环，记录每一个字符最后出现的位置
        for (int i = 0; i < S.length(); i++) {
            map.put(S.charAt(i), i);
        }

        int last = -1; // 最后一次出现的位置
        int anchor = 0;

        // 第二遍循环
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < S.length(); i++) {
            last = Math.max(last, map.get(S.charAt(i)));
            if (i == last) {
                list.add(i - anchor + 1);
                anchor = i + 1;
            }
            // // 表示当前字符仅仅出现了一次
            // if (map.get(c) == j && j > last) {
            //     list.add(1);
            //     begin = j + 1;  // caedbdedda
            // }
            // // 表示当前字符最后出现位置，在前面字符最后出现的位置之前
            // else if (map.get(c) < last) {
            //     continue;
            // } else if (j == last) {
            //     list.add(j - begin + 1); // 增加一个片段
            //     begin = last + 1; // 这里要注意
            // } else {
            //     last = map.get(c);
            // }
        }
        return list;
    }

    public static void main(String[] args) {
        List<Integer> result = new Solution().partitionLabels2("azbccaddbeffeg");
        System.out.println(result);
    }
}

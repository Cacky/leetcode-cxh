package com.theodorehai.leetcode.test.中等NC97字符串出现次数的TopK问题;

/**
 * com.theodorehai.leetcode.test.中等NC97字符串出现次数的TopK问题.
 * 题目描述 给定一个字符串数组，再给定整数k，请返回出现次数前k名的字符串和对应的次数。
 * 返回的答案应该按字符串出现频率由高到低排序。如果不同的字符串有相同出现频率，按字典序排序。 对于两个字符串，
 * 大小关系取决于两个字符串从左到右第一个不同字符的 ASCII 值的大小关系。
 * 比如"ah1x"小于"ahb"，"231"<”32“ 字符仅包含数字和字母
 * <p>
 * [要求] 如果字符串数组长度为N，时间复杂度请达到O(NlogK)
 * <p>
 * 示例1 输入 ["a","b","c","b"],2
 * 返回值  [["b","2"],["a","1"]]
 * 说明 "b"出现了2次，记["b","2"]，"a"与"c"各出现1次，但是a字典序在c前面，记["a","1"]，最后返回[["b","2"],["a","1"]]
 * <p>
 * 示例2 输入 ["123","123","231","32"],2
 * 返回值  [["123","2"],["231","1"]]
 * 说明 "123"出现了2次，记["123","2"]，"231"与"32"各出现1次，但是"231"字典序在"32"前面，
 * 记["231","1"]，最后返回[["123","2"],["231","1"]]
 * 示例3
 * 输入  ["abcd","abcd","abcd","pwb2","abcd","pwb2","p12"],3
 * 返回值 [["abcd","4"],["pwb2","2"],["p12","1"]]
 * 备注: 1≤N≤10^5
 *
 * @author chengxiaohai.
 * @date 2021/5/7.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;


public class Solution {

    /**
     * return topK string
     * @param strings string字符串一维数组 strings
     * @param k int整型 the k
     * @return string字符串二维数组
     */
    // 使用自定义的比较器实现
    public String[][] topKstrings(String[] strings, int k) {
        // write code here
        if (k == 0) {
            return new String[][]{};
        }
        String[][] res = new String[k][2];
        TreeMap<String, Integer> tmap = new TreeMap<>();
        for (int i = 0; i < strings.length; i++) {
            String s = strings[i];
            if (!tmap.containsKey(s)) {
                tmap.put(s, 1);
            } else {
                tmap.put(s, tmap.get(s) + 1);
            }
        }
        // 先比较值是否相同，相同按键升序进行比较，不相同按值降序比较
        ArrayList<Map.Entry<String, Integer>> list = new ArrayList<>(tmap.entrySet());
        Collections.sort(list,
            (o1, o2) -> (o1.getValue().compareTo(o2.getValue()) == 0 ?
                o1.getKey().compareTo(o2.getKey())
                : o2.getValue().compareTo(o1.getValue()))
        );
        for (int i = 0; i < k; i++) {
            res[i][0] = list.get(i).getKey();
            res[i][1] = String.valueOf(list.get(i).getValue());
        }
        return res;
    }

    //统计各个字符出现次数，使用Map
    // 创建初始堆(大顶堆)，定义出现次数大的字符串较大，出现次数相同是自然序较前的串较大
    // 依次去K个堆顶元素并调整堆
    public String[][] topKstrings2(String[] strings, int k) {
        if (null == strings || strings.length == 0) {
            return new String[0][];
        }

        String[][] result = new String[k][];
        // 统计各个字符串出现次数
        Map<String, Integer> cntMap = new HashMap();
        for (String s : strings) {
            cntMap.put(s, cntMap.getOrDefault(s, 0) + 1);
        }

        // 创建初始堆 大顶堆
        Node[] heapArr = new Node[cntMap.size() + 1];
        int idx = 0;
        for (Map.Entry<String, Integer> entry : cntMap.entrySet()) {
            Node node = this.new Node(entry.getKey(), entry.getValue());
            heapArr[++idx] = node;
        }
        // 调整初始堆
        for (int i = idx / 2; i > 0; --i) {
            shift(heapArr, i, heapArr.length);
        }

        // 取前K个
        int limit = heapArr.length - 1;
        for (int i = 1; i <= k && i <= limit; ++i) {
            String[] r = new String[]{heapArr[1].val, String.valueOf(heapArr[1].cnt)};
            result[i - 1] = r;

            Node temp = heapArr[1];
            heapArr[1] = heapArr[limit];
            heapArr[limit] = temp;
            --limit;

            // 调整堆
            shift(heapArr, 1, limit + 1);
        }
        return result;
    }

    // 堆调整方法
    private void shift(Node[] heapArr, int startIdx, int endIdx) {
        int childIdx = 2 * startIdx;
        if (childIdx + 1 < endIdx && heapArr[childIdx + 1].compareTo(heapArr[childIdx]) > 0) {
            childIdx = childIdx + 1;
        }

        if (childIdx < endIdx && heapArr[childIdx].compareTo(heapArr[startIdx]) > 0) {
            Node temp = heapArr[childIdx];
            heapArr[childIdx] = heapArr[startIdx];
            heapArr[startIdx] = temp;
            shift(heapArr, childIdx, endIdx);
        }
    }

    // 堆结点定义
    class Node implements Comparable<Node> {

        String val;
        int cnt;

        Node() {
        }

        Node(String val, int cnt) {
            this.val = val;
            this.cnt = cnt;
        }

        //定义比较方法: cnt 大的大， cnt相同时，val自然序小的大
        public int compareTo(Node node) {
            if (this.cnt != node.cnt) {
                return this.cnt - node.cnt;
            } else {
                return -this.val.compareTo(node.val);
            }
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] data = {"123", "123", "231", "32"};
        String[][] topKstrings = solution.topKstrings(data, 2);
        for (int i = 0; i < topKstrings.length; i++) {
            System.out.println(topKstrings[i][0] + " " + topKstrings[i][1]);
        }
    }
}

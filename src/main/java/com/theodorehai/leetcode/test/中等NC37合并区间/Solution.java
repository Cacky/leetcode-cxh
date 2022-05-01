package com.theodorehai.leetcode.test.中等NC37合并区间;

import java.util.ArrayList;
import java.util.Collections;

/**
 * com.theodorehai.leetcode.test.中等NC37合并区间. 题目描述 给出一组区间，请合并所有重叠的区间。 请保证合并后的区间按区间起点升序排列。 示例1 输入
 * [[10,30],[20,60],[80,100],[150,180]] 返回值  [[10,60],[80,100],[150,180]]
 *
 * @author chengxiaohai.
 * @date 2021/4/27.
 */

// Definition for an interval.
class Interval {

    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }
}

public class Solution {

    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        ArrayList<Interval> res = new ArrayList<>();
        int i =0;
        while (i <intervals.size() -1){
            int left = intervals.get(i).start;
            int right = intervals.get(i).end;
            while (i<intervals.size() -1 && intervals.get(i+1).start < right){
                right = Math.max(intervals.get(i+1).end,right);
                i++;
            }
            res.add(new Interval(left,right));
            i++;
        }
        if(i == intervals.size() -1){
            res.add(intervals.get(i));
        }

        return res;
    }

    public ArrayList<Interval> merge2(ArrayList<Interval> intervals) {
        ArrayList<Interval> res = new ArrayList<>();
        //1.先将Interval数组按照start、end从小到大进行排序；
        Collections.sort(intervals, (o1, o2) -> o1.start != o2.start ? o1.start - o2.start : o1.end - o2.end);
        // 2.设置指针i，从头遍历到intervals.size() - 1，
        int i = 0;
        while (i < intervals.size() - 1) {
            int left = intervals.get(i).start;
            int right = intervals.get(i).end;
            //当intervals.get(i).end >=intervals.get(i+1).start时候，
            // 将这两个元素进行合并，然后更新最大的end，以便接下来继续遍历比较
            while (i < intervals.size() - 1 && intervals.get(i + 1).start <= right) {
                right = Math.max(right, intervals.get(i + 1).end);
                i++;
            }
            res.add(new Interval(left, right));
            i++;
        }
        //3.如果结束循环的时候，i == intervals.size() -1，那么需要将intervals.get(i)加入到结果集合中。
        if (i == intervals.size() - 1) {
            res.add(intervals.get(i));
        }
        return res;
    }

    public static void main(String[] args) {
        ArrayList<Interval> intervals = new ArrayList<>();
        //[[10,30],[20,60],[80,100],[150,180]]
        Interval interval1 = new Interval(10, 30);
        Interval interval2 = new Interval(20, 60);
        Interval interval3 = new Interval(80, 100);
        Interval interval4 = new Interval(150, 180);
        intervals.add(interval1);
        intervals.add(interval2);
        intervals.add(interval3);
        intervals.add(interval4);
        ArrayList<Interval> res = new Solution().merge(intervals);
        res.forEach(r -> System.out.println(r.start + " " + r.end));
    }
}

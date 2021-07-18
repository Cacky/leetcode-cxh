package com.theodorehai.leetcode.test.较难NC94LFU缓存结构设计;

/**
 * com.theodorehai.leetcode.test.较难NC94LFU缓存结构设计.
 *题目描述
 * 一个缓存结构需要实现如下功能。
 * set(key, value)：将记录(key, value)插入该结构
 * get(key)：返回key对应的value值
 * 但是缓存结构中最多放K条记录，如果新的第K+1条记录要加入，就需要根据策略删掉一条记录，然后才能把新记录加入。这个策略为：在缓存结构的K条记录中，哪一个key从进入缓存结构的时刻开始，被调用set或者get的次数最少，就删掉这个key的记录；
 * 如果调用次数最少的key有多个，上次调用发生最早的key被删除
 * 这就是LFU缓存替换算法。实现这个结构，K作为参数给出
 * [要求]
 * set和get方法的时间复杂度为O(1)
 *
 * 若opt=1，接下来两个整数x, y，表示set(x, y)
 * 若opt=2，接下来一个整数x，表示get(x)，若x未出现过或已被移除，则返回-1
 *
 * 对于每个操作2，输出一个答案
 * 示例1
 * 输入
 * 复制
 * [[1,1,1],[1,2,2],[1,3,2],[1,2,4],[1,3,5],[2,2],[1,4,4],[2,1]],3
 * 返回值
 * 复制
 * [4,-1]
 * 说明
 * 在执行"1 2 4"后，"1 1 1"被删除。因此第二次询问的答案为-1
 * 备注:
 * 1 \leq k \leq n \leq 10^51≤k≤n≤10
 * 5
 *
 * -2 \times 10^9 \leq x,y \leq 2 \times 10^9−2×10
 * 9
 *  ≤x,y≤2×10
 * 9
 * @author chengxiaohai.
 * @date 2021/4/20.
 */
import java.util.*;


public class Solution {
    /**
     * lfu design
     * @param operators int整型二维数组 ops
     * @param k int整型 the k
     * @return int整型一维数组
     */
    public int[] LFU (int[][] operators, int k) {
        // write code here
        return null;
    }
}

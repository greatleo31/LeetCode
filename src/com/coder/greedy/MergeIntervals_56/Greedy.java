package com.coder.greedy.MergeIntervals_56;

import java.util.Arrays;
import java.util.LinkedList;

public class Greedy {
    public int[][] merge(int[][] intervals) {
        // 贪心算法：局部最优解可以得到整体最优解

        /*
         * 简单思路：
         * 1.先将一维数组按第一个数字从小到大排列。
         * 2.在一个个循环根据两种情况判断执行
         */

        // 定义链表:方便添加和删除
        LinkedList<int[]> res = new LinkedList<>();
        // 排序
        Arrays.sort(intervals, (x, y) -> Integer.compare(x[0], y[0]));
        // 初始化链表
        res.add(intervals[0]);
        // 循环判断
        for (int i = 1; i < intervals.length; i++) {
            int[] last = res.getLast();
            // 若能够合并
            if (intervals[i][0] <= last[1]) {
                // 合并区间: 只需更新当前区间的右边界
                last[1] = Math.max(last[1], intervals[i][1]);
            } else {
                // 若区间独立
                res.add(intervals[i]);
            }
        }
        return res.toArray(new int[res.size()][2]);
    }
}
package com.coder.array.SquaresOfSortedArray_977;

public class Better {
    public int[] sortedSquares(int[] nums) {
        // 双指针思路解题

        // 先定义两个头尾指针
        int first = 0;
        int last = nums.length - 1;

        // 创建新数组
        int[] num = new int[nums.length];
        int k = nums.length - 1;
        // 循环
        while (first <= last) {
            int left = (int) Math.pow(nums[first], 2);
            int right = (int) Math.pow(nums[last], 2);
            // 条件判断
            if (left <= right) {
                num[k--] = right;
                last--;
            } else {
                num[k--] = left;
                first++;
            }
        }
        return num;
    }
}
package com.coder.BiSearch.BiSearch_704;

public class BiSearch {
    public int search(int[] nums, int target) {
        // 先初始化左右边界：[left, right]
        int left = 0;
        int right = nums.length - 1;

        // 循环判断
        while (left <= right) {
            // 获得中间值
            int middle = (left + right) / 2;
            // 优化：int middle = left + (right-left)/2;
            if (nums[middle] > target) {
                right = middle - 1;
            } else if (nums[middle] < target) {
                left = middle + 1;
            } else {
                return middle;
            }
        }
        return -1;

    }
}
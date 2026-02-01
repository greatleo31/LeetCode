package com.coder.doublePoint.MoveZero_283;

public class DoublePoint {
    public void moveZeroes(int[] nums) {
        // 双指针算法：一个指针遍历，一个指针指向目标数组

        // 初始化指针
        int object = 0;

        // 遍历
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                continue;

            nums[object++] = nums[i];
        }
        // 赋零
        for (int i = object; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
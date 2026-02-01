package com.coder.doublePoint.TrapRainWater_42;

public class DoublePoint {
    public int trap(int[] height) {
        // 双指针法优化空间复杂度为O(1)，时间复杂度为O(n)

        // 核心：在原来数组应用前后缀数组的整体思想
        // 初始化遍历
        int size = height.length;
        int preMax = height[0];
        int endMax = height[size - 1];
        int start = 0;
        int tail = size - 1;

        // 循环
        int sum = 0;
        while (start <= tail) {
            preMax = Math.max(preMax, height[start]);
            endMax = Math.max(endMax, height[tail]);
            if (preMax < endMax) {
                sum += preMax - height[start];
                start++;
            } else {
                sum += endMax - height[tail];
                tail--;
            }
        }
        return sum;
    }
}

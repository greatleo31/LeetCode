package com.coder.DP.maximum_product_subarray_152;

public class TwicePratice {
    public static void main(String[] args) {
        int[] nums = new int[] { 2, 3, -2, 4 };
        System.out.println(maxProduct(nums));
    }

    // 时间复杂度：O(n)，空间复杂度：O(n)
    // 本题目为子数组和相邻不相关
    // 分三种情况，1.前i-1乘积为正数*nums[i]，2.前i-1乘积为负数*nums[i]，3.nums[i]单独作为下一个子数组开头
    public static int maxProduct(int[] nums) {
        int min = nums[0], max = nums[0], result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // max会变化所以需要中间变量
            int temp = max;
            // 第一种情况前i-1为正数
            max = Math.max(Math.max(min * nums[i], nums[i] * max), nums[i]);
            // 第二种情况前i-1为负数
            min = Math.min(Math.min(temp * nums[i], min * nums[i]), nums[i]);
            result = Math.max(result, max);
        }
        return result;
    }
}

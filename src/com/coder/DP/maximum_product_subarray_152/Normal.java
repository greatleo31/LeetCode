package com.coder.DP.maximum_product_subarray_152;

public class Normal {

    public static void main(String[] args) {
        int[] nums = new int[] { 2, 3, -2, 4 };
        System.out.println(maxProduct(nums));
    }

    // 时间复杂度：O(n)，空间复杂度：O(n)
    // 区分子数组=连续，子序列=不连续，不连续对比连续多了一种情况就是可以选择不从上一个取，本题是子数组并且是相邻不相关
    // 核心：选or不选即可，第一种是前i-1乘积为正数*nums[i]，第二种是前i-1乘积为负数*nums[i]，第三种是
    // 正负数根据最小值和最大值
    // nums[i]单独作为下一个子数组开头
    public static int maxProduct(int[] nums) {
        int max = nums[0], min = nums[0], result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int temp = max;
            max = Math.max(Math.max(max * nums[i], min * nums[i]), nums[i]);
            min = Math.min(Math.min(temp * nums[i], min * nums[i]), nums[i]);
            result = Math.max(result, max);
        }
        return result;
    }
}
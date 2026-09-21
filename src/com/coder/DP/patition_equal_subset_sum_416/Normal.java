package com.coder.DP.patition_equal_subset_sum_416;

import java.util.Arrays;

public class Normal {
    public static void main(String[] args) {
        int[] nums = new int[] { 1, 5, 11, 5 };
        System.out.println(canPartition(nums));
    }

    // 识别：相邻不相关并子序列，采用选or不选
    // 核心：选取数字组成的子序列何为 sum/2即可
    public static boolean canPartition(int[] nums) {
        int sumAll = 0;
        for (int i = 0; i < nums.length; i++) {
            sumAll += nums[i];
        }
        if (sumAll % 2 != 0) {
            return false;
        }
        int target = sumAll / 2;
        int[][] memo = new int[nums.length][target + 1];
        for (int i = 0; i < nums.length; i++) {
            Arrays.fill(memo[i], -1);
        }
        return dfs(nums.length - 1, nums, target, memo) == 1;
    }

    // 记忆化搜索
    // 递推：dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i]] (j>nums[i])
    // dp[i][j] = dp[i-1][j] (j<nums[i])
    private static int dfs(int index, int[] nums, int target, int[][] memo) {
        // 递归边界
        if (index < 0) {
            return target == 0 ? 1 : 0;
        }
        // 记忆化
        if (memo[index][target] != -1) {
            return memo[index][target];
        }
        // 分target<nums[i] 和target>=nums[i]
        boolean res;
        if (target >= nums[index]) {
            // 选or不选
            res = (dfs(index - 1, nums, target, memo) | dfs(index - 1, nums, target - nums[index], memo)) == 1;
        } else {
            // 只有不选
            res = dfs(index - 1, nums, target, memo) == 1;
        }
        memo[index][target] = res ? 1 : 0;
        return memo[index][target];
    }
}

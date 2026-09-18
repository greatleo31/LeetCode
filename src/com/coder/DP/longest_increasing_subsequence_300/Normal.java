package com.coder.DP.longest_increasing_subsequence_300;

import java.util.*;

public class Normal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.println(lengthOfLIS(nums));
    }

    // 时间复杂度O(n*n)，空间复杂度O(n)
    // 本题属于相邻相关问题 所以不能只是选or不选 而是便利枚举选哪个产生不同结果
    // 定义：dfs[i]：符合题目的最长递增子序列个数
    // 递推：若nums[i-1] < nums[i] 则dfs[i] = dfs[i-1] + 1
    // 其他情况dfs[i] = dfs[i-1]
    public static int lengthOfLIS(int[] nums) {
        // 初始化记忆数组
        int n = nums.length;
        int[] memo = new int[n];
        Arrays.fill(memo, -1);
        int maxLIS = 0;
        for (int i = 0; i < n; i++) {
            maxLIS = Math.max(maxLIS, dfs(i, nums, memo));
        }
        return maxLIS;
    }

    private static int dfs(int i, int[] nums, int[] memo) {
        // 记忆化搜索
        if (memo[i] != -1) {
            return memo[i];
        }
        int len = 0;
        for (int j = 0; j < i; j++) {
            if (nums[j] < nums[i]) {
                len = Math.max(len, dfs(j, nums, memo));
            }
        }
        memo[i] = len + 1;
        return memo[i];
    }
}

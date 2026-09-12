package com.coder.DP.house_robber_198;

public class Normal {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 1 };
        System.out.println(rob(nums));
    }

    // 时间复杂度：O(n), 空间复杂度：O(n)
    public static int rob(int[] nums) {
        // 递推：dp[n] = max(dp[n-1], dp[n-2]+nums[n-1])
        // dp[0] = 0, dp[1] = nums[0]

        // 边界条件：数组不能为空
        if (nums.length == 0) {
            return 0;
        }

        // 初始化参数
        int N = nums.length;
        // dp[n]表示0...n-1最大金额
        int[] dp = new int[N + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i < N + 1; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }
        return dp[N];
    }
}

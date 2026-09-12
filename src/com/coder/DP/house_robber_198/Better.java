package com.coder.DP.house_robber_198;

public class Better {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 1 };
        System.out.println(rob(nums));
    }

    // 时间复杂度：O(n), 空间复杂度：O(1)
    // 思路:当前dp[n] 的大小实际上取决于 dp[n-1] 和 dp[n-2] 的大小，
    // 所以只需要两个变量，这样空间复杂度缩减到O(1)
    public static int rob(int[] nums) {
        // 递推：dp = max(cur, pre+i)
        int pre = 0, cur = 0;
        for (int i : nums) {
            int temp = Math.max(cur, pre + i);
            pre = cur;
            cur = temp;
        }
        return cur;
    }
}

package com.coder.DP.coin_change_322;

import java.util.Arrays;
import java.util.Scanner;

public class Normal {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int amount = sc.nextInt();
        int length = sc.nextInt();
        int[] coins = new int[length];
        for (int i = 0; i < length; i++) {
            coins[i] = sc.nextInt();
        }
        System.out.println(coinChange(coins, amount));
    }

    // 初始化记忆搜索
    private static int[][] memo = new int[13][10001];

    // 时间复杂度：O(n*amount)，空间复杂度：O(n*amount)
    // 递推方程：dp[i][j] = Math.min(dp[i][j-coins[i]]+1, dp[i-1][j]);
    // 记忆化深度优化搜索
    public static int dfs(int[] coins, int i, int j) {
        // 递归边界处理
        if (i < 0) {
            // (对比perfectSquares这里是有可能返回Max_value，所以为了防止溢出需要/2)
            return j == 0 ? 0 : Integer.MAX_VALUE / 2;
        }
        // 记忆化处理，下面一定重新对数据初始化防止0的情况
        if (memo[i][j] != -2) {
            return memo[i][j];
        }
        // 若j < coins[i]
        if (j < coins[i]) {
            return memo[i][j] = dfs(coins, i - 1, j);
        }
        // 若j > coin[i]
        int count = Math.min(dfs(coins, i - 1, j), dfs(coins, i, j - coins[i]) + 1);
        return memo[i][j] = count;
    }

    public static int coinChange(int[] coins, int amount) {
        for (int[] ans : memo) {
            Arrays.fill(ans, -2);
        }
        int result = dfs(coins, coins.length - 1, amount);
        // 这里的判断可以根据题目要求返回，只要 大于等于设置的MAX_VALUE/2 就说明无法得到amount
        return result < Integer.MAX_VALUE / 2 ? result : -1;
    }
}
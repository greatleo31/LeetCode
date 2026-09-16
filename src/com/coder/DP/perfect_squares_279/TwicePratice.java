package com.coder.DP.perfect_squares_279;

import java.util.Scanner;

public class TwicePratice {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(dfs((int) Math.sqrt(n), n));
        sc.close();
    }

    // 定义一个dp数组
    private static final int[][] dp = new int[101][10001];

    // 记忆化搜索
    public static int dfs(int i, int j) {
        // 递归的边界
        if (i == 0) {
            return j == 0 ? 0 : Integer.MAX_VALUE;
        }
        // 记忆化
        if (dp[i][j] != 0) {
            return dp[i][j];
        }
        // 若i*i大于j，并且注意记忆化!!
        if (j < i * i) {
            return dp[i][j] = dfs(i - 1, j);
        }
        return dp[i][j] = Math.min(dfs(i - 1, j), dfs(i, j - i * i) + 1);

    }
}

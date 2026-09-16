package com.coder.DP.perfect_squares_279;

import java.util.Scanner;

public class Normal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(dfs((int) Math.sqrt(n), n));
        sc.close();
    }

    // 定义nums[i][j]：i表示从前i个完全平方数 可重复选取 的数字范围，j表示当前所需完全平方数之和
    private static final int[][] nums = new int[101][10001];

    // 记忆化dfs，时间复杂度：O(n * sqrt(n))，空间复杂度：O(n * sqrt(n))
    public static int dfs(int i, int j) {
        // 递归边界：i=0
        if (i == 0) {
            return j == 0 ? 0 : Integer.MAX_VALUE;
        }
        // 记忆：判断是否之前搜索过确保每一组只搜索一次
        if (nums[i][j] != 0) {
            return nums[i][j];
        }
        // 当前可选范围i*i大于j，则跳过
        if (i * i > j) {
            return dfs(i - 1, j);
        }
        // 当前可选范围小于j，则分为两种情况：不选 或 选
        return Math.min(dfs(i - 1, j), 1 + dfs(i, j - i * i));
    }
}

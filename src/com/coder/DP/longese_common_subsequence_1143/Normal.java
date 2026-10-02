package com.coder.DP.longese_common_subsequence_1143;

import java.util.Arrays;

public class Normal {
    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "ace";
        System.out.println(new Normal().longestCommonSubsequence(text1, text2));
    }

    // 双指针行不通，记忆化搜索
    // 递推方程dp[i][j] 表示 text1和text2最大公共子序列长度
    public int longestCommonSubsequence(String text1, String text2) {
        char[] s1 = text1.toCharArray();
        char[] s2 = text2.toCharArray();
        int m = s1.length;
        int n = s2.length;
        // 初始化记忆化数组
        int[][] memo = new int[m][n];
        for (int[] ans : memo) {
            Arrays.fill(ans, -1);
        }
        return dfs(m - 1, n - 1, s1, s2, memo);
    }

    private int dfs(int i, int j, char[] s1, char[] s2, int[][] memo) {
        // 递归边界
        if (i < 0 || j < 0) {
            return 0;
        }
        // 记忆化搜索
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        if (s1[i] == s2[j]) {
            return memo[i][j] = dfs(i - 1, j - 1, s1, s2, memo) + 1;
        }
        return memo[i][j] = Math.max(dfs(i - 1, j, s1, s2, memo), dfs(i, j - 1, s1, s2, memo));
    }
}
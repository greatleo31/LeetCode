package com.coder.DP.word_break_139;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Normal {

    private static int[] ans = new int[301];

    public static void main(String[] args) {
        // 初始化记忆化数组
        Arrays.fill(ans, -1);
        String s = "leetcode";
        List<String> wordDict = Arrays.asList("leet", "code");
        System.out.println(wordBreak(s, wordDict));
    }

    // 时间复杂度：O(n^2 * m), 空间复杂度：O(n)
    // 递推方程含义：dp[i]表示0~i-1位置的字符串可以拆分成wordDict里面的单词
    // 核心：若j~i-1位置的字符串在wordDict中并且dp[j]为true，则dp[i]为true
    private static int dfs(int i, int maxLen, String s, Set<String> words, int[] memo) {
        if (i == 0) { // 成功拆分！
            return 1;
        }
        if (memo[i] != -1) { // 之前计算过
            return memo[i];
        }
        for (int j = i - 1; j >= Math.max(i - maxLen, 0); j--) {
            if (words.contains(s.substring(j, i)) && dfs(j, maxLen, s, words, memo) == 1) {
                return memo[i] = 1; // 记忆化
            }
        }
        return memo[i] = 0; // 记忆化
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        int maxLen = 0;
        for (String word : wordDict) {
            maxLen = Math.max(maxLen, word.length());
        }
        Set<String> words = new HashSet<>(wordDict);

        int n = s.length();
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1); // -1 表示没有计算过
        return dfs(n, maxLen, s, words, memo) == 1;
    }

}
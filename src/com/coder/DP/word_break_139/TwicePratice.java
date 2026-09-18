package com.coder.DP.word_break_139;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class TwicePratice {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 读取字符串s
        String s = sc.nextLine();
        // 读取字典长度n
        int n = sc.nextInt();
        // 读取字典
        List<String> wordDict = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            wordDict.add(sc.next());
        }
        System.out.println(wordDict(s, wordDict));

    }

    private static boolean wordDict(String s, List<String> wordDict) {
        // 找到字符串数组最长
        int maxLen = 0;
        for (String word : wordDict) {
            maxLen = Math.max(maxLen, word.length());
        }
        // 全局记忆化数组
        int[] ans = new int[s.length() + 1];
        Arrays.fill(ans, -1);
        Set<String> wordDicts = new HashSet<>(wordDict);
        return dfs(s.length() - 1, maxLen, s, wordDicts, ans) == 1;
    }

    private static int dfs(int i, int maxLen, String s, Set<String> wordDicts, int[] ans) {
        // 递归边界
        if (i == 0) {
            return 1;
        }
        // 记忆化搜索
        if (ans[i] != -1) {
            return ans[i];
        }
        // 递归核心：若s的子串(j~i-1)属于wordDicts 并且 dfs(j)能够成功拆分成多个wordDict里面的字符串 == dfs(i)能够拆分成功
        // 为什么？因为：(0~j)能够wordbreak (j-i-1)属于wordDict说明 (0~i-1)就能够拆分成功
        for (int j = i - 1; j > Math.max(i - maxLen, 0); j--) {
            if (wordDicts.contains(s.substring(j, i)) && dfs(j, maxLen, s, wordDicts, ans) == 1) {
                return ans[i] = 1;
            }
        }
        return ans[i] = 0;
    }

}

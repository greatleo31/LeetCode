package com.coder.DP.longest_palindromic_substring_5;

public class Normal {
    public static void main(String[] args) {
        String s = "babad";
        System.out.println(longestPalindrome(s));
    }

    // 时间复杂度：O(n^2)，空间复杂度：O(1)
    // 核心思路：中心扩散+奇偶合一，枚举2*n-2个扩散中心
    private static String longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        int ansleft = 0, ansright = 0;

        // 循环2*n-2个扩散中心
        for (int center = 0; center < 2 * n - 1; center++) {
            int l = center / 2;
            int r = (center + 1) / 2;
            while (l >= 0 && r < n && chars[l] == chars[r]) {
                l--;
                r++;
            }
            // 循环结束，chars[l+1] 到 chars[r-1]是回文子串
            if (r - l - 1 > ansright - ansleft + 1) {
                ansleft = l + 1;
                ansright = r - 1;
            }
        }
        return s.substring(ansleft, ansright + 1);

    }

}

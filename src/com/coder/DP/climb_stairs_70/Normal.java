package com.coder.DP.climb_stairs_70;

import java.util.Scanner;

public class Normal {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    System.out.println(climbStairs(n));
    sc.close();
  }

  public static int climbStairs(int n) {
    // 时间复杂度：O(n)，空间复杂度：O(n)
    // 关系式是f(n) = f(n-1) + 2f(n-2)，但记忆化搜索也就是存储已查过的值减少递归深度

    int[] nums = new int[n + 1];
    return dfs(n, nums);
  }

  private static int dfs(int i, int[] nums) {
    if (i <= 1) { // 递归边界
      return 1;
    }
    if (nums[i] != 0) {
      return nums[i];
    }
    return nums[i] = dfs(i - 1, nums) + dfs(i - 2, nums);
  }
}

package com.coder.greedy.jump_game_2_45;

import java.util.Scanner;

public class Better {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] nums = new int[n];
    for (int i = 0; i < n; i++) {
      nums[i] = sc.nextInt();
    }
    System.out.println(jump(nums));
    sc.close();
  }

  public static int jump(int[] nums) {
    // 时间复杂度：O(n)，空间复杂度：O(1)

    int ans = 0;
    int end = 0;
    int maxPos = 0;
    for (int i = 0; i < nums.length - 1; i++) {
      maxPos = Math.max(nums[i] + i, maxPos);
      if (i == end) {
        end = maxPos;
        ans++;
      }
    }
    return ans;
  }
}
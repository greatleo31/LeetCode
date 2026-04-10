package com.coder.greedy.jump_game_55;

import java.util.Scanner;

public class Better {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    int[] nums = new int[n];
    for (int i = 0; i < n; i++) {
      nums[i] = input.nextInt();
    }
    System.out.println(canJump(nums));
    input.close();
  }

  public static boolean canJump(int[] nums) {
    // 时间复杂度：O(n)，空间复杂度：O(1)
    // 思路：遍历数组，每一次都得到目前能够到达的最大右边界，若当前节点遍历超过最大右边界，说明不可达。
    int rightBound = 0;
    for (int i = 0; i < nums.length; i++) {
      if (i > rightBound)
        return false;
      rightBound = Math.max(rightBound, i + nums[i]);
    }
    return true;
  }
}
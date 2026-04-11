package com.coder.DP.climb_stairs_70;

import java.util.Scanner;

public class Better {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    System.out.println(climbStairs(n));
    sc.close();
  }

  public static int climbStairs(int n) {
    int left = 1;
    int right = 1;
    for (int i = 2; i <= n; i++) {
      int temp = left + right;
      left = right;
      right = temp;
    }
    return right;
  }
}

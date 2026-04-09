package com.coder.greedy.best_time_to_buy_and_sell_stock_121;

import java.util.Scanner;

public class Better {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    int[] prices = new int[n];
    for (int i = 0; i < n; i++) {
      prices[i] = input.nextInt();
    }
    System.out.println(maxProfit(prices));
    input.close();
  }

  public static int maxProfit(int[] prices) {
    // 时间复杂度：O(n),空间复杂度：O(1)
    // 思路：遍历元素是得出当前最小的元素和当前最大的差价
    int min = Integer.MAX_VALUE;
    int maxProfit = 0;
    for (int i = 0; i < prices.length; i++) {
      min = Math.min(min, prices[i]);
      maxProfit = Math.max(maxProfit, prices[i] - min);
    }
    return maxProfit;
  }
}
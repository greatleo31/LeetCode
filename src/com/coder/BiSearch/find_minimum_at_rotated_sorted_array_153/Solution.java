package com.coder.BiSearch.find_minimum_at_rotated_sorted_array_153;

import java.util.Scanner;

public class Solution {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }
    int min = findMin(arr);
    System.out.println(min);
  }

  public static int findMin(int[] arr) {
    // 时间复杂度：O(logn)，空间复杂度：O(1)
    // 思路：分两种情况进行二分查找，第一种first<last说明升序，return first
    // 第二种first>last说明存在两个升序序列，开始二分查找，判断mid在第一段还是第二段升序序列来移动左右指针
    int first = arr[0];
    int last = arr[arr.length - 1];
    int left = 0;
    int right = arr.length - 1;
    // 边界处理
    if (arr.length == 1) {
      return arr[0];
    }
    // 若只存在一段升序序列，直接返回first
    if (first < last) {
      return first;
    }
    // 否则，开始二分查找
    while (left <= right) {
      int mid = (left + right) >>> 1;
      if (arr[mid] >= first) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return arr[left];
  }
}

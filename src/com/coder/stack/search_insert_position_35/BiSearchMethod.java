package com.coder.stack.search_insert_position_35;

public class BiSearchMethod {
  public int searchInsert(int[] nums, int target) {
    // 时间复杂度：O()，空间复杂度：O()
    // 思路：若时间复杂度要求为logn级别，必须是二分查找

    int left = 0;
    int right = nums.length - 1;
    while (left <= right) {
      int middle = left + (right - left) / 2;
      if (nums[middle] == target) {
        return middle;
      } else if (nums[middle] > target) {
        right = middle - 1;
      } else {
        left = middle + 1;
      }
    }
    return left;
  }
}

package com.coder.BiSearch.search_in_rotated_sorted_array_33;

public class Better {
  public int search(int[] nums, int target) {
    // 时间复杂度：O(logn)，空间复杂度：O(1)
    // 思路：二分查找只能查找升(降)序序列，所以本题不能直接用二分查找，而是结合题意修改比较规则，也即target/middle/nums[size-1]三者关系，分类讨论不同target和middle分布情况下的左右指针移动规则
    // 总共四种情况：第一大类为两段升序序列，分target在middle左边和右边分别两种情况，第二大类是一段升序序列，也是分target在middle在左边和右边两种情况
    int last = nums[nums.length - 1];
    int left = 0;
    int right = nums.length - 1;
    while (left <= right) {
      int middle = (left + right) >>> 1;
      if (nums[middle] == target) {
        return middle;
      }
      // 分四种情况
      if (target > last && nums[middle] <= last) {
        right = middle - 1;
      } else if (nums[middle] > last && target <= last) {
        left = middle + 1;
      } else if (target <= nums[middle]) {
        right = middle - 1;
      } else {
        left = middle + 1;
      }
    }
    return (right != -1 && nums[right] == target) ? right : -1;
  }
}
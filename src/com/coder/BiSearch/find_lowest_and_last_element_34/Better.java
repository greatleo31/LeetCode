package com.coder.BiSearch.find_lowest_and_last_element_34;

public class Better {
  public int[] searchRange(int[] nums, int target) {
    // 时间复杂度：O()，空间复杂度：O()
    // 第一：要理解本题目需要了解标准二分查找return left是怎么来的，其实是由于while(left<=right)最后出循环时是left =
    // right + 1;而left恰恰好就是我们需要的下标。
    // 第二：要查找第一个和最后一个的位置其实本质一样，调用同一个函数只是形参一个是target，一个是target+1，所以函数返回值应为 >=
    // target的第一个下标。若有start下标，则至少存在一个目标元素在数组
    // 第三：nums[middle] >= target是精髓所在，作用是不断把右边界推导第一个>=target的下标
    int start = findTheStartOfTarget(nums, target);
    if (start == nums.length || nums[start] != target) {
      return new int[] { -1, -1 };
    }
    int end = findTheStartOfTarget(nums, target + 1) - 1;
    return new int[] { start, end };
  }

  public int findTheStartOfTarget(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1;
    while (left <= right) {
      int middle = left + (right - left) / 2;
      if (nums[middle] >= target) {
        right = middle - 1;
      } else {
        left = middle + 1;
      }
    }
    return left;
  }
}

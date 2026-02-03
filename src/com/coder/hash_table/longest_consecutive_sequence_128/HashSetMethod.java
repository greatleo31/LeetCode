package com.coder.hash_table.longest_consecutive_sequence_128;

import java.util.*;

public class HashSetMethod {
  public int longestConsecutive(int[] nums) {
    // 暴力：存入set，然后排序，在遍历是否连续并且得到最长连续序列
    // 本题：核心在怎么样不排序达到O(n)级别，也即去重之后遍历就要得到结果
    // 核心：遍历时判断本数是否为一个连续序列的开头(也即前一个数是否存在于set),存在则跳过，不存在则循环判断后续的数是否一直存在于set，同时递增长度

    // 创建哈希set
    Set<Integer> set = new HashSet<>();
    // 去重
    for (int num : nums) {
      set.add(num);
    }

    // 创建长度计数器
    int MaxLength = 0;

    // 遍历判断
    for (Integer num : set) {
      // 本数非一个连续序列的开头跳过
      if (set.contains(num - 1))
        continue;

      // 初始化遍历
      int currentNum = num;
      int LocalMaxLength = 1;
      // 若开头，则循环判断后续的数是否存在
      while (set.contains(currentNum + 1)) {
        LocalMaxLength++;
        currentNum++;
      }
      MaxLength = Math.max(MaxLength, LocalMaxLength);
    }
    return MaxLength;
  }
}

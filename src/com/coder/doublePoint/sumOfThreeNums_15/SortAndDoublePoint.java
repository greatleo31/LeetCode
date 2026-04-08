package com.coder.doublePoint.sumOfThreeNums_15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortAndDoublePoint {
    public List<List<Integer>> threeSum(int[] nums) {
        // 三指针转换为双指针，持续去重

        // 排序
        Arrays.sort(nums);
        // 创建集合
        List<List<Integer>> ans = new ArrayList<>();
        // 遍历
        for (int i = 0; i < nums.length - 2; i++) {
            // 去重
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            // 初始化头尾指针
            int start = i + 1;
            int tail = nums.length - 1;
            // 转换三数之和为两数之和
            int twoSum = -(nums[i]);
            // 循环判断
            while (start < tail) {
                int sum = nums[start] + nums[tail];
                if (sum < twoSum) {
                    start++;
                } else if (sum > twoSum) {
                    tail--;
                } else {
                    ans.add(Arrays.asList(nums[i], nums[start], nums[tail]));
                    start++;
                    tail--;
                    while (start < tail && nums[start] == nums[start - 1])
                        start++;
                    while (start < tail && nums[tail] == nums[tail + 1])
                        tail--;
                }
            }
        }
        return ans;
    }
}
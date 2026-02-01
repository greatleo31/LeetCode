package com.coder.hash_table.two_sum_1;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        // 要迅速判断一个数组/集合里面是否包含某一个值：哈希表
        // 本题目思路：遍历数组，判断目标值-当前数之差是否存在于哈希表里，是则返回下标，否则添加当前值到哈希表里面。
        // 注意点：1.用HashMap存映射(值和下标的映射)，以及用HashMap自动避免哈希碰撞

        // 创建结果数组
        int[] ans = new int[2];
        // 边界处理
        if (nums == null || nums.length == 0) {
            return null;
        }

        // 初始化哈希映射
        Map<Integer, Integer> map = new HashMap<>();
        // 遍历数组
        for (int i = 0; i < nums.length; i++) {
            int balance = target - nums[i];
            if (map.containsKey(balance)) {
                ans[0] = map.get(balance);
                ans[1] = i;
                break;
            } else {
                map.put(nums[i], i);
            }
        }
        return ans;
    }
}

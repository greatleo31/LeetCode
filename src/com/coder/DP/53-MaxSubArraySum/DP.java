package com.coder.array._53_MaxSubArraySum;
public class DP {

    //动态规划的思想
    //f(i)=max{f(i−1)+nums[i],nums[i]}

    public int maxSubArray(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }
}
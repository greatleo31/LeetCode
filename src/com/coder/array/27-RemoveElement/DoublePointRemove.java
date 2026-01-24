package com.coder.array;
public class DoublePointRemove {
        public int removeElement(int[] nums, int val) {
            //双指针算法

            //先定义快慢指针
            int fast=0;
            int slow=0;

            //单层循环快指针遍历
            for(; fast<nums.length; fast++){
                //排除非目标情况
                if(nums[fast]==val) continue;

                //若不等于，则属于新数组
                nums[slow++]=nums[fast];
            }
            return slow;
        }
}
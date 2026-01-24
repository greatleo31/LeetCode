package com.coder.array;

public class ForceRemove {
        public int removeElement(int[] nums, int val) {
            //暴力算法
            int size = nums.length;

            //外层for循环遍历
            for(int i=0 ; i< size; i++){
                //内层for循环实现“删除”操作
                //排除非目标的情况
                if(nums[i] != val){
                    continue;
                }
                //若相等，则需删除
                int j;
                for(j=i ; j<size-1 ; j++){
                    nums[j]=nums[j+1];
                }
                size--;
                i--;
            }
            return size;
        }
}
package com.coder.array;
import java.util.*;

class Normal {
    //核心思想：调用java自带的排序方法
    public int[] sortedSquares(int[] nums) {
        int[] num = new int[nums.length];
        for(int i=0 ; i<nums.length ; i++){
            num[i]=Math.abs(nums[i])*Math.abs(nums[i]);
        }
        Arrays.sort(num);
        return num;
    }
}
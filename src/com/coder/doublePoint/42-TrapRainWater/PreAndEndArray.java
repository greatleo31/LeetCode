package com.coder.doublePoint.42-TrapRainWater;

public class PreAndEndArray {
    public int trap(int[] height) {
        //前后缀数组法

        int size = height.length;
        //前缀数组
        int[] pre = new int[size];
        pre[0] = height[0];
        for(int i=1; i<size; i++){
            pre[i] = Math.max(pre[i-1], height[i]);
        }

        //后缀数组
        int[] end = new int[size];
        end[size - 1] = height[size - 1];
        for(int i=size - 2; i>=0; i--){
            end[i] = Math.max(end[i+1], height[i]);
        }

        //遍历
        int sum = 0;
        for(int i=0; i<size; i++){
            sum+=Math.min(pre[i], end[i]) - height[i];
        }
        return sum;
    }
}

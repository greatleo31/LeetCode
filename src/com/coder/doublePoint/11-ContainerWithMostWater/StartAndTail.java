package com.coder.doublePoint;
public class StartAndTail {
    public int maxArea(int[] height) {
        //双指针:头尾指针

        //初始化头尾指针
        int start = 0;
        int tail = height.length-1;
        int max = 0;
        //双指针循环
        while(start < tail){
            //得到面积
            int area = Math.min(height[start], height[tail])*(tail - start);
            //比较得到最大面积
            max = Math.max(area, max);
            //判断头尾指针的柱值
            if(height[start] > height[tail]){
                tail--;
            }else{
                start++;
            }
        }
        return max;
    }
}
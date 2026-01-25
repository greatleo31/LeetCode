package com.coder.array._53_MaxSubArraySum;
class PreSum {

    //动态规划+前缀和

    public int maxSubArray(int[] nums) {
        //边界处理，若数组长度为零或数组为空就返回0
        if(nums == null || nums.length == 0){
            return 0;
        }

        //初始化变量
        int preSum = 0;   //先前前缀和
        int preMin = 0;   //先前最小和
        int maxSum = nums[0];  //最大和

        //遍历
        for(int num : nums){
            //得到最新的前缀和
            preSum+=num;

            //得到区间和
            int curSum=preSum-preMin;

            //判断当前区间是否是最大和
            maxSum = Math.max(maxSum, curSum);

            //判断当前前缀和是否是最小和
            preMin = Math.min(preSum, preMin);
        }
        return maxSum;
    }
}
/*
53. Maximum Subarray
Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
the contiguous subarray [4,-1,2,1] has the largest sum = 6.

*/

public class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum =Integer.MIN_VALUE;
        int curSum = 0;
        boolean allNeg = true;
        int minNeg= Integer.MIN_VALUE;
        for(int i =0;i<nums.length;i++){
            if(nums[i] > 0) allNeg = false;
            else minNeg = Math.max(minNeg, nums[i]);
            if(curSum+nums[i] < 0) {curSum =0;}
            else {
                curSum += nums[i];
            }
            maxSum = Math.max(maxSum, curSum);
        }
        if(allNeg) return minNeg;
        return maxSum;
    }
}

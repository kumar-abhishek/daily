/*
136. Single Number
Given an array of integers, every element appears twice except for one. Find that single one.
*/
public class Solution {
    public int singleNumber(int[] nums) {
        int ans = nums[0];
        for(int i=1;i<nums.length;i++){
            ans ^= nums[i];
        }
        return ans;
    }
}


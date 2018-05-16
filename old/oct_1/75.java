/*
75. Sort Colors
Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
*/

public class Solution {
    public void swap(int[] nums, int p1, int p2){
        int temp = nums[p1];
        nums[p1] = nums[p2];
        nums[p2] = temp;
    }
    public void sortColors(int[] nums) {
        int lo=0, mid=0, hi=nums.length-1;
        while(mid <= hi){
            switch(nums[mid]){
                case 0:
                    swap(nums, lo, mid);
                    lo += 1;
                    mid += 1;
                    break;
                case 1:
                    mid += 1;
                    break;
                case 2:
                    swap(nums, mid, hi);
                    hi -= 1;
                    break;
            }
        }
    }
}

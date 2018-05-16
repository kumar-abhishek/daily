/*
283. Move Zeroes
Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].

Note:
You must do this in-place without making a copy of the array.
Minimize the total number of operations.
*/

public class Solution {
    public void moveZeroes(int[] nums) {
        int z =0, nz = 0, n = nums.length;
        
        while(z < n && nz < n) {
            while(z < n && nums[z] != 0) z++;
            if(z>=n) break;
            while(nz < n && nums[nz] == 0) nz++;
            if(nz >= n) break;
            int temp = nums[z];
            nums[z] = nums[nz];
            nums[nz] = temp;
            z = nz;
        }
    }
}

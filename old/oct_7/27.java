/*
27. Remove Element
Given an array and a value, remove all instances of that value in place and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

The order of elements can be changed. It doesn't matter what you leave beyond the new length.

Example:
Given input array nums = [3,2,2,3], val = 3

Your function should return length = 2, with the first two elements of nums being 2.
*/

public class Solution {
    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        int i =0, last = n-1;
        while(i < n && last >= 0){
            while(i<n && nums[i] != val) i++;
            while(last>= 0 && nums[last] == val) last--;
            if(i>=n || last<0) break;
            int temp = nums[i];
            nums[i] = nums[last];
            nums[last] = temp;
        }
        return ++last;
    }
}

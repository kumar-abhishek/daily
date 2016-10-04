/*
169. Majority Element
Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.
*/
//accepted
public class Solution {
    public int majorityElement(int[] nums) {
        int counter = 1, n = nums[0];
        for(int i=1;i<nums.length;i++){
            if(n == nums[i]) counter++;
            else {
                --counter;
                if(counter <=0) {
                    counter = 1;
                    n = nums[i];
                }
            }
        }
        return n;
    }
}

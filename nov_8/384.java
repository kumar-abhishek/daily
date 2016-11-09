/*
384. Shuffle an Array
Shuffle a set of numbers without duplicates.

*/

//accepted

import java.util.*;
import java.util.Arrays;
public class Solution {
    private int[] arr, original;
    Random random;
    public Solution(int[] nums) {
        this.random = new Random();
        this.arr = nums;
        this.original = Arrays.copyOf(nums, nums.length);
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        this.arr = this.original.clone();
        return this.arr;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int n = this.arr.length;
        for(int i=0;i<n;i++) {
            int r = this.random.nextInt(i+1);
            int temp = this.arr[i];
            this.arr[i] = this.arr[r];
            this.arr[r] = temp;
        }
        return this.arr;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */

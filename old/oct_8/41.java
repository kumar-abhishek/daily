/*

41. First Missing Positive 
Given an unsorted integer array, find the first missing positive integer.

For example,
Given [1,2,0] return 3,
and [3,4,-1,1] return 2.

Your algorithm should run in O(n) time and uses constant space.
*/
// NOT accepted, some missing corner cases
public class Solution {
    public int firstMissingPositive(int[] nums) {
        if(nums.length == 0) return 1;
        int ans = 0, start = Integer.MAX_VALUE, max=Integer.MIN_VALUE;
        HashSet hs = new HashSet();
        for(int i =0;i<nums.length;i++) hs.add(nums[i]);    
        for(int i =0;i<nums.length;i++) {
            max = Math.max(max, nums[i]);
            if(hs.contains(nums[i]-1)) continue;
            if(nums[i] >= 2) start = Math.min(start, nums[i]);
        }
        if(start >= 2) return 1;
        if(start == Integer.MAX_VALUE) return max+1;
        return start-1;
    }
}

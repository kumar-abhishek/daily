/*
219. Contains Duplicate II
Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the difference between i and j is at most k.
*/

//accepted
public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> hash = new HashSet<Integer>();
        for(int i=0;i<nums.length;i++){
            if(hash.size()>k) hash.remove(nums[i-k-1]);
            if(!hash.add(nums[i])) return true;
        }
	return false;
    }
}

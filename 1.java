/*
Two Sum
Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution.

Example:
Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].

*/

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hash = new HashMap<>();
        for(int i = 0;i<nums.length;i++){
            hash.put(nums[i], i);
        }
        for(int i = 0;i<nums.length;i++){
            if(hash.containsKey(target-nums[i]) && hash.get(target-nums[i]) != i){
                return new int[]{i, hash.get(target-nums[i])};
            }
        }
        
        return new int[]{-1, -1};
    } 
    // single pass solution
    public int[] twoSumSinglePass(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i =0;i<nums.length;i++){
            int toLook = target-nums[i];
            if(map.containsKey(toLook) && map.get(toLook) != i){
                return new int[] {i, map.get(toLook)};
            } else{
                map.put(nums[i], i);
            }
        }
        return new int[]{-1,-1};
    }
}

/*
47. Permutations II
Given a collection of numbers that might contain duplicates, return all possible unique permutations.

For example,
[1,1,2] have the following unique permutations:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]
*/

//accepted
public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        List<Integer> temp = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtrack(nums, list, temp, used);    
        return list;
    }
    
    public void backtrack(int[] nums, List<List<Integer>> list, List<Integer> temp, boolean[] used) {
        if(temp.size() == nums.length) { list.add(new ArrayList<>(temp)); return; }
        for(int i=0;i<nums.length;i++) {
            if(used[i] == true || (i>0 && nums[i] == nums[i-1] && !used[i-1])) continue;
            temp.add(nums[i]);
            used[i] = true;
            backtrack(nums, list, temp, used);
            temp.remove(temp.size()-1);
            used[i] = false;
        }
    }
}


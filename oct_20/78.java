/*
78. Subsets
Given a set of distinct integers, nums, return all possible subsets.

Note: The solution set must not contain duplicate subsets.

For example,
If nums = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
*/

//accepted
public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        backtrack(nums, list, temp, 0);
        return list;
    }
    public void backtrack(int[] nums, List<List<Integer>> list, List<Integer> temp, int start) {
        list.add(new ArrayList<>(temp));
        for(int i=start;i<nums.length;i++) {
            temp.add(nums[i]);
            backtrack(nums, list, temp, i+1);
            temp.remove(temp.size()-1);
        }
    }
}

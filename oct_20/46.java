/*
46. Permutations
Given a collection of distinct numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
*/

//accepted
public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        backtrack(nums, list, temp);    
        return list;
    }
    
    public void backtrack(int[] nums, List<List<Integer>> list, List<Integer> temp) {
        if(temp.size() == nums.length) { list.add(new ArrayList<>(temp)); return; }
        for(int i=0;i<nums.length;i++) {
            if(temp.contains(nums[i])) continue;
            temp.add(nums[i]);
            backtrack(nums, list, temp);
            temp.remove(temp.size()-1);
        }
    }
}


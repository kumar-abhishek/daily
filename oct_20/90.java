/*
90. Subsets II
Given a collection of integers that might contain duplicates, nums, return all possible subsets.

Note: The solution set must not contain duplicate subsets.

For example,
If nums = [1,2,2], a solution is:

[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
*/

//accepted
public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(nums, list, temp, 0, used);
        return list;
    }
    public void backtrack(int[] nums, List<List<Integer>> list, List<Integer> temp, int start, boolean[] used) {
        list.add(new ArrayList<>(temp));
        for(int i=start;i<nums.length;i++) {
            if(i>0 && nums[i] == nums[i-1] && !used[i-1]) continue;
            temp.add(nums[i]);
            used[i] = true;
            backtrack(nums, list, temp, i+1, used);
            temp.remove(temp.size()-1);
            used[i] = false;
        }
    }
}

// accepted
public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, list, temp, 0);
        return list;
    }
    public void backtrack(int[] nums, List<List<Integer>> list, List<Integer> temp, int start) {
        list.add(new ArrayList<>(temp));
        for(int i=start;i<nums.length;i++) {
            if(i>start && nums[i] == nums[i-1]) continue;
            temp.add(nums[i]);
            backtrack(nums, list, temp, i+1);
            temp.remove(temp.size()-1);
        }
    }
}

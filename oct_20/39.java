/*
39. Combination Sum
Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
For example, given candidate set [2, 3, 6, 7] and target 7, 
A solution set is: 
[
  [7],
  [2, 2, 3]
]
*/

//accepted
public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, list, temp, target, 0);
        return list;
    }
    public void backtrack(int[] candidates, List<List<Integer>> list, List<Integer> temp, int target, int start){
        if(target<0) return;
        if(target==0) { list.add(new ArrayList<>(temp)); return; }
        for(int i=start;i<candidates.length;i++) {
            temp.add(candidates[i]);
            backtrack(candidates, list, temp, target-candidates[i], i);
            temp.remove(temp.size()-1);
        }
    }
    
}


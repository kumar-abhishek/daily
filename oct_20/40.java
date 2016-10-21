/*
40. Combination Sum II
Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8, 
A solution set is: 
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
*/

//accepted

public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        boolean[] used = new boolean[candidates.length];
        Arrays.sort(candidates);
        backtrack(candidates, list, temp, used, target, 0);
        return list;
    }
    public void backtrack(int[] candidates, List<List<Integer>> list, List<Integer> temp, boolean[] used, int target, int start){
        if(target<0) return;
        if(target==0) { list.add(new ArrayList<>(temp)); return; }
        for(int i=start;i<candidates.length;i++) {
            if(i>0 && !used[i-1] && candidates[i] == candidates[i-1]) continue;
            temp.add(candidates[i]);
            used[i] = true;
            backtrack(candidates, list, temp, used, target-candidates[i], i+1);
            used[i] = false;
            temp.remove(temp.size()-1);
        }
    }
}

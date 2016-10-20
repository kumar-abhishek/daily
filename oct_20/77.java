/*
77. Combinations
Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

For example,
If n = 4 and k = 2, a solution is:

[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
Show Tags
Show Similar Problems

*/

//accepted

public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        backtrack(list, temp, n, k, 1);
        return list;
    }
    public void backtrack(List<List<Integer>> list, List<Integer> temp, int n, int k, int start){
        if(temp.size() == k) { list.add(new ArrayList<>(temp)); return; }
        for(int i=start;i<=n;i++){
            temp.add(i);
            backtrack(list, temp, n, k, i+1);
            temp.remove(temp.size()-1);
        }
    }
    
}

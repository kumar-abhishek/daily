/*
15. 3Sum  QuestionEditorial Solution

Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note: The solution set must not contain duplicate triplets.

For example, given array S = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
*/

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for(int i=0;i<n;i++){
            int j=1, k = n-1;
            if(i!=j && j!=k && i!=k){
                if(nums[i]+nums[j]+nums[k]==0){
                    List<Integer> l = new ArrayList<>();
                    l.add(nums[i]);
                    l.add(nums[j]);
                    l.add(nums[k]);
                    ans.add(l);
                }
                if(nums[i]+nums[j]+nums[k]<0){
                    j += 1;
                } else{
                    k -=1;
                }
            
            }
        }
        return ans;
    }
}

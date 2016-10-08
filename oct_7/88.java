/*
88. Merge Sorted Array 
Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:
You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2. The number of elements initialized in nums1 and nums2 are m and n respectively.
*/


public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = m + n-1;
        --m; --n;
        while(m>=0 && n>=0){
            if(nums2[n] >= nums1[m]){
                nums2[index--] = nums2[n--];
            } else{
                nums2[index--] = nums1[m--];
            }
        }
    }
}

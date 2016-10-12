/*
108. Convert Sorted Array to Binary Search Tree
Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
*/

//accepted

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode inorder(int[] nums, int start, int end){
        int l = end-start+1;
        if(l == 0){
            return null;
        }
        int mid = start + l/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = inorder(nums, start, mid-1);
        root.right = inorder(nums, mid+1, end);
        return root;
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        return inorder(nums, 0, nums.length-1);
    }
}

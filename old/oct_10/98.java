/*
98. Validate Binary Search Tree
98. Validate Binary Search Tree  QuestionEditorial Solution  My Submissions
Total Accepted: 117292 Total Submissions: 537165 Difficulty: Medium
Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
Example 1:
    2
   / \
  1   3
Binary tree [2,1,3], return true.
Example 2:
    1
   / \
  2   3
Binary tree [1,2,3], return false.
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
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        return isValidBSTRec(root, null, null);
    }
    
    public boolean isValidBSTRec(TreeNode root, Integer max, Integer min){
        if(root == null) return true;
        if((max != null && root.val >= max) || (min != null && root.val <= min)) return false;
        return isValidBSTRec(root.left, root.val, min) && isValidBSTRec(root.right, max, root.val);
    }
}

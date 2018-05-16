/*
98. Validate Binary Search Tree  QuestionEditorial Solution
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
        return isValidBSTRec(root, Long.MAX_VALUE, Long.MIN_VALUE);
    }
    
    public boolean isValidBSTRec(TreeNode root, long max, long min){
        if(root == null) return true;
        if(root.val > max || root.val < min) return false;
        return isValidBSTRec(root.left, root.val-1, min) && isValidBSTRec(root.right, max, root.val+1);
    }
}

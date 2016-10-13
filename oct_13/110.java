/*
110. Balanced Binary Tree
Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
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
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        if(isBalancedRec(root) == -1) return false;
        return true;
    }
    public int isBalancedRec(TreeNode root){
        if(root == null) return 0;
        int l = isBalancedRec(root.left);
        if(l == -1) return -1;
        int r = isBalancedRec(root.right);
        if(r == -1) return -1;
        if(Math.abs(l-r) > 1) return -1;
        return Math.max(l, r) + 1;
    }
}

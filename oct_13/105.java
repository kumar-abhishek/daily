/*
105. Construct Binary Tree from Preorder and Inorder Traversal  
Given preorder and inorder traversal of a tree, construct the binary tree.

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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0) return null;
        return buildTreeRec(preorder, inorder, 0, 0, inorder.length-1);
    }
    public TreeNode buildTreeRec(int[] preorder, int[] inorder, int preStart, int inStart, int inEnd) {
        if((preStart >= preorder.length) || (inStart > inEnd)) return null;
        TreeNode root = new TreeNode(preorder[preStart]);
        int inIndex=0;
        for(int i=inStart; i<=inEnd;i++) if(inorder[i] == preorder[preStart]) inIndex = i;
        root.left = buildTreeRec(preorder, inorder, preStart+1, inStart, inIndex-1);
        root.right = buildTreeRec(preorder, inorder, preStart+inIndex-inStart+1, inIndex+1, inEnd);
        return root;
    }
}


/*
297. Serialize and Deserialize Binary Tree  QuestionEditorial Solution
Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.

For example, you may serialize the following tree

    1
   / \
  2   3
     / \
    4   5
as "[1,2,3,null,null,4,5]", just the same as how LeetCode OJ serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.
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
public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }
    StringBuilder buildString(TreeNode root, StringBuilder sb){
        if(root == null){
            sb.append("# ");
        } else {
            sb.append(root.val+" ");
            buildString(root.left, sb);
            buildString(root.right, sb);
        }
        return sb;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return deserializeRec(new Scanner(data));
    }
    public TreeNode deserializeRec(Scanner sc){
        if(!sc.hasNext()) return null;
        String s = sc.next();
        if(s.equals("#")) return null;
        TreeNode t = new TreeNode(Integer.valueOf(s));
        t.left = deserializeRec(sc);
        t.right = deserializeRec(sc);
        return t;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));

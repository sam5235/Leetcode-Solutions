/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        if(root != null && depth(root.left) == depth(root.right)) return root;
        return (depth(root.left) > depth(root.right) ? lcaDeepestLeaves(root.left) : lcaDeepestLeaves(root.right));
    }
    
    int depth(TreeNode node){
        if(node == null) return 0;
        return (1 + Math.max(depth(node.left), depth(node.right)));
    }
}
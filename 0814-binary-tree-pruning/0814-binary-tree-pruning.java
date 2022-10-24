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
    public TreeNode pruneTree(TreeNode root) {
        return helper(root);
    }
    
    TreeNode helper(TreeNode node){
        if(node == null) return null;
        node.left = helper(node.left);
        node.right = helper(node.right);
        if(node.left == null && node.right == null)
            return node.val == 0 ? null : node;
     return node;
        
    }
}
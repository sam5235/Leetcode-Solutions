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
        return helper(root) ? null : root;
    }
    
    boolean helper(TreeNode node){
        if(node == null) return true;
        if(helper(node.left))
            node.left = null;
        if(helper(node.right))
            node.right = null;
        if(node.left == null && node.right == null)
            return node.val == 0;
     return false;
        
    }
}
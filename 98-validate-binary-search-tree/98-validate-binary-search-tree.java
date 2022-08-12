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
    public boolean isValidBST(TreeNode root) {
        if(root.left== null && root.right == null) return true;
         return dfs(root, Long.MIN_VALUE  , Long.MAX_VALUE);
    }
    boolean dfs(TreeNode node, long leftB, long rightB){
        if(node == null) return true;
        if(node.val <= leftB || node.val >= rightB) return false;
        boolean l = dfs(node.left, leftB, (long)node.val);     
        boolean r = dfs(node.right, (long)node.val ,rightB);
        return l && r;
    }
}
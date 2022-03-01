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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;
        return dfs(root, 0, targetSum);           
    }
    public boolean dfs(TreeNode node, int sum, int target){
        sum += node.val;
        if(node.left == null && node.right == null){
            return (sum == target);
        }
        if(node.left != null){
           if(dfs(node.left, sum, target)) return true;
        }
        return (node.right != null) && dfs(node.right, sum, target);
    }
}
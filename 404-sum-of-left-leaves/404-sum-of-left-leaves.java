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
    public int sumOfLeftLeaves(TreeNode root) {
          if(root.left == null && root.right == null) return 0;
        int[] ans = new int[1];
             sum(root,root, ans);
        return ans[0];
    }
    void sum(TreeNode node,TreeNode p, int[] acc){
        if(node == null) return ;
        if(node.left == null && node.right == null &&p.left == node){
            acc[0] += node.val;
            return;
        }
         sum(node.left,node, acc);
        sum(node.right,node, acc);
    
    }
}
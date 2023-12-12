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
    StringBuilder sb = new StringBuilder();
    public String tree2str(TreeNode root) {
      helper(root);
      return sb.toString();
    }
  
    void helper(TreeNode node){
      if(node == null)
        return;
      sb.append(node.val);
      if(node.right == null && node.left == null){
        return;
      }
        sb.append("(");
        helper(node.left);
        sb.append(")"); 
      
      if(node.right != null){
        sb.append("(");
        helper(node.right);
        sb.append(")");
      }

      
    }      
}
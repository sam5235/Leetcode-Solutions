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
    public TreeNode invertTree(TreeNode root) {
        inverter(root);
            return root;

    }
    
    TreeNode inverter(TreeNode node){
        if(node == null) return node;
        if(node.left == null && node.right == null) return node;
        TreeNode temp = inverter(node.left);
        node.left = inverter(node.right);
        node.right = temp;
        return node;
    }
}
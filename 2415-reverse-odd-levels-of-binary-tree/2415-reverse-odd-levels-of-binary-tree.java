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
    public TreeNode reverseOddLevels(TreeNode root) {
        dfs(root,root, 0);
        return root;
    }
    void dfs(TreeNode node1,TreeNode node2, int c){
        if(node1 == null) return;
        if(node1.right == null && node1.left == null) return;
        if(c % 2 == 0){
            int temp = node2.right.val;
            node2.right.val = node1.left.val;
            node1.left.val = temp;
        }
        dfs(node1.left, node2.right, c + 1);
        dfs(node1.right,node2.left, c + 1);
    }
}
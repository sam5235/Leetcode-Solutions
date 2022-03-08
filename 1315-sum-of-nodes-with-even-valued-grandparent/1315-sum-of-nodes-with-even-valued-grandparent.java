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
    public int sumEvenGrandparent(TreeNode root) {
        int[] ans = {0};
        dfs(root, 1, 1, ans);
        return ans[0];
    }
    
    void dfs(TreeNode node, int parent, int granPa, int[] sum){
        if(node == null) return;
        if(granPa % 2 == 0) {
            sum[0] += node.val;
        }
        dfs(node.left, node.val, parent, sum);
        dfs(node.right, node.val, parent, sum);
    }
}
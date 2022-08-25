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
    public int maxDepth(TreeNode root) {

         int[] ans = new int[2];
         ans = dfs(root, ans);
        return ans[0];
    }
    int[] dfs(TreeNode node, int[] max){
        if(node == null){
            max[0] = Math.max(max[0], max[1]);
            return max;
        }
        
        max[1]++;
        dfs(node.left, max);
        dfs(node.right, max);
        max[1]--;
        return max;
    }
}
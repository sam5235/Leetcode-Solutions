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
    public int findTilt(TreeNode root) {
        int[] tilt ={0};
        if(root != null) dfs(root, tilt);
        return tilt[0];
        
    }
    int dfs(TreeNode node, int[] tilt){
        if(node.left == null && node.right == null){
            return node.val;
        }else{
            int left  = (node.left == null) ? 0: dfs(node.left, tilt);
            int right = (node.right == null)? 0: dfs(node.right, tilt);
            tilt[0] += Math.abs( left - right );
            return left + right + node.val;
        }
    }
}
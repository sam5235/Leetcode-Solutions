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
        int[] ans ={0} ;
        dfs(root, ans);
        return ans[0];
    }
    
    void dfs(TreeNode node, int[] sum){
        if(node == null) return;
        if(node.val % 2 == 0){
            if(node.left != null){
                TreeNode left = node.left;
                if(left.left != null){
                    sum[0] = sum[0] + left.left.val;
                }
                if(left.right != null){
                    sum[0] = sum[0] + left.right.val;
                }
            }
            if(node.right != null){
                 TreeNode right = node.right;
                if(right.left != null){
                    sum[0] = sum[0] + right.left.val;
                }
                if(right.right != null){
                    sum[0] = sum[0] + right.right.val;
                }
            }
        }
        if(node.left != null) dfs(node.left, sum);
        if(node.right != null) dfs(node.right, sum);
    }
}
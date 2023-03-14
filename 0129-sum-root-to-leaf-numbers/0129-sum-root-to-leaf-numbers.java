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
    public int sumNumbers(TreeNode root) {
        int[] ans = new int[1];
        sum(root, 0,ans);
        return ans[0];
        
    }
    
    void sum (TreeNode node, int curr, int[] ans){
        if(node == null)
            return;
        if(node.left == null && node.right == null){
             ans[0] += (curr * 10) + node.val;
            return;
        }
        curr = (curr * 10) + node.val;
        sum (node.left, curr, ans);
        sum (node.right, curr, ans);

        
    }
}
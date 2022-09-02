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
    public int goodNodes(TreeNode root) {
        int[] ans = new int[1];
        findGood(root, root.val, ans);
        return ans[0];
    }
    void findGood(TreeNode node, int max, int[] count){
        if(node == null) return;
        if(node.val >= max){
            count[0]++;
            max = Math.max(max, node.val);
        } 
        findGood(node.left, max, count);
        findGood(node.right, max, count);
    }
}
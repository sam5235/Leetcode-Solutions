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
    public int minDepth(TreeNode root) {
        return depth(root, new int[]{100000,0});
    }
    int depth(TreeNode node, int[] max){
        if(node == null) return 0;
            if(node.left == null && node.right == null){
                max[1]++;
                max[0] = Math.min(max[0], max[1]);
                        max[1]--;

                return max[0];
            } 
        max[1]++;
        depth(node.left, max);
        depth(node.right, max);
        max[1]--;
        
        return max[0];
    }
}
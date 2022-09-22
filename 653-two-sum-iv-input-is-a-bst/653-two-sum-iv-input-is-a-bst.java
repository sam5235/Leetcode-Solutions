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
    public boolean findTarget(TreeNode root, int k) {
        return dfs(root, root, k);
    }
    boolean dfs(TreeNode node, TreeNode root, int k){
        if(node == null) return false;
        if(find(root,node, k - node.val)) return true;
        
        return dfs(node.left, root, k) || dfs(node.right, root, k);  
    }
    
    boolean find(TreeNode node,TreeNode n, int num){
        if(node == null) return false;
        if(node != n && node.val == num) return true;
        if(num > node.val) return find(node.right, n, num);
        return find(node.left,n, num);
    }
}
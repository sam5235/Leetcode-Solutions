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
    HashSet<Integer> delete = new HashSet<>();
    List<TreeNode> ans = new ArrayList<>();
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        for(int n : to_delete)
            delete.add(n);
        helper(root, true); 
        return ans;
    }
    
    public TreeNode helper(TreeNode node, boolean is_root){
        if(node == null) return null;
        boolean deleted = delete.contains(node.val);
        if(is_root && !deleted) ans.add(node);
        node.left = helper(node.left, deleted);
        node.right = helper(node.right, deleted);
        return deleted? null : node;
    }
}
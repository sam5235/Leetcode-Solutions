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
    List<Integer> ans = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        if(root != null)
            rightSide(root, 0);
        return ans;
    }
    
    public List<Integer> rightSide(TreeNode root, int level) {
        if(ans.size() == level)
            ans.add(root.val);
        if(root.right != null)
            rightSide(root.right, level+1);
        if(root.left != null)
            rightSide(root.left, level+1);
    
        return ans;
    }
}
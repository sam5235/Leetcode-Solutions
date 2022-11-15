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
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> curr = new LinkedList<>();
        curr.add(root);
        int ans = 0;
        while(!curr.isEmpty()){
            int size = curr.size();
            ans += size;
            for(int i = 0; i < size; i++){
                TreeNode polled = curr.poll();
                if(polled.left != null)
                    curr.add(polled.left);
                if(polled.right != null)
                    curr.add(polled.right);
            }
        }
        return ans;
    }
}
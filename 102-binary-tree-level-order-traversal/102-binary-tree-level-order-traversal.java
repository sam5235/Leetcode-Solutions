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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ls = new ArrayList<>();
        if(root == null) return ls;
        Queue<TreeNode> curr = new LinkedList<>();
        curr.add(root);
        while(!curr.isEmpty()){
            int size = curr.size();
            List<Integer> inner = new LinkedList<>();
            for(int i = 0; i < size; i++){
                TreeNode polled = curr.poll();
                if(polled.left != null) curr.add(polled.left);
                if(polled.right != null) curr.add(polled.right);
                inner.add(polled.val);
            }
            ls.add(inner);
        }
        return ls;
    }
}
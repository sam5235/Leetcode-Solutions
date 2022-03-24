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
    public List<Integer> largestValues(TreeNode root) {
        Queue<TreeNode> cr = new LinkedList<>();
        Queue<TreeNode> nxt = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        cr.add(root);
        while(!cr.isEmpty()){
            int max = Integer.MIN_VALUE;
            while(!cr.isEmpty()){
                TreeNode popped = cr.poll();
               if(popped != null)max = Math.max(max, popped.val);
                if(popped != null && popped.right != null)nxt.add(popped.right);
                if(popped != null  && popped.left != null)nxt.add(popped.left);
            }
            ans.add(max);
            cr = nxt;
            nxt = new LinkedList<>();
        }
        if(root != null) return ans;
        return new ArrayList<>();
    }
}
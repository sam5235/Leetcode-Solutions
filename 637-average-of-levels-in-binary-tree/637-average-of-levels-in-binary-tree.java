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
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> cur = new LinkedList<>();
        Queue<TreeNode> nxt = new LinkedList<>();
        List<Double> ans = new ArrayList<>();
        cur.add(root);
        while(!cur.isEmpty()){
        double avg = 0;
        double size = cur.size();
         for(int i = 0; i < size; i++){
             TreeNode polled = cur.poll();
             avg += polled.val;
             if(polled.left != null)nxt.add(polled.left);
             if(polled.right != null)nxt.add(polled.right);   
         }
            ans.add(avg/size);
            cur = nxt;
            nxt = cur;
        }
        return ans;
    }
}
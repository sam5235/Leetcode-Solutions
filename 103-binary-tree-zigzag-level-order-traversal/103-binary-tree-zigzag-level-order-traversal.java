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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> cur = new LinkedList<>();
        Queue<TreeNode> nxt = new LinkedList<>();
        Stack<Integer> st = new Stack<>();
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        cur.add(root);
        int turn = 1;
        while(!cur.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            if(turn % 2 != 0){
                while(!cur.isEmpty()){
                    TreeNode polled = cur.poll();
                    temp.add(polled.val);
                    if(polled.left != null) nxt.add(polled.left);
                    if(polled.right != null) nxt.add(polled.right);
                }
                
            }else{
                 while(!cur.isEmpty()){
                     TreeNode polled = cur.poll();
                     st.push(polled.val);
                     if(polled.left != null) nxt.add(polled.left);
                     if(polled.right != null) nxt.add(polled.right);
                 }
                while(!st.empty()){
                    temp.add(st.pop());
                }
            }
            cur = nxt;
            nxt = new LinkedList<>();
            turn++;
            ans.add(temp);
        }
        return ans;
    }
}
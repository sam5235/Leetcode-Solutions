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
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
       return whereToGo(root1, root2);
    }
     boolean whereToGo(TreeNode node1, TreeNode node2){
        if(node1 == null || node2 == null) return node1 == null && node2 == null;
        if(!sim(node1, node2)) return sim(node1,node2);
        //handling similarity [left == left && right == right]
        
        if(sim(node1.left, node2.left) && sim(node1.right, node2.right)){
           return  whereToGo(node1.left, node2.left) && whereToGo(node1.right, node2.right);
        }
        if(sim(node1.left, node2.right) && sim(node1.right, node2.left)){
             return  whereToGo(node1.left, node2.right) && whereToGo(node1.right, node2.left);
        }
         return false;
    }
    
    boolean sim(TreeNode node1, TreeNode node2){
         if(node1 == null || node2 == null) return node1 == null && node2 == null;
        return node1.val == node2.val;
    }
}
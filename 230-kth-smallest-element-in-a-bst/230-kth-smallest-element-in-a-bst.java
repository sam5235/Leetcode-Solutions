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
    public int kthSmallest(TreeNode root, int k) {
       List<Integer> ans = new ArrayList<>();
        store(root, ans);
        Collections.sort(ans);
        return  ans.get(k - 1);
    }
      void  store(TreeNode node, List<Integer> ls){
          if(node == null)  return;
           else{
               ls.add(node.val);
               store(node.left, ls);
               store(node.right, ls);
           }
    }
}
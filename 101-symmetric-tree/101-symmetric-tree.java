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
    public boolean isSymmetric(TreeNode root) {
       List<TreeNode> cur = new ArrayList<>();
       List<TreeNode> nxt = new ArrayList<>();
       cur.add(root);
       while(!cur.isEmpty()){
            if(isReverse(cur)){
                for(int i = 0; i < cur.size(); i++){
                    TreeNode polled = cur.get(i); 
                    if(polled.left == null  && polled.val != -101) nxt.add(new TreeNode(-101));
                        else if(polled.left != null) nxt.add(polled.left);
                    if(polled.right == null && polled.val != -101 ) nxt.add(new TreeNode(-101)) ;
                        else if(polled.right != null) nxt.add(polled.right);
                }
                cur = nxt;
                nxt = new ArrayList<>();
            }else return false;
          
       } 
         return true;
    }
    boolean isReverse(List<TreeNode> ls){
        int i = 0;
        int j = ls.size() - 1;
        
        while(i <= j){
            if(ls.get(i).val != ls.get(j).val){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
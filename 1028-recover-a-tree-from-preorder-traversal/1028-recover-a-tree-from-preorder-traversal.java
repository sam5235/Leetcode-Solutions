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
    public TreeNode recoverFromPreorder(String traversal) {
      List<Pair> ls = new ArrayList<>();
        int lev = 0;
        for(int i = 0; i < traversal.length(); i++){
            char c = traversal.charAt(i);
            if(c != '-'){
                StringBuilder sb = new StringBuilder();
                sb.append(c);
                i++;
                while(i < traversal.length() && traversal.charAt(i) != '-'){
                     sb.append(traversal.charAt(i));
                     i++;
                } i--;
                Pair p = new Pair(new TreeNode(Integer.parseInt(sb.toString())), lev);
                ls.add(p);
                lev = 0;
            }else lev++;
        }
        for(int i = 1; i < ls.size(); i++){
            int j = i;
            while(ls.get(j).level >= ls.get(i).level){
                j--;
            }
            if(ls.get(j).node.left == null)
                ls.get(j).node.left = ls.get(i).node;
            else ls.get(j).node.right = ls.get(i).node;
            
        }
        return ls.get(0).node;
    }
}

class Pair{
    TreeNode node;
    int level;
    Pair(TreeNode node, int level){
        this.node = node;
        this.level = level;
    }
}
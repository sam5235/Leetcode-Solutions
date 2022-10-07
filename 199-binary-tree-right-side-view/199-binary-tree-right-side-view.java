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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Queue<TreeNode> levels = new LinkedList<>();
        levels.add(root);
        if(root == null) return ans;
        while(!levels.isEmpty()){
            int size = levels.size();
            int counter = 0;
            for(int i = 0; i < size; i++){
                TreeNode node = levels.poll();
                if(counter == size - 1) ans.add(node.val);
                if(node.left != null) levels.add(node.left);
                if(node.right != null) levels.add(node.right);
                counter++;
            }
        }
        return ans;
    }
}
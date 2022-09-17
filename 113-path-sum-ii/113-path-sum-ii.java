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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ls = new ArrayList<>();
        adder(root, 0, targetSum, ls, new ArrayList<>());
        return ls;
    }
    void adder(TreeNode node,int sum, int targ,List<List<Integer>> ls, List<Integer> list){
        if(node == null) return;
        if(node.left == null && node.right == null){
            sum += node.val;
            list.add(node.val);
            if(sum == targ){
                ls.add(new ArrayList<>(list));
                
            }
            list.remove(list.size() - 1);
            return;
        }
        sum += node.val;
        list.add(node.val);
        adder(node.left, sum, targ, ls, list);
        adder(node.right, sum, targ, ls, list);
        list.remove(list.size() - 1);
    }
}
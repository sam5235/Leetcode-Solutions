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
    public int pseudoPalindromicPaths (TreeNode root) {
        int[] ans = new int[1];
        int[] arr = new int[10];
        checker(root, arr, ans);
        return ans[0];
    }
    void checker(TreeNode node, int[] arr, int[] ans){
        if(node == null) return;
        if(node.left == null && node.right == null){
            arr[node.val]++;
            if(isPseudoPalin(arr)) ans[0]++;
            arr[node.val]--;
            return;
        }
        arr[node.val]++;
        checker(node.left, arr, ans);
        checker(node.right, arr, ans);
        arr[node.val]--;

    }
    
    boolean isPseudoPalin(int[] arr){
        int one = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] % 2 != 0){
                one++;
                if(one > 1) return false;
            }
        }
        return true;
    }    
}
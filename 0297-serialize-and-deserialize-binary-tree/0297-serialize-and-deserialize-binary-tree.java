/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    int index=0;
    
    public String serialize(TreeNode root) {
        List<String> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode cur = stack.pop();
            if(cur==null){
                list.add("#");
            } else{
                list.add(cur.val+"");
                stack.push(cur.right);
                stack.push(cur.left);
            }
        }
        return String.join(",", list);
    }

    public TreeNode deserialize(String data) {
        String[] ser = data.split(",");
        return helper(ser);
    }
    public TreeNode helper(String[] arr){
        if(arr[index].equals("#"))
            return null;
        TreeNode root = new TreeNode(Integer.parseInt(arr[index]));
        index++;
        root.left = helper(arr);
        index++;
        root.right = helper(arr);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
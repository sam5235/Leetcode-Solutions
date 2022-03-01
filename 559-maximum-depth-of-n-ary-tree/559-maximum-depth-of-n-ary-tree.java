/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public int maxDepth(Node root) {
        if(root == null) return 0;
        return dfs(root, 0);
    }
    int dfs(Node node, int count){
        if(node.children.isEmpty()){
            return count+1;
        }
        int maxD = 0;
        for(int i =0; i < node.children.size(); i++){
            int depth = dfs(node.children.get(i),count+1);
           maxD =  Math.max(maxD, depth);
        }
        return maxD;
    }
}
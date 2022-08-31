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
    public List<Integer> preorder(Node root) {
        List<Integer> ls = new ArrayList<>();
        pre(root, ls);
        return ls;
    }
    void pre(Node node, List<Integer> ls){
        if(node == null) return;
            ls.add(node.val);
       for(int i = 0; i < node.children.size(); i++)
            pre(node.children.get(i), ls);
        }
    }

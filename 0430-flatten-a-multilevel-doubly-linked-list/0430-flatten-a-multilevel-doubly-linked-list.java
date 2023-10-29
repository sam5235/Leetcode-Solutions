/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) { 
        Node node = head;
        helper(node, new Stack<>());
        return head;
    }
    
    void helper(Node node, Stack<Node> st){
        if(node == null)
            return;
        if(node.child == null && node.next == null && node.prev != null){

            if(st.isEmpty())
                return;
            Node back = st.pop();
            node.next = back;
            back.prev = node;
            helper(node.next,st);
            
        }
        
            if(node.child != null){
                if(node.next != null)
                    st.push(node.next);
                node.next = node.child;
                node.child.prev = node;
                node.child = null;
            }
           helper(node.next,st);
        
    }
}

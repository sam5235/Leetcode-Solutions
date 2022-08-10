class MyLinkedList {
    Node head; 

    public MyLinkedList() {
        head = new Node();
    }
    
    public int get(int index) {
         Node temp = head.next;
          int c = 0;
        while(temp != null){
            if(index == c) return temp.val; 
            temp = temp.next;
            c++;
        }
        return -1;
    }
    
    public void addAtHead(int val) {
        Node neww = new Node(val);
        Node temp = head.next;
        head.next = null;
        head.next = neww;
        neww.next = temp;
        
    }
    
    public void addAtTail(int val) {
        Node temp = head;
        Node neww = new Node(val);
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = neww;
    }
    
    public void addAtIndex(int index, int val) {
        Node temp = head;
        Node neww = new Node(val);
        int c = 0;
        while(temp != null){
            if(index == c){
                 Node t = temp.next;
                temp.next = null;
                temp.next = neww;
                neww.next = t;
                break;
            }
            temp = temp.next;
            c++;
        }
        
    }
    
    public void deleteAtIndex(int index) {
          Node temp = head;
          int c = 0;
        while(temp != null){
            if(index == c){
                if(temp.next != null){
                temp.next = temp.next.next;
                    
                }
            break;
            } 
            temp = temp.next;
            c++;
        }
        
    }
}

class Node{
    Node next;
    int val;
    public Node(){}
    public Node(int val){
        this.val = val;
    } 
    public Node(Node next){
        this.next = next;
    } 
    public Node(int val,Node next){
        this.val = val;
        this.next = next;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
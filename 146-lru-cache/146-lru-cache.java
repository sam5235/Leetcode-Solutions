class LRUCache {
    int capacity;
    HashMap<Integer, Node> map;
    Node head, tail; 
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
       
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            remove(node);
            addHead( node);
            return node.val;
        } 
        return -1;
    }
    
    public void put(int key, int value) {
        Node node;
        if(map.size() == capacity && !map.containsKey(key)){
            map.remove(tail.key);
            remove(tail);
        }
        if(map.containsKey(key)){
            map.get(key).val = value;
            node = map.get(key);
            remove(node);
          }else{
              node = new Node(value, key);
              map.put(key, node);
          }
        addHead( node);
        
    }
    void addHead( Node node){
        if(head == null){
            head = node;
            tail = node;
        }else{
            node.next = head;
            head.prev = node;
            head = node;
            head.prev = null; 

        }
    }
    
    void remove(Node node){
          Node prev = node.prev;
          Node next = node.next;
          if(prev != null){
              prev.next = next;
              node.prev = null;
          }
          if(next != null){
              next.prev = prev;
              node.next = null;
          }
          if(head == node) head = next;
          if(tail == node) tail = prev;
        
    }
    
}
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
class Node{
    Node next;
    Node prev;
    int val;
    int key;
    
    Node(int val, int key){
        this.val = val;
        this.key = key;
    }
    boolean equals(Node node){
        return this.key == node.key;
    }

}
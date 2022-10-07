class LFUCache {
    int capacity;
    HashMap<Integer, Node> map;
    PriorityQueue<Node> pQue;
    int timer;
    public LFUCache(int capacity) {
        timer = 0;
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.pQue = new PriorityQueue<>((a,b)-> (a.freq == b.freq) ? b.time - a.time : a.freq - b.freq);
    }
    
    public int get(int key) {
        timer--;
        if(map.containsKey(key)){
            Node node = map.get(key);
            pQue.remove(node);
            node.freq++;
            node.time = timer;
            pQue.add(node);
            return node.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        timer--;
        if(capacity == 0) return;
        Node node;
        if(!map.containsKey(key) && map.size() == capacity) map.remove(pQue.poll().key);
        if(map.containsKey(key)){
            node = map.get(key);
            pQue.remove(node);
            node.val = value;
            node.freq++;
            node.time = timer;
            pQue.add(node);
        }else{
            if(!pQue.isEmpty()) node = new Node(value, key, 1,timer);
            else node = new Node(value, key, 1, timer);
            pQue.add(node);
            map.put(key, node);
        } 
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
class Node{
    int val, key, freq, time;
    
    Node(int val, int key, int freq, int time){
        this.val = val;
        this.key = key;
        this.freq = freq;
        this.time = time;
    }
}
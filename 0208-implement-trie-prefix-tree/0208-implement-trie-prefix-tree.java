class Trie {
    Node root;
    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        Node temp = root;
        for(char c : word.toCharArray()){
            int idx = c - 'a';
            if(temp.children[idx] == null) {
                temp.children[idx] = new Node();
            }
            temp = temp.children[idx]; 
        }
        temp.isEnd = true;   
    }
    
    public boolean search(String word) {
        Node temp = root;
        for(char c : word.toCharArray()){
            int idx = c - 'a';
            if(temp.children[idx] == null){
                return false;
            }
            temp = temp.children[idx];
        }
        return temp.isEnd;
        
    }
    
    public boolean startsWith(String prefix) {
         Node temp = root;
        for(char c : prefix.toCharArray()){
            int idx = c - 'a';
            if(temp.children[idx] == null){
                return false;
            }
            temp = temp.children[idx];
        }
        return true;
    }
}

class Node{
 Node[] children = new Node[26];
 boolean isEnd = false;
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
class WordDictionary {
    Node root;

    public WordDictionary() {
        root = new Node();
    }
    
    public void addWord(String word) {
        Node node = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(node.children[c - 'a'] == null){
                node.children[c - 'a'] = new Node();
            }
            node = node.children[c - 'a'];
            if(i == word.length() - 1) node.isEnd = true;            
        }
    }
    
    public boolean search(String word) {
      return searchDFS(word, root, 0);
    }
    
    boolean searchDFS(String word, Node node, int idx){
        if(node == null) return false;
        if(idx == word.length()) return node.isEnd;
        if(word.charAt(idx) != '.'){
            node = node.children[word.charAt(idx) - 'a'];
            return  searchDFS(word,node, idx+1);
        }
        else{
            boolean res = false;
            for(int i = 0; i < 26; i++){
               if(node.children[i] != null && searchDFS(word, node.children[i], idx + 1)){
                  return true;
               } 
            }
            return false;
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
class Node{
    Node[] children = new Node[26];
    boolean isEnd = false;
}
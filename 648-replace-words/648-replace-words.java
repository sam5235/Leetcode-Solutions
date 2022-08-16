class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        Node root = new Node();
        
        for(String word : dictionary){
            insert(word, root);
        }
        
        String[] str = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for(String word : str ){
      StringBuilder sbIn = new StringBuilder();
                sb.append(search (word, root, sbIn) + " ");
          
        }
     return sb.toString().trim();   
    }    
    
    public void insert(String word, Node root) {
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

    public String search(String word, Node root, StringBuilder sbIn) {
        Node temp = root;
          sbIn = new StringBuilder();
        for(char c : word.toCharArray()){
            int idx = c - 'a';
            if(temp.children[idx] == null){
                return word;
            }
            sbIn.append(c);
           
            if(temp.children[idx].isEnd) return sbIn.toString();
            temp = temp.children[idx];
        }
        return word;

    }
}

class Node{
 Node[] children = new Node[26];
 boolean isEnd = false;
}
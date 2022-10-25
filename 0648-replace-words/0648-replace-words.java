class Solution {
    Trie root = new Trie();
    public String replaceWords(List<String> dictionary, String sentence) {
        for(int i = 0; i < dictionary.size(); i++){
            buildTrie(dictionary.get(i));
        }
        String[] words = sentence.split(" ");
        StringBuilder answer = new StringBuilder();
        for(int i = 0; i < words.length; i++){
            answer.append(" " + getWord(words[i]));
        }
      return answer.toString().trim();    
    }
    String getWord(String word){
        Trie node = root;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(node.child[c - 'a'] == null)
                return word;
            sb.append(c);
            if(!node.child[c - 'a'].isEnd){
                node = node.child[c - 'a'];
            }else break;
        }
        return  sb.toString();
    }
    void buildTrie(String word){
        Trie node = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(node.child[c - 'a'] == null){
                node.child[c - 'a'] = new Trie();
            }else if(node.isEnd)
                break;
            node = node.child[c - 'a'];
        }
        node.isEnd = true;
    }
}

class Trie{
    Trie[] child = new Trie[26];
    boolean isEnd = false;
}
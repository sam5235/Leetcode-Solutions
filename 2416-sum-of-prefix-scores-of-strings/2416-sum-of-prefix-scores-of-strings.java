class Solution {
    public int[] sumPrefixScores(String[] words) {
        int[] ans = new int[words.length];
        Trie root = new Trie();
        buildTrie(root, words);
          for(int i = 0; i < words.length; i++){
              Trie node = root;
              for(int j = 0; j < words[i].length(); j++){
                int idx  = words[i].charAt(j) - 'a';
                  node = node.children[idx];                  
                  ans[i] += node.count;
              }
          }
        return ans;
        
    }
        void buildTrie(Trie root, String[] words){
         for(int i = 0; i < words.length; i++){
            Trie node = root;
            for(int j = 0; j < words[i].length(); j++){
                int idx  = words[i].charAt(j) - 'a';
                if(node.children[idx] == null){
                    node.children[idx] = new Trie();
                }
                    node = node.children[idx];
                    node.count++;
            }
         }
    }
}


class Trie{
  Trie[] children = new Trie[26];
  int count = 0;  
}
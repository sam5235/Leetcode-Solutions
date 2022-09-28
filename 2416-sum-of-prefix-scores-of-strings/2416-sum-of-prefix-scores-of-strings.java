class Solution {
    public int[] sumPrefixScores(String[] words) {
        Node root = new Node();
        for(int i = 0; i < words.length; i++){
            buildTrie(root, words[i]);
        }
        int[] ans = new int[words.length];
        for(int i = 0; i < words.length; i++){
            ans[i] = countPref(root, words[i], 0);
        }
        return ans;
    }
    
    void buildTrie(Node node, String s){
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(node.children[c - 'a'] == null){
                node.children[c - 'a'] = new Node();
            }
            node.children[c - 'a'].freq++;
            node = node.children[c - 'a'];
        }
    }
    
    int countPref(Node node, String s, int sum){
       for(int i = 0; i < s.length(); i++){
            sum += node.children[s.charAt(i) - 'a'].freq;
            node = node.children[s.charAt(i) - 'a'];
       }
        return sum;
    }
}

class Node{
 Node[] children = new Node[26];
 int freq = 0;   
}
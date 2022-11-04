class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashMap<String, List<String>> graph = new HashMap<>();
        HashSet<String> words = new HashSet<>();
        words.add(beginWord);
        graph.put(beginWord, new ArrayList<>());
        for(String s : wordList){
            words.add(s);
            graph.put(s, new ArrayList<>());
        }
        
        buildGraph(graph, words);
        
        Queue<String> nodes = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        visited.add(beginWord);
        nodes.add(beginWord);
        int ans = 1;
        while(!nodes.isEmpty()){
            ans++;
            int size = nodes.size();
            for(int iter = 0; iter < size; iter++){
                String polled = nodes.poll();
                List<String> ls = graph.get(polled);
                for(int i= 0; i < ls.size(); i++){
                    if(!visited.contains(ls.get(i))){
                        if(ls.get(i).equals(endWord)){
                           return ans;   
                        }
                        nodes.add(ls.get(i));
                        visited.add(ls.get(i));
                    }
                }
            }
        }
        return 0;
        
    }
    
    void buildGraph(HashMap<String, List<String>> graph, HashSet<String> words){
        for(String curr : words){
            for(int i = 0; i < curr.length(); i++){
                for(int letter = 0; letter < 26; letter++){
                    String newS = transWord(curr, i, letter);
                    if(words.contains(newS)){
                          List<String> ls = graph.get(curr);
                          ls.add(newS);
                          graph.put(curr, ls);
                    }
                }
            }
        }
    }
    
    
    String transWord(String orig, int idx, int ch){
        char[] word = orig.toCharArray();
        
        word[idx] = (char)(97 + ch);
        return new String(word);
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        wordList.add(beginWord);
        HashSet<String> dictionary = new HashSet<>(wordList);
        HashMap<String, List<String>> graph = new HashMap<>();
        for(String word : dictionary){
            char[] str = word.toCharArray();
            char[] org = word.toCharArray();
            List<String> nxt = new ArrayList<>();
            for(int i = 0; i < str.length; i++){
                for(char c = 'a'; c <= 'z';c++){
                    str[i] = c;
                    String maybe  = new String(str);
                    if(dictionary.contains(maybe) && !maybe.equals(word)){
                        nxt.add(maybe);
                    }
                }
                str[i] = org[i];
            }
            graph.put(word, nxt);
        }
        
        HashSet<String> visited = new HashSet<>();
        Queue<String> cur = new LinkedList<>();
        cur.add(beginWord);
        visited.add(beginWord);
        int level =1;
        while(!cur.isEmpty()){
            int size = cur.size();
            for(int i = 0; i < size; i++){
                String polled = cur.poll();
                if(polled.equals(endWord)){
                   return level; 
                }else{
                    for(String temp :graph.get(polled)){
                        if(!visited.contains(temp)){
                        cur.add(temp); 
                        visited.add(temp);
                        } 
                    }   
                }
            }
               level++;
        }
        return 0;
    }
}

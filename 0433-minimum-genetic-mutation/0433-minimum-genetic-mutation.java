class Solution {
    public int minMutation(String start, String end, String[] b) {
        HashSet<String> bankSet = new HashSet<>();
        String[] bank = new String[b.length + 1];
        bank[0] = start;
        for(int i = 0; i < b.length; i++){
            bank[i + 1] = b[i];
        }
        for(String s : bank)
            bankSet.add(s);
        HashMap<String, List<String>> graph = new HashMap<>();
        char[] gene = {'A', 'T','G', 'C'};
        for(String s : bank){
            graph.put(s, new ArrayList<>());
        }
        for(int k = 0; k < bank.length; k++){
            String curr = bank[k];
            for(int i = 0; i < 8; i++){
                for(int j = 0; j < 4; j++){
                    char[] sub = curr.toCharArray();
                    sub[i] = gene[j];
                    String newS = new String(sub);
                    if(bankSet.contains(newS)){
                        List<String> ls = graph.get(curr);
                        ls.add(newS);
                        graph.put(curr, ls);
                    }
                }
            }            
        }
        HashSet<String> visited = new HashSet<>();
        Queue<String> bfs = new LinkedList<>();
        bfs.add(start);
        int ans = 0;
        while(!bfs.isEmpty()){
            int size = bfs.size();
            ans++;
            for(int i = 0; i < size; i++){
                String polled = bfs.poll();
                List<String> ls= graph.get(polled);
                for(int s = 0; s < ls.size(); s++){
                    if(!visited.contains(ls.get(s))){
                        if(ls.get(s).equals(end))
                        return ans;
                        bfs.add(ls.get(s));
                        visited.add(ls.get(s));
                    }
                }                
            }
        }
        return -1;
    }
    
}
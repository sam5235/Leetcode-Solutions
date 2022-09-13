class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        Queue<Integer> curr = new LinkedList<>();
        int[] roots = new int[n + 1];
        for(int i = 0; i < dislikes.length; i++){
            List<Integer> ls = map.getOrDefault(dislikes[i][0], new ArrayList<>());
            ls.add(dislikes[i][1]);
            map.put(dislikes[i][0], ls);
            List<Integer> lis = map.getOrDefault(dislikes[i][1], new ArrayList<>());
            lis.add(dislikes[i][0]);
            map.put(dislikes[i][1], lis);
        }
        for(int i = 1; i <= n; i++){
            if(!set.contains(i)){
                roots[i] = 1;
                curr.add(i);
                set.add(i);
                while(!curr.isEmpty()){
                    int polled = curr.poll();
                    for(int j = 0; map.containsKey(polled) && j < map.get(polled).size(); j++){
                        int next = map.get(polled).get(j);
                        if(roots[next] == roots[polled]) return false;
                        if(!set.contains(next)){
                        if(roots[next] == 0){
                            roots[next] = roots[polled] == 1? 2 : 1;
                        }
                        curr.add(next);
                        set.add(next);    
                          }
                    }
                }
            }
        }
       
        
        return true;
    }
}
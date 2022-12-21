class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        int[] roots = new int[n + 1];
        
        for(int i = 0; i < n +1; i++)
            roots[i] = i;
        
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for(int i = 0; i < dislikes.length; i++){
            List<Integer> ls = graph.getOrDefault(dislikes[i][0], new ArrayList<>());
            ls.add(dislikes[i][1]);
            graph.put(dislikes[i][0], ls);
            ls = graph.getOrDefault(dislikes[i][1], new ArrayList<>());
            ls.add(dislikes[i][0]);
            graph.put(dislikes[i][1], ls);
            
        }
        
        for(int key : graph.keySet()){
            for(int i = 0; i < graph.get(key).size(); i++){
                if(find(roots, key) != find(roots, graph.get(key).get(i)))
                    union(roots, graph.get(key).get(0), graph.get(key).get(i));
                else return false;
            }
        }
        return true;
    }
    
    void union(int[] roots, int a, int b){
             int rootA = find(roots, a);
             int rootB = find(roots, b);
             roots[rootB] = roots[rootA];
    }
    
    int find(int[] roots, int a){
        if(roots[a] == a)
            return a;
        return roots[a] = find(roots, roots[a]);
    }
}


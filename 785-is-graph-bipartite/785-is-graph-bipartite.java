class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int[] roots = new int[n];
        for(int i = 0; i < n; i++) roots[i] = i;
        for(int i = 0; i < n; i++){
            map.put(i, new ArrayList<>());
        }
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < graph[i].length; j++){
                map.get(i).add(graph[i][j]);
            }
        }
        for(int key : map.keySet()){
            List<Integer> ls = map.get(key);
            for(int i = 0; i < ls.size(); i++){
                if(find(roots, key) == find(roots, ls.get(i))) return false;
            }
            
            for(int i = 0; i < ls.size(); i++){
                int r = find(roots, ls.get(0));
                union(roots, r, ls.get(i));
            }
        }
        return true;
    }
    
    void union(int[] roots, int a, int b){
        int rootA = find(roots, a);
        int rootB = find(roots, b);
        roots[rootB] = rootA;
    }
    
    int find(int[] roots, int node){
        if(roots[node] == node) return node;
        int myRoot = find(roots, roots[node]);
        roots[node] = myRoot;
        return myRoot;
    }
}
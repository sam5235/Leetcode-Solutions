class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        if(dislikes.length == 0) return true;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        Queue<Integer> curr = new LinkedList<>();
        int[] roots = new int[n + 1];
        for(int i = 0; i < roots.length; i++) roots[i] = i;
        for(int i = 1; i <= n; i++){
            map.put(i, new ArrayList<>());
        }
        for(int i = 0; i < dislikes.length; i++){
            int a = dislikes[i][0];
            int b = dislikes[i][1];
            map.get(a).add(b);
            map.get(b).add(a);
        }
        
        for(int key : map.keySet()){
            List<Integer> ls = map.get(key);
            for(int i = 0; i < ls.size(); i++){
                if(find(roots,key) == find(roots,ls.get(i))) return false;
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
class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int[] ans = new int[2];
        int[] roots = new int[edges.length + 1];
        for(int i = 0; i < roots.length; i++) roots[i] = i;
        for(int i = 0; i < edges.length; i++){
            if(!union(roots, edges[i][0], edges[i][1])){
                ans[0] = edges[i][0];
                ans[1] = edges[i][1];
            }
        }
        return ans;
        
    }
    
    boolean union(int[] roots, int a, int b){
        int rootA = find(roots, a);
        int rootB = find(roots, b);
        
        if(rootA == rootB) return false;
        roots[rootB] = rootA;
        return true;
    }
    
    int find(int[] roots, int node){
        if(roots[node] == node) return node;
        int myRoot = find(roots, roots[node]);
        roots[node] = myRoot;
        return myRoot;
    }
}
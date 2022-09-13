class Solution {
    public boolean equationsPossible(String[] equations){
        int n = equations.length;
        int[] roots = new int[26];
        for(int i = 0; i < 26; i++) roots[i] = i;
        for(int i = 0; i < n; i++){
            if(equations[i].charAt(1) == '='){
               int fir = equations[i].charAt(0) - 'a';
               int sec = equations[i].charAt(3) - 'a';
               union(roots, fir, sec);
            }
        }
        for(int i = 0; i < n; i++){
             if(equations[i].charAt(1) == '!'){
                 int fir = equations[i].charAt(0) - 'a';
                 int sec = equations[i].charAt(3) - 'a';
                 if(find(roots, fir) == find(roots, sec)) return false;
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
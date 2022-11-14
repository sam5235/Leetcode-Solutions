class Solution {
    public int removeStones(int[][] stones) {
        int[] roots = new int[stones.length];
        for(int i = 0; i < stones.length; i++){
            roots[i] = i;
        }

        for(int i = 0; i < stones.length; i++){
            for(int j = i + 1; j < stones.length; j++){
                if(stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]){
                    union(roots, i , j);
                    
                }
            }
        }
        int ans = 0;
        for(int i = 0; i < roots.length; i++){
            if(i != find(roots, i))
               ans++;
        }
        return ans;
        
    }
    
    void union(int[] roots, int a, int b){
        int rootA = find(roots, a);
        int rootB = find(roots, b);
        roots[rootB] = rootA;
    }
    
    int find(int[]roots, int a){
        if(roots[a] == a)
            return a;
        int curr = find(roots, roots[a]);
        return roots[a] = curr;
    }
}
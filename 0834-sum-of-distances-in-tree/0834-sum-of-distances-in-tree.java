class Solution {
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        ArrayList<Integer>[] graph= new ArrayList[n];
        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < edges.length; i++){
            graph[edges[i][0]].add(edges[i][1]);
            graph[edges[i][1]].add(edges[i][0]);
        }
        graph[0].add(0);
        
        int[] dist = new int[1];
        rootDist(graph, new boolean[n], 0, dist , 1);
        int[] values = new int[n];
        nodes(graph, new boolean[n], values, 0);
        int[] ans = new int[n];
        soln(graph, new boolean[n], values,ans,0, n, -1, dist[0]);

        return ans;
    }
    
    void rootDist(ArrayList<Integer>[] graph, boolean[] boolArr, int idx, int[] dist, int cnt){
        if(boolArr[idx])
            return;
        boolArr[idx] = true;
        dist[0] += (cnt) *(graph[idx].size() - 1);
            for(int i = 0; i < graph[idx].size(); i++){
                rootDist(graph, boolArr, graph[idx].get(i), dist, cnt + 1);
            }
    }
    
    int nodes(ArrayList<Integer>[] graph, boolean[] boolArr, int[] values, int idx){
        if(boolArr[idx])
            return 0;
        if(graph[idx].size() == 1)
            return values[idx] = 1;
        boolArr[idx] = true;
        int curr = 1;
        for(int i = 0; i < graph[idx].size(); i++){
            curr += nodes(graph, boolArr,values, graph[idx].get(i));
            
        }
        return values[idx] = curr;
    }
        
    void soln(ArrayList<Integer>[] graph, boolean[] boolArr,int[] values, int[] ans, int idx, int n, int par, int dist){
        if(boolArr[idx])
            return;
        boolArr[idx] = true;
        ans[idx] = par == -1? dist : par + (n - values[idx]) - values[idx];
        for(int i = 0; i < graph[idx].size(); i++){
            soln(graph, boolArr, values, ans, graph[idx].get(i), n, ans[idx], dist);
        }
    }
       
}
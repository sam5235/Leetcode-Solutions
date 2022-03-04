class Solution {
    public int findCircleNum(int[][] isConnected) {
        HashSet<Integer> set = new HashSet<>();
        int count = 0;
        for(int i = 0; i < isConnected.length; i++){
            if(!set.contains(i)){
                dfs(isConnected, set, i);
                count++;   
            }
        }
        return count;
    }
    void dfs(int[][] graph, HashSet<Integer> set, int node){
        set.add(node);
        int[] connected = graph[node];
        for(int i = 0; i < connected.length; i++){
            if(!set.contains(i) && connected[i] == 1){
                dfs(graph, set, i);
            }
        }
    }
}
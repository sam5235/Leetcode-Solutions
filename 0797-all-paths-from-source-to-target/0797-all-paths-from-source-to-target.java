class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(graph, ans, 0, new ArrayList<>());
        return ans;
    }
    
    void dfs(int[][] graph, List<List<Integer>> ans, int idx, List<Integer> ls){
        ls.add(idx);
        if(idx == graph.length - 1){
            ans.add(new ArrayList<>(ls));
            ls.remove(ls.size() - 1);
            return;
        }
        
        for(int i = 0; i < graph[idx].length; i++){
            dfs(graph, ans, graph[idx][i], ls);
        }
        ls.remove(ls.size() - 1);
        return;
    }
}
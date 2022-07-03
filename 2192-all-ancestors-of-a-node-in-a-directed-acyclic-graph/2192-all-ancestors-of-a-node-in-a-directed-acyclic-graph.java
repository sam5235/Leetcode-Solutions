class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
        HashMap<Integer, Integer> incoming = new HashMap<>();
        for(int i = 0; i < edges.length; i++){
            ArrayList<Integer> elem = graph.getOrDefault(edges[i][0], new ArrayList<>());
            elem.add(edges[i][1]);
            graph.put(edges[i][0], elem);
            incoming.put(edges[i][1], incoming.getOrDefault(edges[i][1], 0) + 1);
        }
           
        Queue<Integer> processed = new LinkedList<>();
        for(int i  = 0; i < n; i++){
            if(!incoming.containsKey(i)) processed.add(i);
        }
        
        List<TreeSet<Integer>> currAns = new ArrayList<>();
        for(int i = 0; i < n; i++){
            TreeSet<Integer> curr = new TreeSet<>();
            currAns.add(curr);
        }
        
        while(!processed.isEmpty()){
            int polled = processed.poll();
            if(graph.containsKey(polled)){
                for(int child : graph.get(polled)){
                        currAns.get(child).add(polled);   
                        incoming.put(child, incoming.get(child) - 1);
                        currAns.get(child).addAll(currAns.get(polled));    
                    if(incoming.get(child) == 0) processed.add(child);
                }
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        for(TreeSet<Integer> ts : currAns){
            ans.add(new ArrayList<>(ts));
        }
        
        return ans;
    }
}
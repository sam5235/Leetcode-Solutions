class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        HashMap<Integer, List<Integer>> tree = new HashMap<>();
        for(int i = 0; i < edges.length; i++){
            List<Integer> ls = tree.getOrDefault(edges[i][0], new ArrayList<>());
            ls.add(edges[i][1]);
            tree.put(edges[i][0], ls);
            ls = tree.getOrDefault(edges[i][1], new ArrayList<>());
            ls.add(edges[i][0]);
            tree.put(edges[i][1], ls);
        }
        return apple(tree, hasApple, new HashSet<>(), 0);
    }
    
    int apple(HashMap<Integer, List<Integer>> tree, List<Boolean> hasApple, HashSet<Integer> seen, int node){
        if(tree.get(node).size() == 1 && seen.contains(tree.get(node)))
            return hasApple.get(node)? 2 : 0;
        seen.add(node);
        List<Integer> nxt = tree.get(node);
        int now = 0;
        for(int i = 0; i < nxt.size(); i++){
            if(!seen.contains(nxt.get(i))){
               now += apple(tree, hasApple, seen, nxt.get(i));
            }
        }
        return (hasApple.get(node) || now > 0) && node != 0? now + 2 : now;
    }
   
}
class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
       List<Integer> ls = new ArrayList<>();
       HashSet<Integer> ingoing = new HashSet<>();
        for(int i = 0; i < edges.size(); i++){
            ingoing.add(edges.get(i).get(1));
        }
        for(int i = 0; i < n; i++){
            if(!ingoing.contains(i)) ls.add(i);
        }
        return ls;
    }
}
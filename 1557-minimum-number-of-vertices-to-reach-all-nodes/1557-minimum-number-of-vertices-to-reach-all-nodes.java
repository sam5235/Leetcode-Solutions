class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
       List<Integer> ls = new ArrayList<>();
       HashMap<Integer,List<Integer>> ingoing = new HashMap<>();
        for(int i = 0; i < edges.size(); i++){
            List<Integer> list = ingoing.getOrDefault(edges.get(i).get(1), new ArrayList<>());
            list.add(edges.get(i).get(0));
            ingoing.put(edges.get(i).get(1), list);
        }
        for(int i = 0; i < n; i++){
            if(!ingoing.containsKey(i)) ls.add(i);
        }
        return ls;
    }
}
class Solution {
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        HashMap<Integer, List<Integer>> tree = new HashMap<>();
        for(int i = 0; i < edges.length; i++){
            List<Integer> ls = tree.getOrDefault(edges[i][0], new ArrayList<>());
            ls.add(edges[i][1]);
            tree.put(edges[i][0], ls);
            ls = tree.getOrDefault(edges[i][1], new ArrayList<>());
            ls.add(edges[i][0]);
            tree.put(edges[i][1], ls);
            
        }
        int[] ans = new int[n];
        label(tree, new HashSet<>(), 0, labels, ans);
        return ans;   
    }
    
    HashMap<Character, Integer> label(HashMap<Integer, List<Integer>> tree, HashSet<Integer> seen, int node,  String labels, int[] ans){
        HashMap<Character, Integer> hash1 = new HashMap<>();
        if(tree.get(node).size() == 1 && seen.contains(tree.get(node).get(0))){
            hash1.put(labels.charAt(node), 1);
            ans[node] = 1;
            return hash1;
        }
        seen.add(node);
        List<Integer> nxt = tree.get(node);
        for(int i = 0; i < nxt.size(); i++){
            if(!seen.contains(nxt.get(i))){
                hash1 = merge(hash1, label(tree, seen, nxt.get(i), labels, ans));
            }
        }
        hash1.put(labels.charAt(node), hash1.getOrDefault(labels.charAt(node),0) + 1);
        ans[node] = hash1.get(labels.charAt(node));
     
        return hash1;
    }
    
    HashMap<Character, Integer> merge(HashMap<Character, Integer> hash1, HashMap<Character, Integer> hash2){

        for(char key : hash2.keySet()){
            int freq = hash1.getOrDefault(key, 0) + hash2.get(key);
            hash1.put(key, freq);
        }
        return hash1;
    }
}
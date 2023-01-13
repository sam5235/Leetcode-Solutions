class Solution {
    public int longestPath(int[] parent, String s) {
        HashMap<Integer, List<Integer>> tree = new HashMap<>();
        for(int i = 1; i < parent.length; i++){
            List<Integer> ls = tree.getOrDefault(parent[i], new ArrayList<>());
            ls.add(i);
            tree.put(parent[i], ls);
            ls = tree.getOrDefault(i, new ArrayList<>());
            ls.add(parent[i]);
            tree.put(i, ls);
        }
        
        int[] max = new int[1];
        path(tree, s, new HashSet<>(), max, 0);
        return max[0];
    }
   
    Pair path(HashMap<Integer, List<Integer>> tree, String s, HashSet<Integer> seen, int[] max, int node){
        if(tree.isEmpty() || (tree.get(node).size() == 1 && seen.contains(tree.get(node).get(0)))){
            max[0] = Math.max(max[0],1);
            return new Pair(s.charAt(node), 1);
        }
        seen.add(node);
        List<Integer> ls = tree.get(node);
        int firMax = 0;
        int secMax = 0;
        for(int i = 0; i < ls.size(); i++){
            Pair now = new Pair();
            if(!seen.contains(ls.get(i))){
                now = path(tree, s, seen, max, ls.get(i));
            }
            if(s.charAt(node) != now.c){
                
                if(firMax < now.val){
                    secMax = firMax;
                    firMax = now.val;
                }
                else if(secMax < now.val){
                    secMax = now.val;
                }
            }else max[0] = Math.max(max[0], now.val);
            
        }
        max[0] = Math.max(max[0], (firMax + secMax + 1));
        return new Pair(s.charAt(node), firMax + 1);
            
    }
    
}

class Pair{
    char c;
    int val;
    Pair(){}
    Pair(char c, int val){
        this.c = c;
        this.val = val;
    }
}
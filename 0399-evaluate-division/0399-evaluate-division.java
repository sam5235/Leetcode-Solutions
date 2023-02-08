class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String, List<Pair>> graph = new HashMap<>();
        int n = equations.size();
        for(int i = 0; i < n; i++){
            List<Pair> ls= graph.getOrDefault(equations.get(i).get(0), new ArrayList<>());
            ls.add(new Pair(equations.get(i).get(1), values[i]));
            graph.put(equations.get(i).get(0), ls);
            ls= graph.getOrDefault(equations.get(i).get(1), new ArrayList<>());
            ls.add(new Pair(equations.get(i).get(0), (1.0 / values[i])));
            graph.put(equations.get(i).get(1), ls);
            
        }
        double[] ans = new double[queries.size()];
        for(int i = 0; i < queries.size(); i++){
            ans[i] = calc(graph, new HashSet<>(), 1, queries.get(i).get(0), queries.get(i).get(1));
        }
        
        
        return ans ;
    }
    double calc(HashMap<String, List<Pair>> graph,HashSet<String> seen, double prod, String num, String denu){
        seen.add(num);
        if(num.equals(denu) && graph.containsKey(num))
            return prod;
        if(!graph.containsKey(num))
            return -1.0;
        List<Pair> curr = graph.get(num);
        for(int i = 0; i < curr.size(); i++){
            Pair p = curr.get(i);
            double nxt = -1;
            if(!seen.contains(p.var)){
                nxt = calc(graph, seen, prod * p.val, p.var, denu);
            }
            
            if(nxt != -1)
                return nxt;
        }
        seen.remove(num);
        return -1.0;
        
    }
}

class Pair {
    String var;
    double val;
    Pair(String var, double val){
        this.var = var;
        this.val = val;
    }
    public String toString(){
        return var + "::" + val;
    }
}
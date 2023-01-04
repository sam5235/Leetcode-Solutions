class Solution {
    public int maxStarSum(int[] vals, int[][] edges, int k) {
        int max = Integer.MIN_VALUE;

        for(int v : vals)
                max = Math.max(max, v);
        
        HashMap<Integer, List<Integer>> stars = new HashMap<>();
        for(int i  = 0; i < edges.length; i++){
            List<Integer> ls = stars.getOrDefault(edges[i][0], new ArrayList<>());
            ls.add(vals[edges[i][1]]);
            stars.put(edges[i][0],ls);
            ls = stars.getOrDefault(edges[i][1], new ArrayList<>());
            ls.add(vals[edges[i][0]]);
            stars.put(edges[i][1],ls);
            
        }
            
        for(int key : stars.keySet()){
            Collections.sort(stars.get(key));
            max = Math.max(max,max(stars.get(key), k) + vals[key]);
            
        }
        
           
        return max; 
    }
    
 
    
    int max(List<Integer> ls, int k){
        int max = 0;
        for(int i = ls.size() - 1; i >= 0 && k > 0; i--){
            int val = ls.get(i);
            if(val > 0){
                max +=  val;
                k--;
            }
          }
            
        return max;
    }
    
}
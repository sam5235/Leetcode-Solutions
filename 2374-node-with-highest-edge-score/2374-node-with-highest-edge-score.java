class Solution {
    public int edgeScore(int[] edges) {
        HashMap<Integer, Long> map = new HashMap<>();
        for(int i = 0; i < edges.length; i++){
            long sum = map.getOrDefault(edges[i], (long)0) + (long)i;
            map.put(edges[i], sum);
        }
        System.out.println(map);
        long max = 0;
        int ans = edges.length + 1;
        for(int key : map.keySet()){
            max = Math.max(max, map.get(key));
        }
        for(int i = 0; i <edges.length; i++){
            if(map.get(edges[i]) == max){
                ans = Math.min(ans, edges[i]);
            }
        }
        return ans;
    }
}

class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int n = adjacentPairs.length;
        for(int i = 0; i < n; i++){
            List<Integer> ls = map.getOrDefault(adjacentPairs[i][0], new ArrayList<>());
            ls.add(adjacentPairs[i][1]);
            map.put(adjacentPairs[i][0], ls);
            ls = map.getOrDefault(adjacentPairs[i][1], new ArrayList<>());
            ls.add(adjacentPairs[i][0]);
            map.put(adjacentPairs[i][1], ls);
        }
        int[] ans = new int[n + 1];
        int fir = 0;
        for(int key : map.keySet()){
            if(map.get(key).size() == 1){
                fir = key;
                break;
            }
        }
        ans[0] = fir;
        ans[1] = map.get(fir).get(0);
        int curr = ans[1];
        int i = 2;
        HashSet<Integer> seen = new HashSet<>();
        seen.add(ans[0]);
        seen.add(ans[1]);
       while(map.get(curr).size() > 1){
           if(!seen.contains(map.get(curr).get(0))){
               ans[i] = map.get(curr).get(0);
               seen.add(map.get(curr).get(0));
               curr = map.get(curr).get(0);
           }
           else {
               ans[i] = map.get(curr).get(1);
               seen.add(map.get(curr).get(1));
               curr = map.get(curr).get(1);
           }
            i++;
       }
        ans[n] = curr;
       return ans;
    }
}
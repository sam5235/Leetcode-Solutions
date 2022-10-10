class Solution {
    public int minimumOperations(int[] nums) {
        PriorityQueue<List<Integer>> heap1 = new PriorityQueue<>((a,b)-> b.get(1) - a.get(1));
        PriorityQueue<List<Integer>> heap2 = new PriorityQueue<>((a,b)-> b.get(1) - a.get(1));
        HashMap<Integer, Integer> map1 = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();
        int n = nums.length;
        
        for(int i = 0; i < n; i+=2){
            int freq = map1.getOrDefault(nums[i], 0) + 1;
            map1.put(nums[i], freq);
                 }
        
        for(int i = 1; i < n; i+=2){
            int freq = map2.getOrDefault(nums[i], 0) + 1;
            map2.put(nums[i], freq);
        }
        
        
        for(int key : map1.keySet()){
            heap1.add(new ArrayList<>(Arrays.asList(key, map1.get(key))));
        }
        
        for(int key : map2.keySet()){
            heap2.add(new ArrayList<>(Arrays.asList(key, map2.get(key))));
        }
         int first = (!heap1.isEmpty()) ? heap1.poll().get(0) : 0;
         int second = (!heap2.isEmpty()) ? heap2.poll().get(0) : 0;
        if(first != second ) return (n - map1.getOrDefault(first, 0) - map2.getOrDefault(second, 0));
        
        
      
        int ans = 0;
        int nxtfirst = (!heap1.isEmpty()) ? heap1.peek().get(1) : 0;
        int nxtsecond = (!heap2.isEmpty()) ? heap2.peek().get(1) : 0;
        ans  = n - Math.max(map1.getOrDefault(first, 0) + nxtsecond, map2.getOrDefault(second,0) + nxtfirst);
        return ans;
    }
}
class Solution {
    public int[] topKFrequent(int[] nums, int k) { 
        
        int [] ans = new int[k];
        Map<Integer, Integer> freq = new HashMap<>();
        for(int num : nums){
            int fq = freq.getOrDefault(num, 0) + 1;
            freq.put(num, fq);
        }
        Queue<Count> q = new PriorityQueue<>((a,b) -> b.val - a.val);
        for(Map.Entry<Integer, Integer> entry : freq.entrySet()){
            int key = entry.getKey();
            int val = entry.getValue();
            Count count = new Count(key, val);
            q.add(count);
        }
        for (int i = 0; i < k; i++){
            ans[i] = q.poll().key;
        }
        return ans;
        
        
    }
    class Count{
        int key;
        int val;
        public Count (int key, int val){
        this.key = key;
        this.val = val;
        }
    }
}
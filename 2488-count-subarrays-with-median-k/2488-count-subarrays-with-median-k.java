class Solution {
    public int countSubarrays(int[] nums, int k) {
        HashMap<Integer, Integer> comp = new HashMap<>();
        int idx = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == k){
                idx = i;
                break;
            }
        }
        int less = 0;
        int great = 0;
        comp.put(great - less, 1);        
        for(int i = idx - 1; i >= 0; i--){
            if(nums[i] > k)
                great++;
            else less++;
            int freq = comp.getOrDefault(great - less, 0) + 1;
            comp.put(great - less, freq);
            
        }
        int ans = 0;
        less = 0;
        great = 0;
        for(int i = idx; i < nums.length; i++){
            if(nums[i] > k)
                great++;
            else if(nums[i] < k)
             less++;
            if(comp.containsKey((great - less) * -1))
                ans += comp.get((great - less) * -1);
            if(comp.containsKey(((great - less) * -1) + 1))
                ans += comp.get(((great - less) * -1) + 1);
        }
        
        return ans;
    }
}
class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer,Integer> subArr = new HashMap<>();
        int n = nums.length;
        int sum = 0;
        subArr.put(0, 1);
        int cnt = 0;
        
        
        for(int i = 0; i < n; i++){
              sum += nums[i];
             int mod = (sum % k);
            if(subArr.containsKey(mod) ){
                cnt += subArr.get(mod);
            }
            
            subArr.put(mod, (subArr.getOrDefault(mod, 0) + 1));
            cnt += subArr.getOrDefault((mod - k), 0);
            cnt += subArr.getOrDefault((mod + k), 0);
            
            
        }
        return cnt;
    }
}

     
     

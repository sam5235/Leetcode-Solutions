class Solution {
    
    public int longestArithSeqLength(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer>[] dp = new HashMap[n];
        int maxValue = 1;
        
        for(int i=0;i<n;i++){
            int currElement = nums[i];
            dp[i] = new HashMap<>();
            HashMap<Integer, Integer> currMap = dp[i];
            
            for(int j=0;j<i;j++){
                int diff = nums[i] - nums[j];
                HashMap<Integer, Integer> prevMap = dp[j];
                int newValue = prevMap.getOrDefault(diff, 0)+1;
                currMap.put(diff, newValue);
                dp[i] = currMap;
                maxValue = Math.max(maxValue, newValue);
            }
        }
        return maxValue+1;
    }
}
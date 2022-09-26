class Solution {
    public int lengthOfLIS(int[] nums) {
        int max = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            max = Math.max(max, maxSub(nums, i, map));
        }
        return max;
        
    }
    int maxSub(int[] nums, int idx, HashMap<Integer, Integer> memo){
        if(idx == nums.length - 1){
            return 1;
        }
        if(memo.containsKey(idx)){
            return memo.get(idx);
        }
        int max = 1;
        for(int i = nums.length - 1; i >= idx + 1; i--){
            if(nums[idx] < nums[i]){
                 max = Math.max(max, 1 + maxSub(nums, i, memo));
            }
        }
        memo.put(idx, max);
        return max;
    }
}
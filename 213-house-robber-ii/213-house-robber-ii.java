class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        int max = Math.max(fun(nums,new HashMap<>(), 0,nums.length - 1), fun(nums,new HashMap<>(), 1,nums.length));
        return Math.max(max, fun(nums,new HashMap<>(), 2,nums.length ) );
    }
    int fun(int[] nums, HashMap<Integer, Integer> memo, int idx, int limit){
        if(idx >= limit) return 0;
        if(memo.containsKey(idx)) return memo.get(idx);
        int fIdx = nums[idx] +  Math.max(fun(nums, memo, idx + 2, limit), fun(nums, memo, idx + 3, limit));
        memo.put(idx, fIdx);
        return fIdx;
    }
}
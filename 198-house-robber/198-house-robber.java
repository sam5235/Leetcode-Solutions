class Solution {
    public int rob(int[] nums) {
        HashMap<Integer, Integer> memo = new HashMap<>();
        return Math.max(fun(nums, memo, 0), fun(nums,memo, 1));
    }
    int fun(int[] nums, HashMap<Integer, Integer> memo, int idx){
        if(idx >= nums.length) return 0;
        if(memo.containsKey(idx)) return memo.get(idx);
        int i = idx + 2;
        int fIdx = Math.max(fun(nums, memo, i), fun(nums, memo, i + 1));
        fIdx = fIdx + nums[idx];
        memo.put(idx, fIdx);
        return fIdx;
    }
}


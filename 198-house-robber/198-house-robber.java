class Solution {
    public int rob(int[] nums) {
        HashMap<Integer, Integer> memo = new HashMap<>();
        return Math.max(fun(nums, memo, 0), fun(nums,memo, 1));
    }
    int fun(int[] nums, HashMap<Integer, Integer> memo, int idx){
        if(idx >= nums.length) return 0;
        if(memo.containsKey(idx)) return memo.get(idx);
        int fIdx = 0;
        int i = idx + 2;
        while(i < nums.length){
            fIdx = Math.max(fIdx, fun(nums, memo, i));
            i++;
        }
        fIdx = fIdx + nums[idx];
        memo.put(idx, fIdx);
        return fIdx;
    }
}


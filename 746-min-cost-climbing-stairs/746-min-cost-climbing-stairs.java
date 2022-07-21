class Solution {
    public int minCostClimbingStairs(int[] cost) {
        HashMap<Integer, Integer> memo = new HashMap<>();
        return Math.min(fun(cost,memo, 0), fun(cost,memo,1));
    }
    int fun(int[] cost, HashMap<Integer, Integer> memo, int idx){
        if(idx >= cost.length) return 0;
        if(memo.containsKey(idx)) return memo.get(idx);
        int fIdx = cost[idx] + Math.min(fun(cost, memo, idx + 1), fun(cost, memo, idx + 2));
        memo.put(idx, fIdx);
        return fIdx;
    }
}

class Solution {
    public int maxProfit(int[] prices) {
        int ans = 0;
        int[][] memo = new int[2][prices.length];
        Arrays.fill(memo[0], -1);
        Arrays.fill(memo[1], -1);
        for(int i = 0; i < prices.length; i++){
            ans = Math.max(ans, helper(0, prices, i,memo));
        }
        return ans;
        
    }
    int helper(int state, int[] prices, int idx, int[][] memo){
        int nxt = state == 0 ? 1 : 0;
        if(idx == prices.length - 1)
            return state == 0 ? 0 :prices[idx];
        if(memo[state][idx] > -1)
            return memo[state][idx];
        int res = 0;
        for(int i = idx + 1 ;i < prices.length && nxt == 1; i++){
            res = Math.max(res,(-1*prices[idx]) + helper(nxt, prices, i, memo));
        }
        if(state == 1)
            res += (prices[idx]);
        for(int i = idx + 2; i < prices.length && nxt == 0; i++){
            res = Math.max(res,(prices[idx]) + helper(nxt, prices, i, memo));
        }
        memo[state][idx] = res;
        return res;
        }
    
}
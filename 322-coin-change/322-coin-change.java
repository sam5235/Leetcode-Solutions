class Solution {
    public int coinChange(int[] coins, int amount) {
        int ans = dp(coins, amount, new HashMap<>());
        return ans != 100000 ? ans : -1;
    }
    int dp(int[] coins, int amount, HashMap<Integer, Integer> memo){
            if(amount == 0) return 0;
            if(memo.containsKey(amount)) return memo.get(amount);
             int min = 100000;
            for(int i = 0; i < coins.length; i++){
                if(amount - coins[i] >= 0){
                    min = Math.min(min, dp(coins, amount - coins[i], memo) + 1);
                }
            }
                memo.put(amount, min);
                return memo.get(amount);
    }
}
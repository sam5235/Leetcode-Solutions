class Solution {
    public int tribonacci(int n) {
        HashMap<Integer, Integer> memo = new HashMap<>();
        memo.put(0, 0);
        memo.put(1,1);
        memo.put(2,1);

        return dfs(n, memo);
    }
    int dfs(int n, HashMap<Integer, Integer> memo){
        if(n < 0)
            return 0;
        if(memo.containsKey(n))
            return memo.get(n);
        int curr = dfs(n - 1, memo) + dfs(n - 2, memo) + dfs(n - 3, memo);
        memo.put(n, curr);
        return curr;
    }
}
class Solution {
    public int climbStairs(int n) {
        HashMap<Integer, Integer> memo = new HashMap<>();
       return fun(n,memo);
    }
 int fun(int n, HashMap<Integer, Integer> memo){
     if(n == 1 || n == 0) return 1;
     if(memo.containsKey(n)) return memo.get(n);
     int fn = fun(n - 1, memo) + fun(n - 2, memo);
     memo.put(n, fn);
     return fn;
 }
}

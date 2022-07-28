class Solution {
    public int numDecodings(String s) {
        
        return dp(s, new HashMap<Integer, Integer>(), 0);
    }
    int dp(String s, HashMap<Integer, Integer> memo, int idx){
        if(idx >= s.length()) return 1;
        if(s.charAt(idx) -'0' == 0 ) return 0;
        if(memo.containsKey(idx)) return memo.get(idx);
        int curr = dp(s, memo, idx + 1);
        if(s.charAt(idx) - '0' > 0 && (idx + 1) <s.length()){
            int i = (s.charAt(idx) - '0') * 10 + (s.charAt(idx + 1) - '0');
            if(i < 27){
                int curr2 = dp(s, memo, idx + 2);
                memo.put(idx, curr + curr2);
                return curr + curr2;
                
            }
        }        memo.put(idx, curr);
                return curr;
    }
}
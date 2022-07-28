class Solution {
    public String longestPalindrome(String s) {
        int[] ans = new int[2];
        int[][] found = new int[1000][1000];
        for(int i = 0; i < 1000;i++){
            for(int j = 0; j < 1000; j++){
                found[i][j] = -1;
            }
        }
        dp(s, found,0, s.length() -1, ans);
        return s.substring(ans[0], ans[1]+1);
    }
    int dp(String s, int[][] memo,int left, int right, int[] ans){
        if(left >= right) return 1;
            int curr = 0;
        if(memo[left][right] != -1) return memo[left][right];
        if(s.charAt(left) == s.charAt(right)){
            curr = dp(s, memo, left + 1, right - 1,ans);
            if(curr == 1){
                memo[left][right] = 1;
                if(right - left > ans[1] - ans[0]){
                    ans[0] = left;
                    ans[1] = right;
                }
            }else memo[left][right] = curr;
     }
        memo[left][right] = curr;
            dp(s, memo, left + 1, right, ans);
            dp(s, memo, left , right - 1, ans);
        
            return(curr);
    }
}

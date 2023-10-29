class Solution {
    List<String> answer = new ArrayList<>();
    HashSet<String> dict; 
    int[] dp;
    public List<String> wordBreak(String s, List<String> wordDict) {
        dp = new int[s.length()];
        dict = new HashSet<>(wordDict);
        helper(s,0,new ArrayList<>());
        return answer;
    }
    
    int helper(String s, int idx, List<String> words){
        if(idx==s.length()){
            answer.add(String.join(" ",words));
            return 1;
        }
        if(dp[idx] == -1)
            return -1;
        for(int i=idx+1; i<=s.length(); i++){
            String curr = s.substring(idx,i);
            if(dict.contains(curr)){
                words.add(curr);
                int res = helper(s, i, words);
                dp[idx] = dp[idx] == 1? 1:res;
                words.remove(words.size()-1);
            }
        }
        return dp[idx] = dp[idx] == 1? 1: -1;
        
            
    }
}



   
/*
 pineapple penapple
    ^
list = [pineapple, ]
dp=[1,1,1]
*/
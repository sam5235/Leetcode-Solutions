class Solution {
    public String longestPrefix(String s) {
        int[] presuf = new int[s.length()];
        lps(presuf, s);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < presuf[presuf.length - 1]; i++){
            sb.append(s.charAt(i));
        }
        return sb.toString();        
    }
    void lps(int[] presuf, String s){
        int i = 0;
        int j = 1;
        while(j < s.length()){
            if(s.charAt(i) == s.charAt(j)){
                presuf[j] = i+1;
                i++;
                j++;
            }else{
                if(i == 0)
                    j++;
                 else
                     i = presuf[i - 1];
            }
        }
    }
}
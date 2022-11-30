class Solution {
    public int strStr(String haystack, String needle) {
        int[] presuf = new int[needle.length()];
        lps(presuf, needle);
        int i = 0;
        int j = 0;
        while(j < haystack.length()){
            if(haystack.charAt(j) == needle.charAt(i)){
                i++;
                j++;
            }else{
                if(i == 0){
                    j++;
                }else  i = presuf[i - 1];
            }
            if(i == needle.length()){
                return j - needle.length();
            }
        }
        return -1;
    }
    
    void lps(int[] presuf, String s){
        int i = 0;
        int j = 1;
        while(j < s.length()){
            if(s.charAt(i) == s.charAt(j)){
                presuf[j] = i + 1;
                i++;
                j++;
            }else{
                if(i == 0){
                    j++;
                }else{
                    i = presuf[i - 1];
                }
            }
        }
    }
}
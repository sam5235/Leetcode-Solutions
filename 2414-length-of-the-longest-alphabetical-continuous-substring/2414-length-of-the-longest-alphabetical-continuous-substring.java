class Solution {
    public int longestContinuousSubstring(String s) {
        int i = 0;
        int j = 0;
        int max = 0;
        while(j < s.length() - 1){
            if((s.charAt(j) - 'a' + 1) == (s.charAt(j + 1) - 'a')){
                max = Math.max(max, j - i + 1);
            }else{
                i = j + 1;
            }
            j++;
        }
        return max + 1;
    }
}
class Solution {
    public int characterReplacement(String s, int k) {
        int[] chars = new int[26];
        int i = 0;
        int j = 0;
        int leng = 0;
        while(j < s.length()){
            int dom = max(chars, 0);
            if(j - i - dom < k || chars[s.charAt(j) - 'A'] == dom){
                leng = Math.max(leng, (j - i + 1));
                chars[s.charAt(j) - 'A']++;
                j++;
            }else {
                chars[s.charAt(i) - 'A']--;
                i++;
            }
        }
       return leng; 
    }
    int max(int[] chars, int i){
        if(i == chars.length) return 0;
        return Math.max(chars[i], max(chars, i + 1));
    }
}
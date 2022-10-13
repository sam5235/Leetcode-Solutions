class Solution {
    public char findTheDifference(String s, String t) {
        int[] chars = new int[26];
        for(char c : s.toCharArray()){
            chars[c -'a']++;
        }
        for(char c : t.toCharArray()){
            if(chars[c -'a'] > 0) 
                chars[c - 'a']--;
            else return c;
        }
        return 'a';
    }
}
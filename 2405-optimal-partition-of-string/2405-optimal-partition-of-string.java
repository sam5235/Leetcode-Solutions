class Solution {
    public int partitionString(String s) {
        int[] chars = new int[26];
        int min = 0;
        int i = 0;
        while(i < s.length()){
            char c = s.charAt(i);
            if(chars[c - 'a'] == 0){
                chars[c - 'a']++;
                i++;
            }else{
                min++;
                chars = new int[26];
            }
        }
        
        return min + 1;
    }
}
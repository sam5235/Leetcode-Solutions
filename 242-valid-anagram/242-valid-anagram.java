class Solution {
    public boolean isAnagram(String s, String t) {
        int[] sArr = new int[26];
        for(char c : s.toCharArray()){
            sArr[c - 'a']++;
        }
        int[] tArr = new int[26];
        for(char c : t.toCharArray()){
            tArr[c - 'a']++;
        }
        return Arrays.toString(sArr).equals(Arrays.toString(tArr));
    }
}
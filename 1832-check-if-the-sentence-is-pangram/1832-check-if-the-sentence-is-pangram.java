class Solution {
    public boolean checkIfPangram(String sentence) {
        int[] ans  = new int[26];
        for(int i = 0; i < sentence.length(); i++){
            ans[sentence.charAt(i) - 'a']++;
        }
        for(int i : ans)
            if(i == 0)
                return false;
        return true;
    }
}
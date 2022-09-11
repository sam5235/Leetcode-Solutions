class Solution {
    public int percentageLetter(String s, char letter) {
        int letC = 0;
        
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == letter)letC++;
        }
        
        return letC  * 100 / s.length();
    }
}
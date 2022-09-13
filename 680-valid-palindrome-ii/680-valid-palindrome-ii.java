class Solution {
    public boolean validPalindrome(String s) {
        int i = 0, j = s.length() - 1; 
        while(i <= j){
            if(s.charAt(i) != s.charAt(j)){
              return isPali(s, i, j-1) || isPali(s, i + 1, j);
            }
            j--;
            i++;
        }
        return true;
    }
    
    boolean isPali(String s, int i, int j){
        while(i <= j){
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}
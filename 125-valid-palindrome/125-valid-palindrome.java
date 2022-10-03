class Solution {
    public boolean isPalindrome(String s) {
        String str = s.toLowerCase();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            if(str.charAt(i) - 'a' < 26 && str.charAt(i) - 'a' >= 0){
                sb.append(str.charAt(i));
            }
            if(str.charAt(i) -  '0' >= 0 && str.charAt(i) -'0' <= 9) sb.append(str.charAt(i));
        }
        
        int i = 0, j = sb.length() - 1; 
        while(i <= j){
            if(sb.charAt(i) != sb.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}
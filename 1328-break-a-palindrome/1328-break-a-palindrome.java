class Solution {
    public String breakPalindrome(String palindrome) {
        char[] ch = palindrome.toCharArray();
        int length = ch.length;
        if(length == 1) return "";
        for(int i = 0; i < ch.length; i++){
            if(ch[i] != 'a' && !(length % 2 != 0 && i == length / 2)){
                ch[i] = 'a';
                return new String(ch);
            }else if(i == length - 1){
                if(ch[i] == 'a'){
                    ch[i] = 'b';
                }else ch[i] = 'a';
                return new String(ch);
            }
        }
        return "";
    }
}
//aba
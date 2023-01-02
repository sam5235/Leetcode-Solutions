class Solution {
    public boolean detectCapitalUse(String word) {
        if(!Character.isUpperCase(word.charAt(0))){
            for(int i = 1; i < word.length(); i++){
                if(Character.isUpperCase(word.charAt(i)))
                    return false;
            }
            return true;
        }
        if(word.substring(1, word.length()).equals(word.toLowerCase().substring(1, word.length())))
            return true;
        for(int i = 0; i < word.length(); i++){
            if(!Character.isUpperCase(word.charAt(i)))
                return false;
        }
        return true;
        
    }
}
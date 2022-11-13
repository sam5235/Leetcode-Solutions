class Solution {
    public String reverseWords(String s) {
        StringBuilder temp = new StringBuilder();
        StringBuilder ans = new StringBuilder();
        String newS = s.trim();
        for(int i = newS.length() - 1; i >= 0; i--){
            if(newS.charAt(i) != ' ')
                temp.append(newS.charAt(i));
            else if(temp.length() > 0){
                ans.append(temp.reverse() + " ");
                temp = new StringBuilder();
            } 
        }
        if(temp.length() > 0)
                ans.append(temp.reverse() + " ");
        return ans.toString().trim();
    }
}
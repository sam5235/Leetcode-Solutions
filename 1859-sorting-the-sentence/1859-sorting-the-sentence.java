class Solution {
    public String sortSentence(String s) {
        String[] str = s.split(" ");
        String[] ans = new String[str.length];
        for(int i = 0; i < str.length; i++){
            ans[(str[i].charAt(str[i].length() - 1)) - '0' - 1] = str[i].substring(0, str[i].length() - 1);
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < ans.length; i++){
            sb.append(ans[i] + " ");
        }
    return sb.toString().trim();
    }
}
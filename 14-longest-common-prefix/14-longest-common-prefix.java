class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder(strs[0]);
            for(int i = 0; i < strs.length; i++){
                StringBuilder hold = new StringBuilder();
            for(int j = 0; j < Math.min(sb.length(), strs[i].length()); j++){
                if(sb.toString().charAt(j) != strs[i].charAt(j)){
                    break;
                }
                    hold.append(strs[i].charAt(j));
            }
                sb = hold;
        }
        return sb.toString();
    }
}
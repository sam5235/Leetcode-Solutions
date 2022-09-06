class Solution {
    public int[] shortestToChar(String s, char c) {
        int curr = s.length() + 1;
        int i = 0;
        int j = 0;
        int[] ans = new int[s.length()];
        
        while(i < ans.length && j < ans.length){
            if(s.charAt(i) == c){
                curr = i;
                ans[i] = 0;
                i++;
                j = i;
            }else if(s.charAt(j) == c){
                ans[i] = Math.min(Math.abs(curr - i), Math.abs(i - j));
                i++;
            }else j++;
        }
        while(i < ans.length){
            ans[i] = Math.abs(curr - i);
            i++;
            }
        
        return ans;
    }
}
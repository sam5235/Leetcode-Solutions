class Solution {
    public int minDeletionSize(String[] strs) {
        int ans = 0;
        for(int c = 0; c < strs[0].length(); c++){
            for(int i = 0; i < strs.length - 1; i++){
                if(strs[i].charAt(c) > strs[i + 1].charAt(c)){
                    ans++;
                    break;
                }
            }
            
        }
        return ans;
    }
}
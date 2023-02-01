class Solution {
    public int minimumRecolors(String blocks, int k) {
         int mini = k;
         int Count = 0;

        for(int i = 0; i < blocks.length(); i++) {
            if(blocks.charAt(i) == 'W') Count++;
            
            if(i >= k - 1) {
                if(i-k >= 0 && blocks.charAt(i - k) == 'W') Count--;
                mini = Math.min(mini, Count);
            }
        }
        
        return mini;
    }
}
class Solution {
    public int maxJump(int[] stones) {
        int res = stones[1] - stones[0];
        for(int i = 2; i < stones.length; i++){
            res = Math.max(res, stones[i] - stones[i - 2]);
        }
    return res;
    }
    
    
}
class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        int minR = m;
        int minC = n;
        
        for(int i = 0; i < ops.length; i++){
           minR = Math.min(minR, ops[i][0]);
           minC = Math.min(minC, ops[i][1]); 
        }
        
        return minR * minC;
    }
}
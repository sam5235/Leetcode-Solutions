class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int min = Integer.MAX_VALUE;
        HashMap<String, Integer> memo = new HashMap<>();
        for(int i = 0; i < matrix[0].length; i++){
            min = Math.min(min, sum(matrix, i,0, memo));
        }
        return min;
    }
    int sum(int[][] matrix,  int nxt, int r, HashMap<String, Integer> memo){
        if(nxt == matrix[0].length || nxt < 0)
            return Integer.MAX_VALUE;
        if(r == matrix.length)
            return 0;
        if(memo.containsKey(r+"," +nxt))
            return memo.get(r+"," +nxt);
        
        int left = sum(matrix, nxt - 1, r + 1, memo);
        int right = sum(matrix, nxt + 1, r + 1, memo);
        int mid = sum(matrix, nxt, r + 1, memo);
        int curr = Math.min(Math.min(left,right), mid);
        memo.put(r+","+nxt, curr + matrix[r][nxt]);
        return memo.get(r+","+nxt);   
   }
}
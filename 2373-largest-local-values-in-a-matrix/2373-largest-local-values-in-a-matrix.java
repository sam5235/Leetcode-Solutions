class Solution {
    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int[][] matrix = new int[n - 2][n - 2];
        int i = 0;
        while(i + 2 < n){
            int j = 0;
            while(j + 2 < n){
                int max = 1;
                for(int k = 0; k < 3; k++){
                    max = Math.max(max, grid[i][j + k]);
                    max = Math.max(max, grid[i + 1][j + k]);
                    max = Math.max(max, grid[i + 2][j + k]);                   
                }
                matrix[i][j] = max;
                j++;
            }
            i++;
        }
        return matrix;
        
    }
}
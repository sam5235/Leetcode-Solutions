class Solution {
    public int maxSum(int[][] grid) {
        int i = 0, max = 0;
        while(i + 2 < grid.length){
            int j = 0;
            int sum = 0;
            for(int k = 0; k <= 2; k++){
                sum += grid[i][j + k];
                sum += grid[i + 2][j + k];
            }
            sum += grid[i + 1][j + 1];
            max = Math.max(max, sum);

            j++;
            while(j + 2 < grid[0].length){
                    sum -= grid[i][j-1];
                    sum -= grid[i + 1][j];
                    sum -= grid[i + 2][j-1];
                    sum += grid[i][j + 2];
                    sum += grid[i + 2][j + 2];    
                    sum += grid[i + 1][j + 1];

                max = Math.max(max, sum);
                j++;
            }
            i++;
        }
        return max;
    }
}
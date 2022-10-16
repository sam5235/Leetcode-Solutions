class NumMatrix {
    int[][] grid;
    int[][] matrix;
    public NumMatrix(int[][] matrix) {
        this.matrix =  matrix;
        grid = new int[matrix.length][matrix[0].length];
        prefixGrid(grid);
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int a = grid[row2][col2];
        int b = col1 == 0? 0 : grid[row2][col1 - 1];
        int c = row1 == 0? 0:  grid[row1 - 1][col2];
        int d = row1 == 0 || col1 == 0 ? 0: grid[row1 - 1][col1 - 1];
        
        return a-b-c+d;
    }
    
    void prefixGrid(int[][] grid){
     grid[0][0] = matrix[0][0];
        for(int i = 1; i < grid[0].length; i++)
            grid[0][i] = matrix[0][i] + grid[0][i - 1];
        
        for(int i = 1; i < grid.length; i++)
            grid[i][0] = grid[i - 1][0] + matrix[i][0];
        
        for(int i = 1; i < grid.length; i++){
            for(int j = 1; j < grid[0].length ; j++){
                grid[i][j] = grid[i - 1][j] + grid[i][j - 1] - grid[i - 1][j - 1] + matrix[i][j];
            }
        }
        
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
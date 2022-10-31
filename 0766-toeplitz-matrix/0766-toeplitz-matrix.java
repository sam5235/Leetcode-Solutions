class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        for(int i = 0; i < matrix[0].length; i++){
            if(!sameDiagram(matrix, 0, i, matrix[0][i]))
                return false;
        }
        for(int i = 0; i < matrix.length; i++){
            if(!sameDiagram(matrix, i, 0, matrix[i][0])){
                return false;
            }
        }
        return true;
    }
    
    boolean sameDiagram(int[][] grid, int r, int c, int elem){
        while(!isBound(r,c, grid.length, grid[0].length)){
            if(!(grid[r][c] == elem))
                return false;
            r = r + 1;
            c = c + 1;
        }
        return true;
    }
    
    boolean isBound(int r, int c, int n, int m){
        return r < 0 || r >= n || c < 0 || c >= m;
    }
}
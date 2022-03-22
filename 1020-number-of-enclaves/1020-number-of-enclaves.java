class Solution {
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for(int i = 0; i < m; i++){
            if(i == 0 || i == m - 1){
                for(int j = 0; j < n; j++){
                    dfs(grid, i, j);
                }
            }else {
                dfs(grid, i, 0);
                dfs(grid,i, n - 1);
            }
        }
        int moves = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                   if(grid[i][j] == 1) moves++; 
            }
        }
        return moves; 
        
    }
    
    
    void dfs(int [][] grid, int r, int c){
        int m = grid.length;
        int n = grid[0].length;
        if(grid[r][c] == 1){
            grid[r][c] = 0;
            int [][] dir = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
            for(int i = 0; i < 4; i++){
               int newR = r + dir[i][0];
               int newC = c + dir[i][1];
                if(!outBound(m,n, newR, newC)){
                   dfs(grid, newR, newC); 
                }
            }
        }
    }
    boolean outBound(int m, int n, int r, int c){
        if(r < 0 || r >m - 1|| c <0|| c > n - 1) return true;
        return false;
    }
}


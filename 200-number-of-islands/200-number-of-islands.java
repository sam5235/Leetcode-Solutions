class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                    if(grid[i][j] == '1'){
                        count++;
                         dfs(grid, i,j);   
                    }
            }
        }
        return count;
    }
    void dfs(char[][] grid, int r, int c){
         int[][] dir = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
         if(!isOutBound(r, c, grid.length, grid[0].length) && grid[r][c] != '0'){
             grid[r][c] = '0';
             for(int i = 0; i < 4; i++){
                 int newR = r + dir[i][0];
                 int newC = c + dir[i][1];
                 dfs(grid, newR, newC);
             }
             
         }
    }
    
     boolean isOutBound(int r, int c, int n, int m){
        return (r<0 || r >= n || c < 0 || c >= m);
    }
}
class Solution {
    public int islandPerimeter(int[][] grid) {
        int[][] dir ={{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int ans = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    for(int k = 0; k < 4; k++){
                    int r = i + dir[k][0];
                    int c = j + dir[k][1];
                        if(outOfBound(c, r, grid[0].length, grid.length) || grid[r][c] == 0) ans++;
                    }
                }
            }
        }
        return ans;
    }
     boolean outOfBound(int c, int r, int n, int m){
        return (c >= n || c < 0 || r >= m || r < 0 );
    }
}

class Solution {
    public int[] findBall(int[][] grid) {
        int[] balls = new int[grid[0].length];
        for(int i = 0; i < grid[0].length; i++){
            balls[i] = dfs(i, 0, grid);
        }
        return balls;
        
    }
    
    int dfs(int pos, int level, int[][] grid){
        if(level == grid.length)
            return pos;
        int[] dir = grid[level];
        if(dir[pos] == 1){
            if(pos + 1 == grid[0].length || dir[pos + 1] == -1)
                return -1;
            return dfs(pos + 1, level + 1 , grid);
        }
        if(pos - 1 == -1 ||  dir[pos - 1] == 1)
            return -1;
        return dfs(pos - 1, level + 1, grid);
    }
}
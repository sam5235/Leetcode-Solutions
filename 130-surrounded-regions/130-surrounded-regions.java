class Solution {
    public void solve(char[][] board) {
        char[][] grid = board;
        for(int i = 0; i < board.length; i++){
            if(i == 0 || i == board.length - 1){
                for(int j = 0; j < board[0].length; j++){
                    if(grid[i][j] == 'O') dfs(grid, i, j);
                }
            }else {
                if(grid[i][0] == 'O') dfs(grid, i, 0);
                if(grid[i][board[0].length - 1] == 'O') dfs(grid, i, board[0].length - 1);
            }     
    }  
       for(int i = 0; i < grid.length; i++){
           for(int j = 0; j < board[0].length; j++){
               if(grid[i][j] == 'O') grid[i][j] = 'X';
               if(grid[i][j] == 'A') grid[i][j] = 'O';
           }
       }
}     
    void dfs(char[][] grid, int r, int c){
        grid[r][c] = 'A';
        int[][] dir = {{0, -1},{-1, 0}, {0,1},{1, 0}};
        for(int i = 0; i < 4; i++){
            int newR = r + dir[i][0];
            int newC = c + dir[i][1];
            List<Integer> vis = new ArrayList<>(Arrays.asList(newR, newC));
            if(!isOutBound(grid.length, grid[0].length, newR, newC) && grid[newR][newC] == 'O'){
                dfs(grid, newR, newC);
            }
        }    
    }
    boolean isOutBound(int m, int n, int r, int c){
        if(r < 0 || r > m-1 || c > n- 1|| c < 0) return true;
        return false;
    }
    
}
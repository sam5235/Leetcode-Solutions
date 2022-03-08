class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int ans = 0;
        HashSet<List<Integer>> visited = new HashSet<>();
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                List<Integer> vis = new ArrayList<>(Arrays.asList(i, j));
                    if( !visited.contains(vis)) ans = Math.max(ans, dfs(grid, i, j, visited));
                    
                }
            }
        }
        return ans;
    }
    int dfs(int[][] grid, int r, int c, HashSet<List<Integer>> visited){
        visited.add(new ArrayList<>(Arrays.asList(r,c)));
        int[][] dir = {{0, -1},{-1, 0}, {0,1},{1, 0}};
        int area = 1;
        for(int i = 0; i < 4; i++){
            int newR = r + dir[i][0];
            int newC = c + dir[i][1];
            List<Integer> vis = new ArrayList<>(Arrays.asList(newR, newC));
            if(!isOutBound(grid.length, grid[0].length, newR, newC) && !visited.contains(vis) && grid[newR][newC] == 1){
                area += dfs(grid, newR, newC, visited);
            }
        }
        return area;
        
    }
    boolean isOutBound(int m, int n, int r, int c){
        if(r < 0 || r > m-1 || c > n- 1|| c < 0) return true;
        return false;
    }
}
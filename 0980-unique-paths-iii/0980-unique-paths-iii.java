class Solution {
    public int uniquePathsIII(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int availableCell = 0;
        int r = 0, c = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] != -1) availableCell++;
                if(grid[i][j] == 1){
                    r = i;
                    c = j;
                }
            }
        }
        HashSet<String> visited = new HashSet<>();
        visited.add(r +"," + c);
        int[] paths = new int[1];
        findPaths(grid, r, c, visited, paths, availableCell);
        return paths[0];
    }
    
    void findPaths(int[][] grid, int r, int c, HashSet<String> visited, int[] paths, int availableCell){
        if(grid[r][c] == 2 && visited.size() == availableCell){
            paths[0]++;
            return;
        }
                
        int[][] dir = {{0,1}, {0, -1}, {1, 0}, {-1, 0}};
        
        for(int i = 0; i < 4; i++){
            int newR = r + dir[i][0];
            int newC = c + dir[i][1];
            String arr = newR + "," + newC;
            if(!outBo(newR, newC, grid.length, grid[0].length) && !visited.contains(arr)  && grid[newR][newC] != -1){
                visited.add(arr);
                findPaths(grid, newR, newC, visited, paths, availableCell);
                visited.remove(arr);
            }
        }
    }
    
    boolean outBo(int r, int c, int m, int n){
        return r < 0 || r >= m || c < 0|| c >= n;
    }
}
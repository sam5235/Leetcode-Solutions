class Solution {
    public int swimInWater(int[][] grid) {
        Queue<int[]> paths = new PriorityQueue<>((a,b)->grid[a[0]][a[1]] - grid[b[0]][b[1]]);
        HashSet<Integer> visited = new HashSet<>();
        int n = grid.length;
        paths.add(new int[]{0,0});
        int ans = 0;
        while(paths.peek()[0] != n-1 || paths.peek()[1] != n-1){
          int[] polled = paths.poll();
            visited.add(grid[polled[0]][polled[1]]);
            int[][] dir = {{0,-1},{-1,0},{0,1},{1,0}};
            for(int i = 0; i < 4; i++){
                int newR = polled[0] + dir[i][0];
                int newC = polled[1] + dir[i][1];
                if(!isOutBound(n,n,newR,newC) && !visited.contains(grid[newR][newC])){
                    paths.add(new int[]{newR,newC});
                } 
            }
            ans = Math.max(ans, grid[polled[0]][polled[1]]);  
        }
        int[] polled = paths.poll();
        ans = Math.max(ans, grid[polled[0]][polled[1]]);
        return ans;
    }
     boolean isOutBound(int m, int n, int r, int c){
        return (r > m - 1 || r < 0 || c < 0 || c > n - 1);
    }
    

}
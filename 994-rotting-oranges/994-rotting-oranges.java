class Solution {
    public int orangesRotting(int[][] grid) {
       Queue<int[]> rotten = new LinkedList<>();
       int fresh = 0;
       for(int i = 0; i < grid.length; i++){
           for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == 2) rotten.add(new int[]{i,j});
                if(grid[i][j] == 1) fresh++;
           }
       }
        int[][] dir = {{0,-1}, {-1,0},{0,1},{1,0}};
        int min = 0;
        while(!rotten.isEmpty()){
            int size = rotten.size();
            for(int i = 0; i < size; i++){
                int[] polled = rotten.poll();
                for(int j = 0; j < 4; j++){
                    int newR = polled[0] + dir[j][0];
                    int newC = polled[1] + dir[j][1];
                    if(!isOutBound(grid.length, grid[0].length, newR, newC) && grid[newR][newC] == 1){
                        rotten.add(new int[]{newR,newC});
                        grid[newR][newC] = 2;
                        fresh--;
                    }
                }
            } 
              min++;
        }
        return (fresh != 0) ? -1 : Math.max(0, min - 1);
    }
    boolean isOutBound(int m, int n, int r, int c){
        return (r > m - 1 || r < 0 || c < 0 || c > n - 1);
    }
}
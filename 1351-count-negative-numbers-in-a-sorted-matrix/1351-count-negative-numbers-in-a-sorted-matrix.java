class Solution {
    public int countNegatives(int[][] grid) {
         int count = 0;
        for(int i = 0; i < grid.length; i++){
            int low = 0;
            int high = grid[i].length - 1;
           
            while(low <= high){
                int mid = low + (high - low)/2;
                if(grid[i][mid] < 0){
                    count += (high + 1) - mid;
                    high = mid - 1;
                }else low = mid + 1;
            }
        }
        return count;
    }
}
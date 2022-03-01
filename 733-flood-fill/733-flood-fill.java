class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image[sr][sc] != newColor){
            dfs(image, sr,sc, newColor);
        }
        return image;
    }
    public void dfs(int[][] image, int old_r, int old_c, int newColor){
        int oldColor = image[old_r][old_c];
        image[old_r][old_c] = newColor;
        int[][] dir ={{0,-1}, {-1,0}, {0,1},{1,0}};
        for(int i = 0; i < 4; i++){
             int newRow = old_r + dir[i][0];
             int newCol = old_c + dir[i][1];
             if(!isOutOfBound(image.length, image[old_r].length, newRow, newCol) && image[newRow][newCol] == oldColor)
                    dfs(image, newRow, newCol, newColor);
           }
    }
    public boolean isOutOfBound(int m, int n, int r, int c){
        return (r < 0) || (r > m-1) || (c < 0) ||(c > n -1);
    }
}
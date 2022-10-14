class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] grid = new int[n + 1][m + 1];
        for(int i = 1; i < n + 1; i++){
            char c = text1.charAt(i - 1);
            for(int j = 1; j < m + 1; j++){
                char c2 = text2.charAt(j - 1);
                if(c == c2)
                    grid[i][j] = grid[i - 1][j - 1] + 1;
                else grid[i][j] = Math.max(grid[i][j - 1], grid[i - 1][j]);
            }
        }
        return grid[n][m];
    }
}
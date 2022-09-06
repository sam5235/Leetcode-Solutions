class Solution {
    public int uniquePaths(int m, int n) {
        int[][] ans = new int[m][n];
        ans[0][0] =  1;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int up =(i - 1 >= 0)? ans[i - 1][j] : 0;
                int left = (j - 1 >= 0) ? ans[i][j - 1] :0;
                ans[i][j] += up + left;
            }
        }
        return ans[m-1][n-1];
    }
}
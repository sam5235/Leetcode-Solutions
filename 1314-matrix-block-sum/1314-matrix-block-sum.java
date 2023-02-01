class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {

        int m = mat.length;
        int n = mat[0].length;

        int[][] ans = new int[m][n];

        for (int i = 0; i < m; i++) {
            
            for (int j = 0; j < n; j++) {

                int sum = 0;

                for (int l = Math.max(0,i-k); l <= Math.min(m-1,i+k); l++) {

                    for (int o = Math.max(0,j-k); o <= Math.min(n-1,j+k); o++) {
                        sum+=mat[l][o];
                        
                    }
                    
                }

                ans[i][j] = sum;
            }
            
        }
        
        return ans;

    }
}
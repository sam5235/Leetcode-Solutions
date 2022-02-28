class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int low = 0;
        int high = mat.length - 1;
        int[] ans = {0,0};
        while(low <= high){
            int max = 0;
            int maxIdx = 0;
            int mid = low + (high - low)/2;
            for(int i = 0; i < mat[mid].length; i++){
                int left = (i == 0) ? -1: mat[mid][i-1];
                int right = (i == mat[mid].length - 1) ? -1: mat[mid][i+1];
                int up = (mid == 0)? -1: mat[mid - 1][i];
                int down = (mid == mat.length - 1)? -1: mat[mid + 1][i];
                if(mat[mid][i] > left && mat[mid][i] > right && mat[mid][i] > up && mat[mid][i] > down ){
                    return  new int[]{mid, i};
                } else {
                    max = Math.max(max, mat[mid][i] );
                    if( max == mat[mid][i]){
                        maxIdx = i;
                    }
                    
                }
            }
            if(mid > 0 && mat[mid][maxIdx] < mat[mid-1][maxIdx]){
                high = mid-1;
            }else low = mid + 1;
             
            }
        return ans;
}
}
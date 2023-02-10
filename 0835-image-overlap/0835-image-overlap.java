class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int rowCount = img1.length;
        int colCount = img1[0].length;
        
        int result = 0;
        
        long[] vals1 = new long[rowCount];
        long[] vals2 = new long[rowCount];
        
        for(int i = 0; i < img1.length; i++){
            int[] row1 = img1[i];
            int val = 0;
            for(int c : row1){
                val <<= 1;
                val |= c;
            }
            vals1[i] = val;
        }
        
        for(int i = 0; i < img2.length; i++){
            int[] row2 = img2[i];
            int val = 0;
            for(int c : row2){
                val <<= 1;
                val |= c;
            }
            vals2[i] = val;
        }
        
        for(int i = -(rowCount-1); i <= rowCount-1; i++){
            for(int j = -(colCount-1); j <= colCount-1; j++){
                int overlapping = 0;
                
                for(int k = 0; k < rowCount; k++){
                    int updated_i = i+k;
                    if(updated_i >= 0 && updated_i < rowCount){
                        long updated_val = j < 0 ? vals1[k] << Math.abs(j) : vals1[k] >> Math.abs(j);
                        
                        long res = vals2[updated_i] & updated_val;
                        
                        overlapping += countSetBits(res);
                    }
                }
                
                result = Math.max(result, overlapping);
            }
        }
        
        return result;
    }
    
    private int countSetBits(long val){
        int res = 0;
        
        while(val != 0){
            val = (val & (val-1));
            res++;
        }
        
        return res;
    }
}
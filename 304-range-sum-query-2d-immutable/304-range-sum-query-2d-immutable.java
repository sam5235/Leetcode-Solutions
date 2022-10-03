class NumMatrix {
    int[][] matrix;
    int[][] res;
    public NumMatrix(int[][] matrix) {
        this.matrix=matrix;
        this.res=new int[matrix.length][matrix[0].length];
        compute(matrix);        
    }
    void compute(int[][] matrix){
        int m=matrix.length;
        int n=matrix[0].length;
        res[0][0]=matrix[0][0];
        
        for(int i=1;i<m;i++)
            res[i][0]=matrix[i][0]+res[i-1][0];
        for(int i=1;i<n;i++)
            res[0][i]=matrix[0][i]+res[0][i-1];
               
        for(int i=1;i<m;++i){
            for(int j=1;j<n;j++){
            res[i][j]=matrix[i][j]+res[i-1][j]+res[i][j-1]-res[i-1][j-1];    
            }
        }     
    }
    
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
            
            int a=res[row2][col2];
            int b= row1==0?0: res[row1-1][col2];
            int c=col1==0?0:res[row2][col1-1];           
            int d=row1==0||col1==0?0:res[row1-1][col1-1];  
         
            return a-b-c+d;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */

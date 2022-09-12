class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ls = new ArrayList<>();
       int upperB = 0, lowB = matrix.length - 1, leftB = 0, rightB = matrix[0].length - 1 ;
      
        while(upperB <= lowB && leftB <= rightB){
            
            for(int i = leftB; i <= rightB && upperB <= lowB; i++){
                ls.add(matrix[upperB][i]);
            }upperB++;
            
            for(int i = upperB; i <= lowB && leftB <= rightB; i++){
                ls.add(matrix[i][rightB]);
            }rightB--;
            
            for(int i = rightB; i >= leftB && upperB <= lowB ; i--){
                ls.add(matrix[lowB][i]);
            }lowB--;
            
            for(int i = lowB; i >= upperB && leftB <= rightB; i--){
                ls.add(matrix[i][leftB]);
            }leftB++;
        }
        return ls;
    }
}
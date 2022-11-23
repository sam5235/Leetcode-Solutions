class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean ans = true;
        for(int i = 0; i <= 6; i += 3){
            for(int j = 0; j <= 6; j +=3){
                ans = ans && subBox(board, i, j);
            }
        }
        return ans;
    }
    boolean subBox(char[][] board, int startI, int startJ){
        boolean[] boolArr = new boolean[10];
        for(int i = startI; i < startI + 3; i++){
            for(int j = startJ; j < startJ + 3; j++){
              if(board[i][j] != '.'){
                  for(int k = 0; k < 9; k++){
                      if(j != k && board[i][k] == board[i][j]) return false;
                  }
                  for(int k = 0; k < 9; k++){
                      if(i != k && board[k][j] == board[i][j]) return false;
                  }
                if(boolArr[board[i][j] - '0']){
                    return false;
                }
                boolArr[board[i][j] - '0'] = true;
                  
              }  
            }
        }
        return true;
    }
}
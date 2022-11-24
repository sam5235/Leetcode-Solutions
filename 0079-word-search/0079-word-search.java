class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == word.charAt(0)){
                 boolean[] boolArr = new boolean[board.length * board[0].length]; 
                    boolArr[(i * board[0].length) + j] = true;
                     if(wordFind(board, word, i, j, 1, boolArr)) return true;
                    boolArr[(i * board[0].length) + j] = false;
                    
                }
            }
        }
        return false;
    }
    boolean wordFind(char[][] board, String word, int row, int col, int c, boolean[] boolArr){
        
        if(c == word.length()) return true;
        int[][] dir ={{0,1}, {0, -1}, {1, 0}, {-1, 0}};
        for(int i = 0; i < 4; i++){
            int newR = row + dir[i][0];
            int newC = col + dir[i][1];
            if(!outB(newR, newC, board.length, board[0].length) && !boolArr[(newR * board[0].length) + newC] && board[newR][newC] == word.charAt(c)){
                boolArr[(newR * board[0].length) + newC] = true;
                if(wordFind(board, word, newR, newC, c + 1, boolArr)) return true;
                boolArr[(newR * board[0].length) + newC] = false;
            }
        }
        return false;
    }
    
    boolean outB(int r, int c, int m, int n){
        return r < 0 || r >= m || c < 0 || c >= n;
    }
}
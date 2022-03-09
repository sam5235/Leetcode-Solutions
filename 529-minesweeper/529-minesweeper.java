class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        if(board[click[0]][click[1]] == 'M'){
            board[click[0]][click[1]] = 'X';
            return board;
        } 
        dfs(board, click[0], click[1]);
        return board;
    }
    void dfs(char[][] board, int r, int c){
        if(board[r][c] == 'E'){
            int[][] dir = {{0, -1},{-1, 0},{0, 1},{1, 0},{-1, -1},{-1, 1},{1,-1},{1,1}};
            int countM = 0;
            for(int i = 0; i < 8; i++){
                int newR = r + dir[i][0];
                int newC = c + dir[i][1];
                if(!isOutBound(board.length, board[0].length, newR, newC)&& board[newR][newC] == 'M'){
                    countM++;
                }
            }
            if(countM == 0){
                board[r][c] = 'B';
               // int[][] dir = {{0, -1},{-1, 0},{0, 1},{1, 0},{-1, -1},{-1, 1},{1,-1},{1,1}};
                for(int i = 0; i < 8; i++){
                  int newR = r + dir[i][0];
                  int newC = c + dir[i][1];
                  if(!isOutBound(board.length, board[0].length, newR, newC)){
                    dfs(board, newR, newC);
                  }
                }
            }else board[r][c] = (char) (countM + '0');  
        }
    }
    boolean isOutBound(int m, int n, int r, int c){
        if(r > m - 1|| r < 0|| c < 0 || c > n-1) return true;
        return false;
    }
} 
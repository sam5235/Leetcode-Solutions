class Solution {
    public void gameOfLife(int[][] board) {
       Queue<List<Integer>> q = new LinkedList<>();
        int[][] dir ={{0, -1}, {-1, 0}, {0, 1}, {1, 0}, {-1, -1}, {1, 1}, {-1, 1}, {1, -1}};
        int m = board.length;
        int n = board[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
            int count = 0;
                for(int k = 0; k < 8; k++){
                    int r = i + dir[k][0];
                    int c = j + dir[k][1]; 
                    if(!outBound(m, n, r, c) && board[r][c] == 1) count++;
                }
                   
                
                if(count < 2 && board[i][j] == 1){
                    List<Integer> temp = new LinkedList<>();
                    temp.add(0);
                    temp.add(i);
                    temp.add(j);
                     q.add(temp);
                }else if(count > 3 && board[i][j] == 1 ){
                    List<Integer> temp = new LinkedList<>();
                    temp.add(0);
                    temp.add(i);
                    temp.add(j);
                     q.add(temp);
                }else if( count == 3 && board[i][j] == 0){
                    List<Integer> temp = new LinkedList<>();
                    temp.add(1);
                    temp.add(i);
                    temp.add(j);
                     q.add(temp);
                }
               
            }
        }
        
        while(!q.isEmpty()){
             List<Integer> temp = q.poll();
             board[temp.get(1)][temp.get(2)] = temp.get(0);
        }
    }
    
    boolean outBound(int m, int n, int r, int c){
        if(r < 0 || r > m - 1|| c < 0|| c > n-1) return true;
        return false;
    }
}

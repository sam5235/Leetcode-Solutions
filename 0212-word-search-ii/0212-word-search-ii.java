class Solution {
    TrieNode root = new TrieNode();
    public List<String> findWords(char[][] board, String[] words) {
        List<String> ans = new ArrayList<>();
        int n = board.length;
        int m = board[0].length;
        buildTrie(words);
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                TrieNode node = root;
                search(board, new boolean[n][m], node.child[board[i][j] - 'a'], new StringBuilder(), ans,i,j, n , m);
            }
        }
    
        return ans;
    }
    
   void search(char[][] board, boolean[][] visited, TrieNode node,StringBuilder sb, List<String> temp, int row, int col, int totRow, int totCol){
      if(node == null)
            return;
       sb.append(board[row][col]);
       if(node.isEnd){
           temp.add(sb.toString());
           node.isEnd = false;
       }
       visited[row][col] = true;
       int[][] dir = {{-1, 0}, {1, 0}, {0,1},{0,-1}};
       for(int i = 0; i < 4; i++){
           int newR = dir[i][0] + row;
           int newC = dir[i][1] + col;
           if(!isOutB(newR, newC, totRow, totCol) && !visited[newR][newC]){
               int idx = board[newR][newC] - 'a';               
               search(board, visited, node.child[idx],sb, temp, newR, newC, totRow, totCol);
               
           }     
       }
       if(sb.length() > 0)
            sb.deleteCharAt(sb.length() - 1);
       visited[row][col] = false;
       
   }
    boolean isOutB(int row, int col, int totRow, int totCol){
        return row < 0 || row >= totRow || col < 0 || col >= totCol;
    }
    
   void buildTrie(String[] words){
        for(int i = 0; i < words.length; i++){
            String word = words[i];
            TrieNode node = root;
            for(int j = 0; j < word.length(); j++){
                int idx = word.charAt(j) - 'a';
                if(node.child[idx] == null){
                    node.child[idx] = new TrieNode();
                }
                node = node.child[idx];
            }
            node.isEnd = true;
        }
    }
}

class TrieNode{
    TrieNode[] child = new TrieNode[26];
    boolean isEnd = false;
}
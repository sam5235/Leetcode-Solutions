class Solution {
    public int snakesAndLadders(int[][] board) {
        int end = board.length * board.length;
        Queue<Integer> curr  = new LinkedList<>();
        HashMap<Integer, Integer> ladders = new HashMap<>();
        HashSet<Integer> seen = new HashSet<>();
        int i = board.length - 1;
        int j = 0;
        int cell = 1, dir = 1;
        while(i >= 0){
            while(j >= 0 && j < board[0].length){
                if(board[i][j] != -1)
                    ladders.put(cell, board[i][j]);
                j += dir;
                cell++; 
            }
            j -= dir;
            dir *= -1;
            i--;
        }
        
        seen.add(1);
        curr.add(1);
        int steps = 0;
        while(!curr.isEmpty()){
            int size = curr.size();            
            for(int s = 0; s < size; s++){
                int polled = curr.poll();
                if(polled == end)
                    return steps;
                
                    
                for(int nxt = 1; nxt <= 6; nxt++){
                    int next = polled + nxt;
                        if(ladders.containsKey(next)){
                            if(!seen.contains(ladders.get(next))){
                                curr.add(ladders.get(next));
                                seen.add(ladders.get(next));
                                
                            }
                        }
                        else if(end >= next && !seen.contains(next)){
                            curr.add(next);
                            seen.add(next);
                        }
                }
                
            }
            steps++;
        }
        return -1;
    }
}


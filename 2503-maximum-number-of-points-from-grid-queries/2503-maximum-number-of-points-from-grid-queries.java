class Solution {
    public int[] maxPoints(int[][] grid, int[] queries) {
        PriorityQueue<Node> heap = new PriorityQueue<>();
        int m  = grid.length;
        int n = grid[0].length;
        int[] sorQ = queries.clone();
        Arrays.sort(sorQ);        
        HashSet<String> seen = new HashSet<>();
        int idx = 0, cn = 0 ;
        int[] ans = new int[sorQ.length];
        heap.add(new Node(0,0,grid[0][0]));
        seen.add(0 + "," +0);
                
        while(!heap.isEmpty() && idx < sorQ.length){
            Node polled = heap.peek();
            int r = polled.row;
            int c = polled.col;
            int val = polled.val;
            if(sorQ[idx] > val){
                heap.poll();
                cn++;
                
                int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
                for(int i = 0; i < 4; i++){
                    int row = r + dir[i][0];
                    int col = c + dir[i][1];
                    if(!outB(m, n, row, col) && !seen.contains(row  + "," + col)){
                        seen.add(row + "," + col);
                        heap.add(new Node(row, col, grid[row][col]));
                    } 
                
                }
                
            }else{
                    ans[idx] = cn;
                idx++;
            }
        }
        
        while(idx < sorQ.length){
            ans[idx] =  cn;
                idx++;
        }
        HashMap<Integer, Integer> map= new HashMap<>();
        for(int i = 0; i < sorQ.length; i++){
            map.put(sorQ[i], ans[i]);
        }
        int[] finals = new int[sorQ.length];
        for(int i = 0; i < sorQ.length; i++){
            finals[i] = map.get(queries[i]);
        }
        return finals;
    }
       
    boolean outB(int m, int n, int r, int c){
        return r < 0|| c< 0||r >= m || c >= n;
    }
        
}

class Node implements Comparable<Node>{
    int row;
    int col;
    int val;
    Node(int a, int b, int value){
        row = a;
        col = b;
        val = value;
    }
    
    public int compareTo(Node otherNode){
        return val - otherNode.val;
    }
    
    
    
}
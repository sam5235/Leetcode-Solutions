class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
          int m = grid.length;
          int n = grid[0].length;
          int size = n * m;
          Queue<Integer> q = new LinkedList<>();
          for(int i = m - 1; i >= 0; i--){
              for(int j = n - 1; j >= 0 ; j--){
                 q.add(grid[i][j]);
              }
          }
        int i = 0;
        while(i < (k % size)){
            q.add(q.poll());
            i++;
       }
      Stack<Integer> st = new Stack<>();
        while(!q.isEmpty()){
            st.push(q.poll());
        }
        List<List<Integer>> mainAns = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        while(!st.isEmpty()){
           for(int j = 0; j < n; j++){
                ans.add(st.pop());
           }
            mainAns.add(ans);
            ans = new ArrayList<>();
        }
        return mainAns;      
    }
}

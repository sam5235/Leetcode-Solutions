class Solution {
    public int[] getOrder(int[][] tasks) {
        int[][] events = new int[tasks.length][3];
        for(int i = 0; i < tasks.length; i++){
            events[i][0] = i;
            events[i][1] = tasks[i][0];
            events[i][2] = tasks[i][1];
        }
        Arrays.sort(events, (a,b) -> a[1] - b[1]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[2] != b[2]? (a[2] - b[2]) : (a[0] - b[0]));
        int[] ans = new int[tasks.length];
        int time = events[0][1];
         int i = 0;
        int cn =0;
        while(!pq.isEmpty() || (i >= 0 && i < tasks.length)){
            if(!pq.isEmpty()){ 
                int[] popped = pq.poll();
                time += popped[2];
                ans[cn] = popped[0];
                cn++;
            }
             
            while(i < tasks.length && events[i][1] <= time ){
                pq.add(events[i]);
                i++;
            }
            
            if(i < tasks.length && pq.isEmpty()){
                time = events[i][1];
            }
        
        }
        return ans;
    }
}
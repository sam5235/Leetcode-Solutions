class Solution {
    public int nthUglyNumber(int n) {
        int[] trios = {2,3,5};
        HashSet<Long> visited = new HashSet<>();
        PriorityQueue<Long> pq = new PriorityQueue<Long>();
        for(long num : trios){
            pq.add(num);
            visited.add(num);
        }
        HashSet<Long> ans = new HashSet<>();
        while(ans.size() < (n - 1)){
            long polled = pq.poll();
            ans.add(polled);
            for(int i = 0; i < 3; i++){
                if(!visited.contains(polled * trios[i])){
                    pq.add(polled * trios[i]);
                    visited.add(polled * trios[i]);
                } 
            }
        }
        long nth = 1;
        for(long num : ans){
            nth = Math.max(nth, num);
        }
        return (int)nth;
    }
}
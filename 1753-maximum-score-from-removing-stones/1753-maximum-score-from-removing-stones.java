class Solution {
    public int maximumScore(int a, int b, int c) {
        Queue<Integer> pq = new PriorityQueue<>((a1,b1)-> b1 - a1);
        pq.add(a);
        pq.add(b);
        pq.add(c);
        int count = 0;
        while(pq.size() > 1){
            int frst = pq.poll() - 1;
            int scnd = pq.poll() - 1;
            count++;
            if(frst > 0){
                pq.add(frst);
            }
            if(scnd > 0){
                pq.add(scnd);
            }
        }
        
        return count;
    }
}
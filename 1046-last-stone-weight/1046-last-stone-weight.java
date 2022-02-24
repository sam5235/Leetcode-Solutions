class Solution {
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> pq = new PriorityQueue<>((a,b)-> b-a);
        for(int stone : stones){
            pq.add(stone);
        }
        while(pq.size() > 1){
            int smashed = pq.poll() - pq.poll();
            pq.add(smashed);
        }
        return pq.poll();
    }
}
class Solution {
    public int maxProduct(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);
        for(int t : nums) pq.add(t);
        return ((pq.poll() -1) * (pq.poll() - 1));
    }
}
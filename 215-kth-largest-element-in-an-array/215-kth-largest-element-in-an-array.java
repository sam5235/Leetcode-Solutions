class Solution {
    public int findKthLargest(int[] nums, int k) {
      Queue<Integer> pq = new PriorityQueue<>((a,b)-> b-a);
        for(int num : nums){
            pq.add(num);
        }
        for(int i = 1; i < k; i++){
            pq.poll();
        }
        return pq.poll();
    }
}
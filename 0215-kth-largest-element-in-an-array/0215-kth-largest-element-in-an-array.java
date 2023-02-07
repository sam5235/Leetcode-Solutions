class Solution {
   public int findKthLargest(int[] A, int k) {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    for (int a : A) {
        minHeap.add(a);
        if (minHeap.size() > k) {
            minHeap.remove();
        }
    }
    return minHeap.peek();
}
}
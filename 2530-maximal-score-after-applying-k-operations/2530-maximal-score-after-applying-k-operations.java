class Solution {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b)-> (b - a));
        long score = 0;
        for(int i = 0; i < nums.length; i++){
            heap.add(nums[i]);
        }
        
        while(k > 0){
            int polled = heap.poll();
            score += polled;
            heap.add((int)Math.ceil(polled / 3.0));
            k--;
        }
        return score;
    }
}
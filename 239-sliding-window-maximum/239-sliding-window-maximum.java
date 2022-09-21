class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> nums[b] - nums[a]);
        int i = 0;
        int j = 0;
        while(j < k){
            pq.add(j);
            j++;
        }
        j--;
        while(j < n){
            while(pq.peek() < i) pq.poll();
            if(pq.peek() >= i){
                ans[i] = nums[pq.peek()];
                i++;
                j++;
               if(j < n) pq.add(j);
            }
        }
        return ans;
    }
}
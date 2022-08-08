class Solution {
    public int maxResult(int[] nums, int k) {
       int[] accum = new int[nums.length];
       PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) ->b[1] - a[1]);
        int i = nums.length - 1;
        int[] arr = {i, nums[i]};
        pq.add(arr);
        accum[i] = nums[i];
        i--;
        while(i >= 0){
            while(pq.peek()[0] > i + k ) pq.poll();
            int check = nums[i] + pq.peek()[1];
            if(i == 0) return check;
             pq.add(new int[]{i, check});
              
        i--;
        }
       
        return pq.peek()[1];
    }
    
}
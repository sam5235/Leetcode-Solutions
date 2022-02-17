class Solution {
    public int shortestSubarray(int[] nums, int k) {
    Deque<Integer> dq = new ArrayDeque<>();
    long[] prefixSum = new long[nums.length + 1];
    prefixSum[0] = 0;
    for(int i = 0; i < nums.length; i++){
          prefixSum[i+1] = prefixSum[i] + nums[i]; 
    }
      

    int j = 0;
    int length = nums.length +1;
    while(j < prefixSum.length){
      
        
        while(!dq.isEmpty() && prefixSum[j] - prefixSum[dq.peekLast()] >= k){
            length = Math.min(length, j-dq.pollLast());
           
        }
        while(!dq.isEmpty() && prefixSum[dq.peekFirst()] >= prefixSum[j]){
            dq.pollFirst();
        }

            dq.push(j);
        
       
        j++;
    } 
        
        if(length == nums.length +1){
            return -1;
        }
    return length;
        
    }
}
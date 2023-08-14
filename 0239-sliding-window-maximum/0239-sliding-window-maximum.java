class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<int[]> maxOne = new PriorityQueue<>((a,b) -> b[1] - a[1]);
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        for(int i = 0, j = 0; j<n; j++){
            while(j<k){
                maxOne.add(new int[]{j,nums[j]});
                j++;
            }
            while(maxOne.peek()[0]< i){
                maxOne.poll();
            }
            ans[i] = maxOne.peek()[1];
            if(j<n)
                maxOne.add(new int[]{j,nums[j]});
            i++; 
        }
             while(maxOne.peek()[0]< n- k){
                maxOne.poll();
            }          

                              ans[n- k] = maxOne.peek()[1];
      
        return ans;
    }
}
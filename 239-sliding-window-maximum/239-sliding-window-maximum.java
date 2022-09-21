class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        ArrayDeque<Integer> deq = new ArrayDeque<>();
        int i = 0;
        int j = 0;
        while(j < k){
            while(!deq.isEmpty() && nums[j] >= nums[deq.peekLast()]) deq.removeLast();
            deq.addLast(j);
            j++;
        }
        j--;
        while(j < n){
            while(!deq.isEmpty() && nums[j] >= nums[deq.peekLast()]) deq.removeLast();
            deq.addLast(j);
            if(!deq.isEmpty() && deq.peekFirst() < i) deq.removeFirst();
            ans[i] = nums[deq.peekFirst()];
            i++;
            j++;
        }
        return ans;
    }
}
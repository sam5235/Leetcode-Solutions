class Solution {
    public int pivotIndex(int[] nums) {
        int postSum = 0;
        for(int t : nums) postSum += t;
        int preSum = 0;
        for(int i = 0; i < nums.length; i++){
            postSum -= nums[i];
            if(i >0) preSum += nums[i-1];
            if(postSum == preSum) return i;
        }
        return -1;
    }
}
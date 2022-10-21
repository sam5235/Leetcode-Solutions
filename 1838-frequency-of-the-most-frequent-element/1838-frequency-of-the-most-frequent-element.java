class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length, low = n - 1, high = n - 1;
        int sum = 0, max = 0;
        while(low >= 0){
            int ex = (high - low + 1) * nums[high];
            if(sum + nums[low] + k >= ex){
                max = Math.max(max, (high - low + 1));
                sum += nums[low];
                low--;
            }else{
                sum -= nums[high];
                high--;
            }
        }
        return max;
    }
}
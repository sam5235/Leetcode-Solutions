class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int i = n - 1;
        int j = n - 1;
        int sum = 0;
        int max = 0;
        while(i >= 0){
            int ex = (j - i + 1) * nums[j];
            if(sum + nums[i] + k >= ex){
                max = Math.max(max, (j - i + 1));
                sum += nums[i];
                i--;
            }else{
                
                sum -= nums[j];
                j--;
            }
        }
        return max;
    }
}
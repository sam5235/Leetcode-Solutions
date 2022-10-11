class Solution {
    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        int[] min = new int[n];
        int[] max = new int[n];
        min[0] = nums[0];
        max[n - 1] = nums[n-1];

        for(int i = 1, j = n - 2;j >= 0 && i < n; i++, j--){
            min[i] = Math.min(nums[i],min[i - 1]);
            max[j] = Math.max(nums[j], max[j + 1]);    
        }
       
        for(int i  = 1; i < n - 1; i++){
            if(min[i - 1] < nums[i] && nums[i] < max[i + 1]) 
                return true;
        }
        return false;
    }
}
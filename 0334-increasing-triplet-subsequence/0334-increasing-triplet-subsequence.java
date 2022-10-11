class Solution {
    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;   
        int first, second, third;
        first = second = third = Integer.MAX_VALUE;
        for(int i  = 0; i < n; i++){
          first = Math.min(first, nums[i]);
          if(nums[i] > first)
             second = Math.min(second, nums[i]); 
          if(nums[i] > second){
              third = Math.min(third, nums[i]);
              return true;
          }  
        }
        return false;
    }
}
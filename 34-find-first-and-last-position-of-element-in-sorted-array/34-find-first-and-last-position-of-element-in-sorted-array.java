class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0) return new int[]{-1,-1};
      int firstMid = 0;
      int low = 0;
      int high = nums.length - 1;
      int mid = 0;
        
      while(low <= high){
          mid  = low + (high - low)/2;
          if(nums[mid] > target){
              high = mid - 1;
          } else if(nums[mid] < target){
              low = mid + 1;
          }else {
              firstMid = mid;
              high = firstMid - 1;
          }
      }
        if(nums[firstMid] != target) return new int[]{-1,-1};
        low = firstMid;
        high = nums.length-1;
        int lastMid = 0;
        while(low <= high){
             mid  = low + (high - low)/2;
          if(nums[mid] > target){
              high = mid - 1;
          } else if(nums[mid] < target){
              low = mid + 1;
          }else {
              lastMid = mid;
             low = lastMid +1 ;
          }
        }
        int [] ans = {firstMid, lastMid};
        return ans;
    }
}


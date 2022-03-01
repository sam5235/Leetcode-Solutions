class Solution {
    public int search(int[] nums, int target) {
       int low = 0, high = nums.length - 1;
        int pivot = 0;
        while(low <= high){
            int mid = low + (high - low)/2;
            if((mid == 0 || nums[mid -1] > nums[mid]) &&  (mid == nums.length -1 || nums[mid] < nums[mid + 1])){
                pivot = mid;
                System.out.println(pivot);
                break;
            } else if(nums[mid] >= nums[0]){
                low = mid + 1;
            }else high = mid - 1;
        }
        low = 0;
        high = nums.length - 1;
        if(pivot > 0){
            if(target < nums[0]){
                low = pivot;
            }else if(target > nums[0]){
                high = pivot - 1;          
            }else return 0;
        }       
        
        while(low <= high){
            int mid = low + (high - low)/2;
            if(target > nums[mid]){
                low = mid + 1;
            }else if(target < nums[mid]){
                high = mid - 1;
            }else return mid;
        }
        return -1;
    }
}
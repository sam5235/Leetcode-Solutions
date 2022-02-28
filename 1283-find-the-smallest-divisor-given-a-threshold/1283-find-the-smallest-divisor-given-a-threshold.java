class Solution {
    public int smallestDivisor(int[] nums, int threshold) {     
        int low = 1;
        int high = 0;
          for(int num : nums){
           high = Math.max(high, num);
              }

        int ans = high;
        
        while(low <= high){
            int mid = low + (high - low)/2;
           double sum = sumCalc(mid, nums);
            if(sum > threshold){
                low = mid + 1;
            } else {
                high = mid - 1;
                ans = Math.min(ans, mid);
               
            }
        }
        return ans;
     
    }
    public double sumCalc(int mid, int[] nums){
       double sum = 0;
        for(int num: nums){
            sum += Math.ceil((double)num/(double)mid);
        }
        return sum;
    }
}
// 11:00
// 11 : 18
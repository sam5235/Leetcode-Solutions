class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long sum = 0;
        long zero = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                zero++;
            }else{
                sum += (((zero + 1) * zero)/2);
                zero = 0;
            }
        }
                sum += (((zero + 1) * zero)/2);
        return sum;
    }
}
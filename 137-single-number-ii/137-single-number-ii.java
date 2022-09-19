class Solution {
    public int singleNumber(int[] nums) {
       int ans = 0;
       for(int j = 0; j < 32; j++){
           int c = 0;
           for(int i  = 0; i < nums.length; i++){
               if((nums[i] & 1) == 1) c++;
               nums[i] >>= 1;
           }
           if(c % 3 != 0) ans += (1 << j);
       }
        return ans;
    }
}
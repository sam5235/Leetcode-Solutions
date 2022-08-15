class Solution {
    public void moveZeroes(int[] nums) {
        int i = 0;
        int j = 0;
        while(j < nums.length && i < nums.length){
            if(nums[i] != 0) i++;
            else if(nums[j] == 0) j++;
            else{
                if(j > i){
                    nums[i] = nums[j];
                    nums[j] = 0;
                    i++;  
                }else j = i;
            }
        }
    }
}
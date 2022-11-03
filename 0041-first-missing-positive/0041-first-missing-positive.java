class Solution {
    public int firstMissingPositive(int[] nums) {
      int i = 0;
        
        while(i < nums.length){
            if(nums[i] > 0 && nums[i] < nums.length && nums[i] != i + 1 && nums[nums[i] - 1] != nums[i]){
                int temp = nums[nums[i] - 1];
                nums[nums[i] -1] = nums[i];
                nums[i] = temp;
            }
            else i++;
        }
        
        for(int  j = 0; j < nums.length; j++){
            if(nums[j] != j + 1) return j + 1;
        }
        
        return nums.length + 1;
    }
}
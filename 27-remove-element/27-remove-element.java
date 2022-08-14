class Solution {
    public int removeElement(int[] nums, int val) {
         int intial = 0; 
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == val){
                intial++;
                nums[i] = -1;
            } 
        }
       
        
        int i = nums.length - 1;
        int j = nums.length - 1;
        while(j >= 0 && i >= 0){
            if(nums[j] != -1){
                j--;
            }else if(nums[i] == -1){
                i--;
            }else{
                if(j < i){   
                nums[j] = nums[i];
                nums[i] = -1;
                    i--;
                }else j = i;
            }
        }
       
        
        
        return nums.length -  intial;
    }
}
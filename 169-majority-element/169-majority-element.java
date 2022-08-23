class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int i = 0;
        int check = 1;
        while( i < nums.length - 1){
            if(nums[i] == nums[i + 1]){
                check++;
                if(check > (nums.length / 2)) return nums[i];
            }else{
                check = 1;
            }
            i++;
            
        }
        return 1;
    }
}
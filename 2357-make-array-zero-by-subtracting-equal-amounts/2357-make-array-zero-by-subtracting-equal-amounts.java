class Solution {
    public int minimumOperations(int[] nums) {
        Arrays.sort(nums);
        int oper = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0){
                int sub = nums[i];
                oper++;
                 for(int j = i; j < nums.length; j++){
                        nums[j] -= sub;
                  }
            }
        }
        return oper;
    }
}
class Solution {
    public int thirdMax(int[] nums) {
        long third = Long.MIN_VALUE, second = Long.MIN_VALUE, first = Long.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            if(first < nums[i]){
                third = second;
                second = first;
                first = nums[i];
            }
            else if(second < nums[i] && nums[i] != first){
                third = second;
                second = nums[i];
            }
            else if(third < nums[i] && nums[i] != second && nums[i] != first){
                third = nums[i];
            }
        }
        return third == Long.MIN_VALUE? (int)first:(int) third;
    }
}
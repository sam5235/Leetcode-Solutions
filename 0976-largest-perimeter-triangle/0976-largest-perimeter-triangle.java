class Solution {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        for(int i = nums.length - 1; i >= 2; i--){
            if(isTriangle(nums[i] , nums[i - 1], nums[i - 2])){
                return nums[i] + nums[i - 1] + nums[i - 2];
            }
        }
        return 0;
    }
    
    boolean isTriangle(int a, int b, int c){
        return a + b > c && a + c > b && b + c > a;
    }
}

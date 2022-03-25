class Solution {
    public long subArrayRanges(int[] nums) {
        long sum = 0;
        for( int i = 0; i < nums.length; i++){
            int j = i;
            int max = -1000000000;
            int min = 1000000000;
            while(j < nums.length){
                min = Math.min(min, nums[j]);
                max = Math.max(max, nums[j]);
                sum += (long)(max - min);
                j++;
            }
        }
        return sum;
    }
}

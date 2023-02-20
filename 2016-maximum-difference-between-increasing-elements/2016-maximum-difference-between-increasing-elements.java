class Solution {
    public int maximumDifference(int[] nums) {
        int min = nums[0];
        int result = -1;
        for (int i = 1; i<nums.length; i++)
        {
            if (nums[i] > min)
                result = Math.max(result, nums[i] - min);
            else
                min = Math.min(min, nums[i]);
        }
        
        return result;
    }
}
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int[] ans = new int[1];
        targSum(nums, 0, 0,ans, target);
        return ans[0];
    }
    void targSum(int[] nums, int idx, int sum,int[] paths, int target){
        if(idx == nums.length){
            if(sum == target) paths[0]++;
        return;
        }
        targSum(nums, idx + 1, (sum - nums[idx]), paths,target);
        targSum(nums, idx + 1, (sum + nums[idx]), paths, target);
    }
}
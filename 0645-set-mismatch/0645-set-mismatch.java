class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] ans = new int[2];
        HashSet<Integer> set = new HashSet<>();
        for(int i : nums)
            set.add(i);
        Arrays.sort(nums);
    
        for(int i = 0; i < nums.length; i++){
            if(!set.contains(i + 1)){
                ans[1] = i + 1;
            }
            if(i < nums.length - 1 && nums[i] == nums[i + 1])
                ans[0] = nums[i];
        }
        return ans;
    }
}
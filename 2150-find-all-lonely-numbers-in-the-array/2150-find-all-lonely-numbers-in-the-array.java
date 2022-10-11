class Solution {
    public List<Integer> findLonely(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        Arrays.sort(nums);
        if(nums.length ==1) ans.add(nums[0]);
        if(nums.length >= 2 && nums[0] != nums[1] && nums[0] + 1 != nums[1]){
            ans.add(nums[0]);
        }
        if(nums.length >= 2 && nums[nums.length - 1] != nums[nums.length - 2] && nums[nums.length - 1] - 1 != nums[nums.length - 2]){
            ans.add(nums[nums.length - 1]);
        }
        for(int i = 1; i < nums.length - 1; i++){
            if(nums[i] != nums[i + 1] && nums[i] + 1!= nums[i + 1] && nums[i] != nums[i - 1] && nums[i] - 1 != nums[i - 1] ){
                ans.add(nums[i]);
            }
        }
        return ans;
    }
}

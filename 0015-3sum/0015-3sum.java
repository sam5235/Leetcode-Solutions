class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> sums = new ArrayList<>();
        for(int i=0; i<nums.length;){
            while(i-1>=0&&i<nums.length&&nums[i]==nums[i-1]){
                i++;
            }
            int l=i+1, r=nums.length-1;
            while(i<nums.length&&l<r){
                if(nums[i]+nums[l]+nums[r]<0){
                    l++;
                }
                else if(nums[i]+nums[l]+nums[r]>0){
                    r--;
                }
                else{
                    sums.add(new ArrayList(Arrays.asList(nums[i],nums[l],nums[r])));
                    l++;
                    r--;                    
                    while(l<r && nums[l]==nums[l-1]){
                        l++;
                    }
                    while(r>l&&nums[r]==nums[r+1]){
                        r--;
                    }
                }
            }
                i++;
            
        }
        return sums;
    }
}
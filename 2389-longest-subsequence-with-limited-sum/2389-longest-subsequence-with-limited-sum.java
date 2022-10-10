class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        for(int i = 1; i < nums.length; i++){
            nums[i] = nums[i - 1] + nums[i];
        }
        int[] ans = new int[queries.length];
        for(int i = 0; i < queries.length; i++){
            int start = 0;
            int end = nums.length - 1;
            int max = 0;
            while(start <= end){
                int mid = start + (end - start)/2;
                if(nums[mid] <= queries[i]){
                    max = Math.max(max, nums[mid]);
                    if(max == nums[mid]) ans[i] = mid + 1;
                    start = mid + 1;
                }else end = mid - 1;
            }
        }
        return ans;
    }
}
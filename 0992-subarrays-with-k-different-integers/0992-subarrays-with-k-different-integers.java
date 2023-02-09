class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return helper(nums, k) - helper(nums, k -1);
    }
    
    int helper(int[] nums, int k){
        HashMap<Integer, Integer> distnict = new HashMap<>();
        int j = 0, subArr = 0;
        for(int i = 0; i < nums.length; i++){
            if(distnict.getOrDefault(nums[i], 0) == 0) k--;
            distnict.put(nums[i], distnict.getOrDefault(nums[i], 0) + 1);
            while(k < 0){
                distnict.put(nums[j], distnict.get(nums[j]) - 1);
                if(distnict.get(nums[j]) == 0) k++;
                j++;
            }
            subArr += i - j + 1;
        }
        return subArr;
    }
}


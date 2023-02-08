class Solution {
    public int jump(int[] nums) {
        int i = 0;
        int j = 0;
        int max = 0;
        int jumps = 0;
        int k = 0;
        if(nums.length == 1) return 0;
        while(j < nums.length){
            if(j <= i + nums[i]){
                j++;
                if(j >= nums.length - 1){
                    jumps++;
                    return jumps;
                }
                if(j < nums.length){
                    max = Math.max(max, (nums[j] + j));
                    if(max == nums[j] + j){
                    k = j; 
                //System.out.println(max);
                    } 
                    
                }
            }
                if(j == i + nums[i]){
                    jumps++;
                    i = k;
                    j = i;
                    max = 0;
                }
        }
        return jumps;
    }
}
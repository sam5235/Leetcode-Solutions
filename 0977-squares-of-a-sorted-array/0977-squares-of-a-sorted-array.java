class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length; 
        int[] res = new int[n];
        for(int i = 0; i < n; i++)
            nums[i] = (int) Math.pow(nums[i], 2);
        System.out.println(Arrays.toString(nums));
        int i = 0, j = n - 1, idx = n - 1;
        while(i <= j){
            if(nums[i] > nums[j]){
                res[idx] = nums[i];
                i++;
            }else{
                res[idx] = nums[j];
                j--;
            }
            idx--;            
        }
        return res;
    }
}
class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int[] neg = new int[n];
        int[] pos = new int[n];
        pos[n - 1] = nums[n - 1];
        neg[n - 1] = nums[n - 1];
        for(int i = n - 2; i >= 0 ; i--){
            pos[i] = Math.max(pos[i + 1] * nums[i], neg[i + 1] * nums[i]);
            pos[i] = Math.max(pos[i], nums[i]);
            neg[i] = Math.min(pos[i + 1] * nums[i], neg[i + 1] * nums[i]);
            neg[i] = Math.min(neg[i], nums[i]);
        }
        int max = nums[0];
        for(int i = 0; i < pos.length; i++){
            max = Math.max(max, pos[i]);
            max = Math.max(max, neg[i]);
        }
        return max;
    }
}
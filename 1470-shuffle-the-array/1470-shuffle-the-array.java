class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] ans = new int[n*2];
        int turn = 0;
        for(int i = 0, j = n; j < n *2; i++, j++){
            ans[turn] = nums[i];
            turn++;
            if(turn < 2*n)
                ans[turn] = nums[j];
            turn++;
        }
        return ans;
    }
}
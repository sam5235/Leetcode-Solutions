class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int i = 0, j = n - 1, maxL = 0, maxR = 0;
        
        while(i < n && j >= 0){
            maxL = Math.max(maxL, height[i]);
            maxR = Math.max(maxR, height[j]);
            left[i] = maxL;
            right[j] = maxR;
            i++;
            j--;            
        }
        int ans = 0;
        for(int k = 0; k < n; k++){
            ans += Math.min(left[k], right[k]) - height[k];
        }
        return ans;
    }
}
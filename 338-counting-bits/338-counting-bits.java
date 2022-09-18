class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        for(int i = 0; i <= n; i++){
            int c = 0;
            int num = i;
            while(num > 0){
                if((num & 1) == 1) c++;
                num >>= 1;
            }
            ans[i] = c;
        }
        return ans;
    }
}
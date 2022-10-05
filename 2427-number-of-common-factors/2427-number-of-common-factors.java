class Solution {
    public int commonFactors(int a, int b) {
        int small = a <= b ? a : b;
        int large = a >= b ? a : b;
        int ans = 0;
        for(int i = 1; i <= small; i++){
            if(small % i == 0 && large % i == 0) ans++;
        }
        return ans;
    }
}
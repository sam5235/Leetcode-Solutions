class Solution {
    public int hammingDistance(int x, int y) {
        int num = x ^ y;
        int ans = 0;
        while(num > 0){
            if((num & 1) == 1) ans++;
            num >>= 1;
        }
        return ans;
    }
}